package radioshowslisting.radioshowslisting.main.data.models

import com.squareup.moshi.Json

data class RadioShowJsonModel(
        @field:Json(name = "name") val name: String?,
        @field:Json(name = "description") val description: String?,
        @field:Json(name = "responsibleeditor") val editor: String?,
        @field:Json(name = "channel") val channel: ChannelJsonModel?,
        @field:Json(name = "programurl") val programUrl: String?,
        @field:Json(name = "programimage") val imageUrl: String?,
        @field:Json(name = "programimagewide") val thumbnailImageUrl: String?
)