package com.example.sosalud.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sosalud.R
import com.example.sosalud.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.Auth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class LoginActivity : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!
    private lateinit var database : DatabaseReference
    private lateinit var  firebase : FirebaseAuth

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebase = FirebaseAuth.getInstance()
        binding.button3.setOnClickListener{
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            if(email.isNotBlank() && password.isNotBlank()){
                database = FirebaseDatabase.getInstance().getReference("users").child("global")
                firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful) {
                        database.child(email.split(".")[0]).child("personalSalud").get()
                            .addOnSuccessListener {
                                var esPersonal = it.value.toString().toBoolean()
                                if (esPersonal) {
                                    view.findNavController()
                                        .navigate(R.id.action_login_fragment_to_fragment_homecare)
                                } else {
                                    view.findNavController()
                                        .navigate(R.id.action_login_fragment_to_fragment_medservices)
                                }
                            }
                    }
                    else{
                        Log.w("error", "error", it.exception)

                        Toast.makeText(
                            requireActivity(),
                            "The user was not found" + it.exception?.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

