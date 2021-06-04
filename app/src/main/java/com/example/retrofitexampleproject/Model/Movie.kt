package com.example.retrofitexampleproject.Model

import android.os.Parcel
import android.os.Parcelable

data class Movie(var name: String? = null,
                 var realname: String? = null,
                 var team: String? = null,
                 var firstapperance: String? = null,
                 var createdby: String? = null,
                 var publisher: String? = null,
                 var imageurl: String? = null,
                 var bio: String? = null): Parcelable{
    constructor(parcel: Parcel) : this(parcel.readString(),parcel.readString(),parcel.readString(),
            parcel.readString(),parcel.readString(),parcel.readString(),parcel.readString(),parcel.readString())

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(name)
        p0?.writeString(realname)
        p0?.writeString(team)
        p0?.writeString(firstapperance)
        p0?.writeString(createdby)
        p0?.writeString(publisher)
        p0?.writeString(imageurl)
        p0?.writeString(bio)
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }
    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}
