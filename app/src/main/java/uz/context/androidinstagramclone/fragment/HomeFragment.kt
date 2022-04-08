package uz.context.androidinstagramclone.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.context.androidinstagramclone.R
import uz.context.androidinstagramclone.databinding.FragmentHomeBinding
import java.lang.RuntimeException

class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var listener: HomeListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initViews() {
        binding.imageCamera.setOnClickListener {
            listener?.scrollToUpload()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is HomeListener) {
            context
        } else {
            throw RuntimeException("$context must implement HomeListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface HomeListener {
        fun scrollToUpload()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}