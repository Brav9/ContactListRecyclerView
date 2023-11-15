package com.khalbro.contactlistrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khalbro.contactlistrecyclerview.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!
    private val contacts = ContactsStorage
    private var menu: Menu? = null
    private var contactAdapter: ContactsAdapter? = null

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
        contactAdapter = ContactsAdapter(
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
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.menuDeleteContact -> selectEnable()
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        binding.fabNewNote.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_contactsFragment_to_editContactFragment)
        }

        binding.btnCancel.setOnClickListener{
            contactAdapter!!.apply {
                selectEnabled = false
                notifyDataSetChanged()
            }
            _binding!!.apply {
                btnCancel.visibility = View.GONE
                btnDelete.visibility =View.GONE
                fabNewNote.visibility = View.VISIBLE
            }
        }
        /** Подписываемся на хранилище контактов */
        contacts.currentContactLiveData.observe(viewLifecycleOwner) { contactList ->
            contactAdapter?.submitList(contactList)
        }
    }

    fun selectEnable() {
        contactAdapter!!.apply {
            selectEnabled = true
            notifyDataSetChanged()
        }
        _binding!!.apply {
            btnCancel.visibility = View.VISIBLE
            btnDelete.visibility =View.VISIBLE
            fabNewNote.visibility = View.GONE
        }
    }
}