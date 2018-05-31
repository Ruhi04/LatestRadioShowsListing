package radioshowslisting.radioshowslisting.main.mappers

import radioshowslisting.radioshowslisting.main.data.models.RadioShowJsonModel
import radioshowslisting.radioshowslisting.main.models.RadioShowModel
import javax.inject.Inject

class RadioShowsMapper @Inject constructor() {

    fun fromJson(json: RadioShowJsonModel): RadioShowModel {
        return RadioShowModel(
                imageUrl = json.imageUrl,
                name = json.name,
                description = json.description,
                editor = json.editor,
                channel = json.channel?.name,
                programUrl = json.programUrl,
                thumbnailImageUrl = json.thumbnailImageUrl
        )
    }

}