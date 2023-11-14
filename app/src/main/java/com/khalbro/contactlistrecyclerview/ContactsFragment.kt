package com.khalbro.contactlistrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khalbro.contactlistrecyclerview.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!
    private val contacts = ContactsStorage

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.rvContactsFragment
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        val contactAdapter = ContactsAdapter(
            listener = { contact ->
                contact.let {
                    val action = ContactsFragmentDirections
                        .actionContactsFragmentToEditContactFragment(contact)
                    findNavController().navigate(action)
                }
            },
            //TODO onLongClickListener = { }
        )
        recyclerView.adapter = contactAdapter

        binding.fabNewNote.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_contactsFragment_to_editContactFragment)
        }

        /** Подписываемся на хранилище контактов */
        contacts.currentContactLiveData.observe(viewLifecycleOwner) { contactList ->
            contactAdapter.submitList(contactList)
        }
    }
}