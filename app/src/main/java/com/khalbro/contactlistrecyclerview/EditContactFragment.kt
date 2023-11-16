package com.khalbro.contactlistrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.khalbro.contactlistrecyclerview.databinding.FragmentEditContactBinding

class EditContactFragment : Fragment() {

    private val contactsStorage = ContactsStorage
    private var fragmentEditContactBinding: FragmentEditContactBinding? = null
    private val args: EditContactFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentEditContactBinding.bind(view)
        fragmentEditContactBinding = binding
        val contact = args.argContact ?: Contact(
            id = -1,
            name = "",
            surname = "",
            isSelected = false,
            phoneNumber = ""
        )

        binding.etNameContact.setText(contact.name)
        binding.etSurnameContact.setText(contact.surname)
        binding.etPhoneNumberContact.setText(contact.phoneNumber)

        binding.btnSave.setOnClickListener {
            if (contact.id != -1) {
                contactsStorage.updateContact(
                    contact.copy(
                        name = binding.etNameContact.text.toString(),
                        surname = binding.etSurnameContact.text.toString(),
                        isSelected = false,
                        phoneNumber = binding.etPhoneNumberContact.text.toString()
                    )
                )
            } else {
                contactsStorage.addContact(
                    contact.copy(
                        name = binding.etNameContact.text.toString(),
                        surname = binding.etSurnameContact.text.toString(),
                        isSelected = false,
                        phoneNumber = binding.etPhoneNumberContact.text.toString()
                    )
                )
            }
            Navigation.findNavController(view)
                .navigate(R.id.action_editContactFragment_to_contactsFragment)
        }
    }
}