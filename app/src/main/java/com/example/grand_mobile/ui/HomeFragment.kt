package com.example.grand_mobile.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.grand_mobile.AddChildActivity
import com.example.grand_mobile.R
import com.example.grand_mobile.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigasi ke AddChildActivity
        binding.btnHomeAddChild.setOnClickListener {
            val intent = Intent(requireContext(), AddChildActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke InfoFragment (WebView) untuk link https://grand.alwaysdata.net/
        binding.cardInfoWebsite.setOnClickListener {
            findNavController().navigate(R.id.nav_info)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
