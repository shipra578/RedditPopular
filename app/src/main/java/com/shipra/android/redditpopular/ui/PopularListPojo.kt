package com.shipra.android.redditpopular.ui

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "popular_table_detail", foreignKeys = [ForeignKey(entity = MainPopularListPojo::class, parentColumns = ["id"], childColumns = ["id_front"], onDelete = ForeignKey.NO_ACTION)])
data class PopularListPojo(

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "urlImage")
    val urlImage: String,

    @ColumnInfo(name = "commentsurl")
    val commentsurl: String,

    @ColumnInfo(name = "newsUrl")
    val newsUrl: String,

    @ColumnInfo(name = "mainUrl")
    val mainUrl: String,

    @ColumnInfo(name = "isFavourite")
    val isFavourite: Boolean,

    @ColumnInfo(name = "isSaveSelected")
    val isSaveSelected: Boolean,

    @ColumnInfo(name = "shareCount")
    val shareCount: Int,


    @ColumnInfo(name = "id_front")
    val id_front: String

) : Comparable<PopularListPojo>, Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(description)
        p0?.writeString(urlImage)
        p0?.writeString(commentsurl)
        p0?.writeString(newsUrl)
        p0?.writeString(mainUrl)
        p0?.writeByte(if (isFavourite) 1 else 0)
        p0?.writeByte(if (isSaveSelected) 1 else 0)
        p0?.writeInt(shareCount)
        p0?.writeString(id_front)
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
