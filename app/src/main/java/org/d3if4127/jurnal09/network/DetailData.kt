package org.d3if4127.jurnal09.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailData(
    val listDetail: List<WordListData>
) : Parcelable