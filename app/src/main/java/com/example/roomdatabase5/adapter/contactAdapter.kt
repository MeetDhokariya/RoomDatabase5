package com.example.roomdatabase5.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.roomdatabase5.R
import com.example.roomdatabase5.databinding.ContactTileBinding
import com.example.roomdatabase5.db.ContactEntity

class contactAdapter(val contactList: List<ContactEntity>) : RecyclerView.Adapter<contactAdapter.contactViewHolder>() {

    class contactViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding = ContactTileBinding.bind(itemView)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_tile,parent,false)
        return contactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        holder.binding.txtname.setText("${contactList[position].name}")
        holder.binding.txtphone.setText("${contactList[position].phone}")

    }
}