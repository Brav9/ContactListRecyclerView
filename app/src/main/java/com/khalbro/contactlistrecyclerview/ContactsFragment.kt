package com.khalbro.contactlistrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khalbro.contactlistrecyclerview.databinding.FragmentContactsBinding

class ContactsFragment : Fragment(), ContactsAdapter.OnClickListener {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!
    private var contacts = ContactsStorage
    private var menu: Menu? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = contacts.getContactsData()

        val recyclerView: RecyclerView = binding.rvContactsFragment
        recyclerView.layoutManager = LinearLayoutManager(this@ContactsFragment.context)
        val contactAdapter = ContactsAdapter(item, this)
        recyclerView.adapter = contactAdapter


        binding.fabNewNote.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_contactsFragment_to_editContactFragment)
        }
    }

    override fun onItemClick(contact: Contact) {
        contact.let {
            val view: ContactsFragment = this
            val action =
                ContactsFragmentDirections.actionContactsFragmentToEditContactFragment(contact)
            view.findNavController().navigate(action)
        }
//        Navigation.findNavController(view)
//                    .navigate(R.id.action_contactsFragment_to_editContactFragment)
    }

    override fun onLongItemClick(contact: Contact) {
        TODO("Not yet implemented")
    }

}