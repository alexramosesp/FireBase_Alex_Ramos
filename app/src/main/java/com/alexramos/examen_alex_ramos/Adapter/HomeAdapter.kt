package com.alexramos.examen_alex_ramos.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexramos.examen_alex_ramos.R
import com.alexramos.examen_alex_ramos.data.Moble

class HomeAdapter(private val mList: List<Moble>, private val onItemClick: (Moble) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_moble, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val moble = mList[position]

        holder.textViewNom.text = moble.name
        holder.textViewPreu.text = moble.price.toString()

        holder.itemView.setOnClickListener { onItemClick(moble) }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNom)
        val textViewPreu: TextView = itemView.findViewById(R.id.textViewPreu)
    }
}