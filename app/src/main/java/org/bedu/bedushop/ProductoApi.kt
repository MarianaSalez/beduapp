package org.bedu.bedushop

import android.os.Parcel
import android.os.Parcelable

class ProductoApi (
    val title: String,
    val price: Float,
    val description: String,
    val rating: rating,
    val image: String,

    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readFloat()!!,
        parcel.readString()!!,
        parcel.readParcelable(org.bedu.bedushop.rating::class.java.classLoader)!!,
        parcel.readString()!!,

        ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeFloat(price)
        parcel.writeString(description)
        parcel.writeParcelable(rating, flags)
        parcel.writeString(image)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductoApi> {
        override fun createFromParcel(parcel: Parcel): ProductoApi {
            return ProductoApi(parcel)
        }

        override fun newArray(size: Int): Array<ProductoApi?> {
            return arrayOfNulls(size)
        }
    }
}