package com.walisaalam.class3.Final_Project.Data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "articles")
data class ArticleEntity(
    @PrimaryKey( autoGenerate = true)
    val id: Int = 0,
    val name: String ="",
    val description: String = "",
    val image: String = ""
): Parcelable {

    // Constructor that reads from Parcel
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
    )

    // Write data to parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(image)
    }

    // Return an integer describing the contents of the parcel (unused)
    override fun describeContents(): Int = 0

    // Parcelable Creator that creates instances of the Parcelable class from a Parcel
    companion object CREATOR : Parcelable.Creator<ArticleEntity> {
        override fun createFromParcel(parcel: Parcel): ArticleEntity = ArticleEntity(parcel)
        override fun newArray(size: Int): Array<ArticleEntity?> = arrayOfNulls(size)
    }
}

