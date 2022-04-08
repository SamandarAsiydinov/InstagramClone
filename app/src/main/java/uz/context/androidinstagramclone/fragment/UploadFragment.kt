package uz.context.androidinstagramclone.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.context.androidinstagramclone.databinding.FragmentUploadBinding

/*
    In UploadFragment, user can upload
    a post with photo and caption
 */

class UploadFragment : BaseFragment() {

    private var _binding: FragmentUploadBinding? = null
    private val binding get() = _binding!!
    val TAG = this::class.java.simpleName

    var pickedPhoto: Uri? = null
    var allPhotos = ArrayList<Uri>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUploadBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initViews(view: View) {
        binding.apply {
            ivPick.setOnClickListener {
                pickFishBunPhoto()
            }
            ivClose.setOnClickListener {
                hidePickedPhoto()
            }
            ivUpload.setOnClickListener {
                uploadNewPost()
            }
        }
    }

    private fun pickFishBunPhoto() {

    }

    private fun hidePickedPhoto() {

    }

    private fun uploadNewPost() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}