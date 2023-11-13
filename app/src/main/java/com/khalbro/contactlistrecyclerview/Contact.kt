package com.khalbro.contactlistrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    var id: Int,
    var phoneNumber: Long,
    var isSelected: Boolean,
    var name: String?,
    var surname: String?,
) : Parcelable