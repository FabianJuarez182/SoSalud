package com.example.sosalud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sosalud.R
import com.example.sosalud.adapter.ItemMenuAdapter
import com.example.sosalud.data.DataServices
import com.example.sosalud.databinding.MenuFragmentBinding

class MenuAct: Fragment() {
    private var _binding: MenuFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val MedServices = DataServices().loadServices()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewServiciosPaciente)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = ItemMenuAdapter(this, MedServices)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}