package com.example.sosalud.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sosalud.R
import com.example.sosalud.databinding.ActivityRegister2Binding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class RegisterFragment: Fragment() {
    private var _binding: ActivityRegister2Binding? = null
    
    val firebase = Firebase.auth
    val realTimeData = Firebase.database.reference
    private lateinit var database: DatabaseReference


    private val binding get() = _binding!!

    data class User(val username: String? = null, val email: String? = null, val personalSalud: Boolean? = null) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }
    fun writeNewUser(name: String, email: String, personalSalud: Boolean ) {
        val user = User(name, email,personalSalud)
        val globalReference = realTimeData.child("users").child("global")
        globalReference.child(email.split(".")[0]).child("email").setValue(email)
        globalReference.child(email.split(".")[0]).child("personalSalud").setValue(personalSalud)
        globalReference.child(email.split(".")[0]).child("username").setValue(name)
    }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button4.setOnClickListener{
            val email = binding.editTextTextEmailAddress2.text.toString()
            val password = binding.editTextTextPassword2.text.toString()
            val username = binding.editTextTextPersonName.text.toString()
            var personalSalud = false

            if(email.isNotBlank() && password.isNotBlank() && username.isNotBlank()){
              firebase.createUserWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
                  if (task.isSuccessful){
                      Log.d("successful", firebase.currentUser.toString())
                      if(binding.checkBox.isChecked)
                          personalSalud = true
                      writeNewUser(username,email,personalSalud)
                      view.findNavController().navigate(R.id.action_activity_register_to_fragment_medservices)
                      val user = Firebase.auth.currentUser
                      val profileUpdates = userProfileChangeRequest {
                          displayName = username
                      }

                  }
                  else{
                      Log.w("error", "error", task.exception)

                      Toast.makeText(
                          requireActivity(),
                          "There was an error signing in" + task.exception?.message,
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