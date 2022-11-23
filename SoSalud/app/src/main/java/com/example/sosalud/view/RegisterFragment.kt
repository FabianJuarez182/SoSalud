package com.example.sosalud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sosalud.R
import com.example.sosalud.databinding.ActivityRegister2Binding

class RegisterFragment: Fragment() {
    private var _binding: ActivityRegister2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = ActivityRegister2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        setupNavigation(root)
        return root
    }

    private fun setupNavigation(root: View) {
        val register = root.findViewById<Button>(R.id.button4)
        register.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_activity_register_to_fragment_medservices)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}