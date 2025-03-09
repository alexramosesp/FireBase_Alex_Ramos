package com.alexramos.examen_alex_ramos.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alexramos.examen_alex_ramos.databinding.FragmentUpdateUserBinding
import com.google.firebase.firestore.FirebaseFirestore

class UpdateUserFragment : Fragment() {
    private lateinit var binding: FragmentUpdateUserBinding
    private lateinit var firestore: FirebaseFirestore
    private var userId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateUserBinding.inflate(inflater, container, false)
        firestore = FirebaseFirestore.getInstance()

        userId = arguments?.getString("userId")

        if (userId != null) {
            loadUserData(userId!!)
        } else {
            Toast.makeText(requireContext(), "User ID not found", Toast.LENGTH_SHORT).show()
        }

        binding.buttonUpdate.setOnClickListener {
            val newUsername = binding.editUsername.text.toString()
            val newEmail = binding.editEmail.text.toString()

            if (newUsername.isNotEmpty() && newEmail.isNotEmpty()) {
                updateUser(userId!!, newUsername, newEmail)
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun loadUserData(userId: String) {
        firestore.collection("users").document(userId).get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    binding.editUsername.setText(document.getString("username"))
                    binding.editEmail.setText(document.getString("email"))
                }
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "Error loading user", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUser(userId: String, username: String, email: String) {
        val updatedData = mapOf(
            "username" to username,
            "email" to email
        )

        firestore.collection("users").document(userId)
            .update(updatedData)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "User updated!", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "Update failed", Toast.LENGTH_SHORT).show()
            }
    }
}
