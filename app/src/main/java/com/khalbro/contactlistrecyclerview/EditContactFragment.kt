package com.khalbro.contactlistrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.navArgs
import com.khalbro.contactlistrecyclerview.databinding.FragmentEditContactBinding

class EditContactFragment : Fragment() {

    init {
        getNoteById(id)
    }

    private var fragmentEditContactBinding: FragmentEditContactBinding? = null
    private val savedStateHandle = SavedStateHandle
    private lateinit var viewModel: EditContactViewModel
    private val args: EditContactFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_contact, container, false)
    }


    private fun getNoteById(id: Int) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentEditContactBinding.bind(view)
        fragmentEditContactBinding = binding
        val contact = args.argContact
        binding.tvIdContact.text = contact?.id.toString()
        binding.etNameContact.setText(contact?.name.toString())
        binding.etSurnameContact.setText(contact?.surname.toString())
        binding.etPhoneNumberContact.setText(contact?.phoneNumber.toString())

        binding.btnSave.setOnClickListener{

        }
    }
}