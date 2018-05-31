package radioshowslisting.radioshowslisting.main.mappers

import radioshowslisting.radioshowslisting.main.data.models.ResponseContentJson
import radioshowslisting.radioshowslisting.main.models.ResponseContent
import javax.inject.Inject

class ResponseContentMapper @Inject constructor(
        private val mapper: RadioShowsMapper
) {
    fun fromJson(json: ResponseContentJson): ResponseContent {
        return ResponseContent(
                listRadioShows = json.listRadioShows?.map { mapper.fromJson(it) }
        )
    }
}
