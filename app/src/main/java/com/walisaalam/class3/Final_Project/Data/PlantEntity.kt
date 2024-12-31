package com.walisaalam.class3.Final_Project.Data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "plants")
data class PlantEntity (
    @PrimaryKey( autoGenerate = true)
    val id: Int = 0,
    val name: String ="",
    val scientific_name: String = "",
    val category: String = "",
    val description: String = "",
    val image: String = "",
    val light: String = "",
    val water: String = "Unknown",
    val toxicity: String = "Unknown",
    val humidity: String = "Unknown",
    val overview: String = "Unknown"
): Parcelable{

    // Constructor that reads from Parcel
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "Unknown",
        parcel.readString() ?: "Unknown",
        parcel.readString() ?: "Unknown",
        parcel.readString() ?: "Unknown"
    )

    // Write data to parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(scientific_name)
        parcel.writeString(category)
        parcel.writeString(description)
        parcel.writeString(image)
        parcel.writeString(light)
        parcel.writeString(water)
        parcel.writeString(toxicity)
        parcel.writeString(humidity)
        parcel.writeString(overview)
    }

    // Return an integer describing the contents of the parcel (unused)
    override fun describeContents(): Int = 0

    // Parcelable Creator that creates instances of the Parcelable class from a Parcel
    companion object CREATOR : Parcelable.Creator<PlantEntity> {
        override fun createFromParcel(parcel: Parcel): PlantEntity = PlantEntity(parcel)
        override fun newArray(size: Int): Array<PlantEntity?> = arrayOfNulls(size)
    }
}
