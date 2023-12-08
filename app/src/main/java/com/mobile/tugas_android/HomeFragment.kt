package com.mobile.tugas_android

import HomeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.tugas_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var adapter: HomeAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setTokoSayaAdapter()
        return binding.root
    }

    private fun setTokoSayaAdapter() {
        val dataList: MutableList<HomeModel> = mutableListOf()

        judul().forEachIndexed { index, judul ->
            dataList.add(HomeModel(image()[index], judul, harga()[index]))
        }

        // Inisialisasi adapter setelah membuat dataList
        adapter = HomeAdapter(dataList)

        // Atur RecyclerView
        binding.recylerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recylerview.adapter = adapter
    }

    private fun judul(): Array<String> = resources.getStringArray(R.array.judul)
    private fun harga(): Array<String> = resources.getStringArray(R.array.harga)
    private fun image(): List<Int> = listOf(
        R.drawable.img_item1,
        R.drawable.img_item2,
        R.drawable.img_item3,
        R.drawable.img_item4,
        R.drawable.img_item5,
        R.drawable.img_item6,
        R.drawable.img_item7
    )
}
