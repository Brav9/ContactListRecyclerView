package com.khalbro.contactlistrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khalbro.contactlistrecyclerview.databinding.ItemContactBinding

class ContactsViewHolder(private val binding: ItemContactBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(
        item: Contact,
        listener: ContactsAdapter.OnClickListener
    ) {
        binding.tvId.text = item.id.toString()
        binding.tvName.text = item.name.toString()
        binding.etSurnameContact.text = item.surname
        binding.tvPhoneNumber.text = item.phoneNumber.toString()
        itemView.setOnClickListener{
            listener.onItemClick(item)
        }
    }

    companion object {
        fun from(parent: ViewGroup): ContactsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemContactBinding.inflate(layoutInflater, parent, false)
            return ContactsViewHolder(binding)
        }
    }
}