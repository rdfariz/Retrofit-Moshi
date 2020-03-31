package org.d3if4127.jurnal09.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WordListData(
    val defaultWord: String?,
    val miwokWord: String?,
    val image: String?
) : Parcelable