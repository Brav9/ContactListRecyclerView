package com.khalbro.contactlistrecyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.NO_POSITION

class ContactsAdapter(
    private val listener: (Contact) -> Unit
) : ListAdapter<Contact, ContactsViewHolder>(ContactDiffCallBack()) {
    var selectEnabled = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        return ContactsViewHolder.from(parent).apply {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != NO_POSITION) {
                    val contact: Contact = getItem(position)
                    listener(contact)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        getItem(position)?.let { contact ->
            holder.bind(contact, selectEnabled)
        }
    }
}

class ContactDiffCallBack : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}
