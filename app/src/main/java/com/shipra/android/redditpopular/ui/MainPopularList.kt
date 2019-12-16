package com.shipra.android.redditpopular.ui

import android.os.Parcel
import android.os.Parcelable

data class MainPopularList(
    val url: String,
    val title: String,
    val description: String,
    val category: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainPopularList> {
        override fun createFromParcel(parcel: Parcel): MainPopularList {
            return MainPopularList(parcel)
        }

        override fun newArray(size: Int): Array<MainPopularList?> {
            return arrayOfNulls(size)
        }
    }
}