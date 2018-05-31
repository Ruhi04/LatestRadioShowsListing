package radioshowslisting.radioshowslisting.main.models

import android.os.Parcel
import android.os.Parcelable

data class RadioShowModel(
        val name: String?,
        val description: String?,
        val editor: String?,
        val channel: String?,
        val programUrl: String?,
        val imageUrl: String?,
        val thumbnailImageUrl: String?

) : Parcelable {

    constructor(parcel: Parcel) : this(
            name = parcel.readString(),
            imageUrl = parcel.readString(),
            description = parcel.readString(),
            editor = parcel.readString(),
            channel = parcel.readString(),
            programUrl = parcel.readString(),
            thumbnailImageUrl = parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageUrl)
        parcel.writeString(description)
        parcel.writeString(editor)
        parcel.writeString(channel)
        parcel.writeString(programUrl)
        parcel.writeString(thumbnailImageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RadioShowModel> {
        override fun createFromParcel(parcel: Parcel): RadioShowModel {
            return RadioShowModel(parcel)
        }

        override fun newArray(size: Int): Array<RadioShowModel?> {
            return arrayOfNulls(size)
        }
    }
}