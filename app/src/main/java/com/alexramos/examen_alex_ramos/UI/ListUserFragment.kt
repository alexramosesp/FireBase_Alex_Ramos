package com.alexramos.examen_alex_ramos.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import com.alexramos.examen_alex_ramos.R
import com.alexramos.examen_alex_ramos.databinding.FragmentListUserBinding
import com.alexramos.examen_alex_ramos.models.User
import com.google.firebase.firestore.FirebaseFirestore

class ListUsersFragment : Fragment() {
    private lateinit var binding: FragmentListUserBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListUserBinding.inflate(inflater, container, false)
        firestore = FirebaseFirestore.getInstance()

        setupRecyclerView()
        loadUsers()

        return binding.root
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(userList) { selectedUser ->
            val bundle = Bundle()
            bundle.putString("userId", selectedUser.id)
            findNavController().navigate(R.id.updateUserFragment, bundle)
        }
        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewUsers.adapter = userAdapter
    }


    private fun loadUsers() {
        firestore.collection("users").get()
            .addOnSuccessListener { result ->
                userList.clear()
                for (document in result) {
                    val user = User(
                        id = document.id,
                        username = document.getString("username") ?: "",
                        email = document.getString("email") ?: ""
                    )
                    userList.add(user)
                }
                userAdapter.notifyDataSetChanged()
                Log.d("ListUsersFragment", "Users loaded: ${userList.size}") // Agregar un log
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "Error loading users", Toast.LENGTH_SHORT).show()
            }
    }


}
