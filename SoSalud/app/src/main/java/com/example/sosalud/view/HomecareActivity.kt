package com.example.sosalud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomecareBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        val root = inflater.inflate(R.layout.fragment_homecare, container, false)
        setupNavigation(root)
        return root
    }

    private fun setupNavigation(root: View) {
        val atender = root.findViewById<Button>(R.id.button6)
        atender.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragment_homecare_to_fragment_medservices)
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val HomecareServices = DataPersons().loadPersons()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewHomeCare)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = HomecareAdapter(this, HomecareServices)
        binding.button6.setOnClickListener {
            view.findNavController().navigate(R.id.action_fragment_homecare_to_fragment_medservices)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}