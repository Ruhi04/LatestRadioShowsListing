package radioshowslisting.radioshowslisting.main.data.models

import com.squareup.moshi.Json

class ResponseContentJson(
        @field:Json(name = "programs") val listRadioShows: List<RadioShowJsonModel>?
)
