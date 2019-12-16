package com.shipra.android.redditpopular.ui

import android.os.Parcel
import android.os.Parcelable

data class PopularListPojo(val description: String,val urlImage: String , val commentsurl : String , val isFavourite: Boolean) :  Comparable<PopularListPojo>, Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(description)
        p0?.writeString(urlImage)
        p0?.writeString(commentsurl)
        p0?.writeByte(if (isFavourite) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PopularListPojo> {
        override fun createFromParcel(parcel: Parcel): PopularListPojo {
            return PopularListPojo(parcel)
        }

        override fun newArray(size: Int): Array<PopularListPojo?> {
            return arrayOfNulls(size)
        }
    }

    /**
     * Compares this object with the specified object for order. Returns zero if this object is equal
     * to the specified [other] object, a negative number if it's less than [other], or a positive number
     * if it's greater than [other].
     */
    override fun compareTo(other: PopularListPojo): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
