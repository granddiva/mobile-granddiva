package com.example.grand_mobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.grand_mobile.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pertemuan 7: Penerapan ListView
        val dataAnak = arrayOf(
            "Budi Santoso - Laki-laki",
            "Siti Aminah - Perempuan",
            "Andi Wijaya - Laki-laki",
            "Lani Lestari - Perempuan",
            "Rizky Pratama - Laki-laki"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dataAnak)
        binding.listView.adapter = adapter

        // Pertemuan 2: Event Listener
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            // Pertemuan 4: Toast
            Toast.makeText(requireContext(), "Memilih: ${dataAnak[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
