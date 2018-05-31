package radioshowslisting.radioshowslisting.main.data

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import radioshowslisting.radioshowslisting.api.RadioShowsListingApi
import radioshowslisting.radioshowslisting.main.data.models.ResponseContentJson
import javax.inject.Inject

class MainRepo @Inject constructor(private val api: RadioShowsListingApi) {

    fun getShows(): Observable<ResponseContentJson> =
            api.getShows()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { it }
}


