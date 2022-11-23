package com.example.sosalud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sosalud.R
import com.example.sosalud.adapter.ItemAdapter
import com.example.sosalud.data.DataServices
import com.example.sosalud.databinding.FragmentMedservicesBinding

class MedServicesActivity: Fragment() {
    private var _binding: FragmentMedservicesBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_medservices, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val MedServices = DataServices().loadServices()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMed)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = ItemAdapter(this, MedServices)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}