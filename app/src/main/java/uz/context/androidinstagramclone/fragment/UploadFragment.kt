package uz.context.androidinstagramclone.fragment

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter
import uz.context.androidinstagramclone.databinding.FragmentUploadBinding
import uz.context.androidinstagramclone.util.Utils
import uz.context.androidinstagramclone.util.Utils.log
import uz.context.androidinstagramclone.util.toast
import java.lang.RuntimeException

/*
    In UploadFragment, user can upload
    a post with photo and caption
 */

class UploadFragment : BaseFragment() {

    private var _binding: FragmentUploadBinding? = null
    private val binding get() = _binding!!
    val TAG = this::class.java.simpleName

    private var listener: UploadListener? = null

    var pickedPhoto: Uri? = null
    var allPhotos = ArrayList<Uri>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUploadBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initViews() {
        binding.apply {
            flView.setOnClickListener {
                pickFishBunPhoto()
                //checkUpload()
            }
            ivClose.setOnClickListener {
                hidePickedPhoto()
            }
            ivUpload.setOnClickListener {
                uploadNewPost()
            }
        }
        //checkUpload()
    }

    private fun checkUpload() {
        binding.ivUpload.isVisible = binding.editText.text.toString().isNotEmpty() && pickedPhoto != null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is UploadListener) {
            context
        } else {
            throw RuntimeException("$context must implement UploadListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun setViewHeight(view: View) {
        val params: ViewGroup.LayoutParams = view.layoutParams
        params.height = Utils.screenSize(requireActivity().application).width
        view.layoutParams = params
    }

    private fun pickFishBunPhoto() {
        FishBun.with(this)
            .setImageAdapter(GlideAdapter())
            .setMaxCount(1)
            .setMinCount(1)
            .setSelectedImages(allPhotos)
            .startAlbumWithActivityResultCallback(photoLauncher)
    }

    private val photoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            allPhotos = it.data?.getParcelableArrayListExtra(FishBun.INTENT_PATH) ?: arrayListOf()
            pickedPhoto = allPhotos[0]
            showPickedPhoto()
        }
    }

    private fun hidePickedPhoto() {
        pickedPhoto = null
        binding.flPhoto.isVisible = false
        binding.flView.isVisible = true
    }

    private fun uploadNewPost() {
        val caption = binding.editText.text.toString().trim()
        if (caption.isNotEmpty() && pickedPhoto != null) {
            listener!!.scrollToHome()
            log(TAG, caption)
            log(TAG, pickedPhoto?.path.toString())
            resetAll()
        } else {
            toast("Enter caption")
        }
    }

    private fun showPickedPhoto() {
        binding.flView.isVisible = false
        binding.flPhoto.isVisible = true
        binding.ivPhoto.setImageURI(pickedPhoto)
    }

    private fun resetAll() {
        binding.apply {
            editText.text?.clear()
            pickedPhoto = null
            flPhoto.isVisible = false
            flView.isVisible = true
        }
    }

    interface UploadListener {
        fun scrollToHome()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}