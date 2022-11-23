package com.example.sosalud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sosalud.R
import com.example.sosalud.databinding.FragmentLoginBinding

class LoginActivity : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        setupNavigation(root)
        return root
    }

    private fun setupNavigation(root: View) {
        val loginButton2 = root.findViewById<Button>(R.id.button3)
        loginButton2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_login_fragment_to_fragment_medservices)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

