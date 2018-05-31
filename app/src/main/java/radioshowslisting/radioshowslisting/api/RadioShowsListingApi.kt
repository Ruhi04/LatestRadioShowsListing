package radioshowslisting.radioshowslisting.api

import io.reactivex.Observable
import radioshowslisting.radioshowslisting.main.data.models.ResponseContentJson
import retrofit2.http.GET

interface RadioShowsListingApi {

    @GET("http://api.sr.se/api/v2/programs?format=json&size=40")
    fun getShows(): Observable<ResponseContentJson>

}