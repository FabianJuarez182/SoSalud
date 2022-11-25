package com.example.sosalud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sosalud.R
import com.example.sosalud.adap.HomecareAdapter
import com.example.sosalud.adapter.ItemAdapter
import com.example.sosalud.data.DataPersons
import com.example.sosalud.data.DataServices
import com.example.sosalud.databinding.FragmentHomecareBinding

class HomecareActivity: Fragment() {
    private var _binding: FragmentHomecareBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_homecare, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val HomecareServices = DataPersons().loadPersons()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewHomeCare)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = HomecareAdapter(this, HomecareServices)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}