package com.example.sosalud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sosalud.R
import com.example.sosalud.adapter.ItemAdapter
import com.example.sosalud.data.DataServices
import com.example.sosalud.databinding.FragmentLoginBinding
import com.example.sosalud.databinding.FragmentMedservicesBinding
import com.example.sosalud.model.Services

class MedServicesActivity: Fragment(R.layout.fragment_medservices), ItemAdapter.imageViewListener {
    private var _binding: FragmentMedservicesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedservicesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        val root = inflater.inflate(R.layout.fragment_medservices, container, false)
        setupNavigation(root)
        return root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val MedServices = DataServices().loadServices()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMed)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = ItemAdapter(this, MedServices)
        binding.button7.setOnClickListener {
            view.findNavController().navigate(R.id.action_fragment_medservices_to_fragment_homecare)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupNavigation(root: View) {
        val ImageClickable = root.findViewById<ImageView>(R.id.item_image)
        ImageClickable.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragment_medservices_to_fragment_homecare)
        }
    }

    override fun onImageViewClicked(medServices: Services, position: Int) {
        view?.findNavController()?.navigate(R.id.action_fragment_medservices_to_fragment_homecare)
    }
}