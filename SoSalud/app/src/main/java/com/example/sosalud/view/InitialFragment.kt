package com.example.sosalud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sosalud.R
import com.example.sosalud.databinding.InitialActivityBinding

class InitialFragment : Fragment(){
    private var _binding: InitialActivityBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        val root = inflater.inflate(R.layout.initial_activity, container, false)
        setupNavigation(root)
        return root
    }
    private fun setupNavigation(root: View) {
        val loginButton = root.findViewById<Button>(R.id.button2)
        val singUpButton = root.findViewById<Button>(R.id.button)
        loginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_InitialFragment_to_login_fragment)
        }
        singUpButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_InitialFragment_to_activity_register)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}