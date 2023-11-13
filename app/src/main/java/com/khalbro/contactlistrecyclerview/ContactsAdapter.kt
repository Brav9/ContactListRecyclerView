package com.khalbro.contactlistrecyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil

class ContactsAdapter(
    private val contactList: ArrayList<Contact>,
    private val listener: ContactsFragment
) :
    ListAdapter<Contact, ContactsViewHolder>(ContactDiffCallBack()) {

    interface OnClickListener {
        fun onItemClick(contact: Contact)
        fun onLongItemClick(contact: Contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        return ContactsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contacts = contactList[position]
        holder.bind(contacts, listener)
//        holder.itemView.setOnClickListener { v ->
//            if (v != null) {
//                Navigation.findNavController(v)
//                    .navigate(R.id.action_contactsFragment_to_editContactFragment)
//
//            }
//        }

    }

    override fun getItemCount(): Int {
        return contactList.size
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
