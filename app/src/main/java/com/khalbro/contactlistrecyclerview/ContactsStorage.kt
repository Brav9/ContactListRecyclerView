package com.khalbro.contactlistrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object ContactsStorage {

    private val _currentContactLiveData = MutableLiveData<List<Contact>>()
    val currentContactLiveData: LiveData<List<Contact>> = _currentContactLiveData

    private val contactList = listOf(
        Contact(1, "+800012888897", false, "Ann", "Lee"),
        Contact(2, "+800012548885", false, "Misha", "Milof"),
        Contact(3, "+800012548897", false, "Den", "Gause"),
        Contact(4, "+800012500097", false, "Olga", "Mitova"),
        Contact(5, "+800012008897", false, "Dima", "Prokofev"),
        Contact(6, "+800012548897", false, "Artur", "Mig"),
        Contact(7, "+800012548007", false, "Ivan", "Durunov"),
        Contact(8, "+800012547777", false, "Ignat", "Miheev"),
        Contact(9, "+800012548999", false, "Konstantine", "Ivel"),
        Contact(10, "+800012544144", false, "Sergey", "Stone"),
        Contact(11, "+800012547854", false, "Tom", "Cat"),
        Contact(12, "+80009875296", false, "Jerry", "Mouse"),
        Contact(13, "+900074158966", false, "Om", "Ist"),
        Contact(14, "+800078925147", false, "Ann", "West"),
        Contact(15, "+753159852444", false, "Den", "Ghost"),
        Contact(16, "+800012345685", false, "Sergey", "Ferunov"),
        Contact(17, "+800753258969", false, "Via", "Laviva"),
        Contact(18, "+900011224545", false, "Dima", "Petrov"),
        Contact(19, "+900012548897", false, "Lisa", "Socrul"),
        Contact(20, "+900012548897", false, "Colt", "Mag"),
        Contact(21, "+900012548897", false, "Ann", "Turuc"),
        Contact(22, "+890404888897", false, "Vlad", "Fersov"),
        Contact(23, "+900087878897", false, "Misha", "Lee"),
        Contact(24, "+900012579799", false, "Ann", "Tomsk"),
        Contact(25, "+800012878760", false, "Tom", "Ford"),
        Contact(26, "+800010101111", false, "Ann", "Introva"),
        Contact(27, "+800010557000", false, "Ann", "Bird"),
        Contact(28, "+800017853640", false, "Jerry", "Mee"),
        Contact(29, "+800045737878", false, "Artur", "First"),
        Contact(30, "+808888548897", false, "Sergey", "Last"),
        Contact(31, "+80089688975", false, "Lisa", "Past"),
        Contact(32, "+800012548888", false, "Boris", "Elis"),
        Contact(33, "+800012548875", false, "Vladimir", "Putin"),
        Contact(34, "+800757550007", false, "Ann", "Mag"),
        Contact(35, "+800087867622", false, "Ann", "Lee"),
        Contact(36, "+800808087880", false, "Vladimir", "Lee"),
        Contact(37, "+900012548033", false, "Ann", "Astova"),
        Contact(38, "+900012537877", false, "Via", "Bridge"),
        Contact(39, "+800012548897", false, "Colt", "Molotov"),
        Contact(40, "+807001254889", false, "Lisa", "Moiseeva"),
        Contact(41, "+800010002548", false, "Ann", "Reader"),
        Contact(42, "+800012897570", false, "Om", "Ton"),
        Contact(43, "+802547300076", false, "Olga", "Skabeeva"),
        Contact(44, "+800012548897", false, "Dima", "Grom"),
        Contact(45, "+900012547823", false, "Sergey", "Lapin"),
        Contact(46, "+800012548897", false, "Ann", "Aristova"),
        Contact(47, "+800012548897", false, "Ann", "Guseeva"),
        Contact(48, "+800012548897", false, "Vladimir", "Monomax"),
        Contact(49, "+800012573838", false, "Sergey", "Lee"),
        Contact(50, "+900012548897", false, "Ignat", "Socrul"),
        Contact(51, "+808012548897", false, "Misha", "Lee"),
        Contact(52, "+800012548897", false, "Sergey", "Tomsk"),
        Contact(53, "+800012548897", false, "Om", "Lee"),
        Contact(54, "+800012548897", false, "Lisa", "Prokofev"),
        Contact(55, "+800012548897", false, "Ann", "Skabeeva"),
        Contact(56, "+800012548897", false, "Jerry", "Ant"),
        Contact(57, "+800012548897", false, "Konstantine", "Molotov"),
        Contact(58, "+800012548897", false, "Sergey", "Prokofev"),
        Contact(59, "+800012548897", false, "Sergey", "Sornov"),
        Contact(60, "+900012548897", false, "Tom", "Been"),
        Contact(61, "+800012548897", false, "Sergey", "Lin"),
        Contact(62, "+800012548897", false, "Colt", "Menov"),
        Contact(62, "+800083833333", false, "Vladimir", "Issaev"),
        Contact(63, "+800444444444", false, "Ivan", "Art"),
        Contact(64, "+800052228282", false, "Boris", "Ostov"),
        Contact(65, "+800012548897", false, "Via", "Nextova"),
        Contact(66, "+800018222223", false, "Dimir", "Mur"),
        Contact(67, "+800012588878", false, "Ann", "Dorri"),
        Contact(68, "+800012548897", false, "Ann", "Viva"),
        Contact(69, "+888883283838", false, "Sergey", "Grom"),
        Contact(70, "+900012548897", false, "Vlad", "Len"),
        Contact(71, "+800012548897", false, "Vlad", "Osinov"),
        Contact(72, "+800778355553", false, "Den", "D"),
        Contact(73, "+800012548897", false, "Ignat", "Taganka"),
        Contact(74, "+800012548897", false, "Sergey", "Orlov"),
        Contact(75, "+800012548897", false, "Tom", "Ivanov"),
        Contact(76, "+800012548897", false, "Ann", "Ivanov"),
        Contact(77, "+800012548897", false, "Boris", "Titov"),
        Contact(78, "+800012738333", false, "Vladimir", "Leem"),
        Contact(79, "+800012548777", false, "Dima", "Saur"),
        Contact(80, "+800012548333", false, "Lisa", "Sorry"),
        Contact(81, "+800012543783", false, "Dimir", "Oler"),
        Contact(82, "+800012548897", false, "Vlad", "Grom"),
        Contact(83, "+800012839383", false, "Jerry", "Socrul"),
        Contact(84, "+800012548897", false, "Ann", "Saur"),
        Contact(85, "+800012554558", false, "Vladimir", "Monovax"),
        Contact(86, "+800012548897", false, "Ann", "Osy"),
        Contact(87, "+800012548897", false, "Olga", "Ost"),
        Contact(88, "+800012548897", false, "Ivan", "Grom"),
        Contact(89, "+800012548852", false, "Vlad", "Toy"),
        Contact(90, "+800012548112", false, "Vladimir", "Obev"),
        Contact(91, "+800012541233", false, "Ann", "Laner"),
        Contact(92, "+802050508897", false, "Boris", "Gun"),
        Contact(93, "+800012548897", false, "Misha", "Rustev"),
        Contact(94, "+800012548897", false, "Ann", "Boss"),
        Contact(95, "+800012548822", false, "Sergey", "Bridge"),
        Contact(96, "+800012548897", false, "Dima", "Ford"),
        Contact(97, "+800012548111", false, "Dimir", "Petrov"),
        Contact(98, "+800012502422", false, "Ann", "Lee"),
        Contact(99, "+800007070788", false, "Vlad", "Saur"),
        Contact(100, "+800000000070", false, "Den", "Past"),
        Contact(101, "+807777777897", false, "Konstantine", "Durunov")
    )

    init {
        loadContacts()
    }

    private fun loadContacts() {
        _currentContactLiveData.value = contactList
    }

    fun addContact(contact: Contact) {
        val current = currentContactLiveData.value ?: emptyList()
        val newId = current.last().id + 1
        _currentContactLiveData.postValue(
            current.toMutableList().apply {
                add(contact.copy(id = newId))
            }
        )
    }

    fun updateContact(contact: Contact) {
        val current = currentContactLiveData.value ?: emptyList()
        _currentContactLiveData.postValue(
            current.map { currentContact ->
                if (currentContact.id == contact.id) {
                    contact
                } else {
                    currentContact
                }
            }
        )
    }

    fun changeSelectState(contact: Contact) {
        val current = currentContactLiveData.value ?: emptyList()
        _currentContactLiveData.postValue(
            current.map { currentContact ->
                if (currentContact.id == contact.id) {
                    currentContact.copy(isSelected = !currentContact.isSelected)
                } else {
                    currentContact
                }
            })
    }

    fun deleteContacts() {
        val current = currentContactLiveData.value ?: emptyList()
        _currentContactLiveData.postValue(
            current.filter { !it.isSelected })
    }
    fun resetSelectState() {
        val current = currentContactLiveData.value ?: emptyList()
        _currentContactLiveData.postValue(
            current.map { currentContact ->
                    currentContact.copy(isSelected = false)
            })
    }
}



