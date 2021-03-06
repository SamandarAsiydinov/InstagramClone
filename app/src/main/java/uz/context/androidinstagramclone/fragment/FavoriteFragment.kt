package uz.context.androidinstagramclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.context.androidinstagramclone.R
import uz.context.androidinstagramclone.databinding.FragmentFavoriteBinding
import uz.context.androidinstagramclone.databinding.FragmentHomeBinding

class FavoriteFragment : BaseFragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun initViews(view: View) {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}