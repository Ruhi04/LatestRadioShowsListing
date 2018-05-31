package radioshowslisting.radioshowslisting.main.data.models

import com.squareup.moshi.Json

data class ChannelJsonModel(
        @field:Json(name = "id") val id: Int,
        @field:Json(name = "name") val name: String
)
