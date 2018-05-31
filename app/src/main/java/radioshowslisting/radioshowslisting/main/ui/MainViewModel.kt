package radioshowslisting.radioshowslisting.main.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.rxkotlin.subscribeBy
import radioshowslisting.radioshowslisting.main.data.MainRepo
import radioshowslisting.radioshowslisting.main.mappers.ResponseContentMapper
import radioshowslisting.radioshowslisting.main.models.ResponseContent
import radioshowslisting.radioshowslisting.utils.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val repo: MainRepo,
        private val mapper: ResponseContentMapper
) : ViewModel() {

    private val _errors = SingleLiveEvent<Throwable>()
    val errors: LiveData<Throwable>
        get() {
            return _errors
        }

    private val _radioShowsList = MutableLiveData<ResponseContent>()
    val radioShowsList: LiveData<ResponseContent>
        get() {
            if (_radioShowsList.value == null) fetchList()
            return _radioShowsList
        }

    private fun fetchList() {
        repo.getShows()
                .map {
                    mapper.fromJson(it)
                }
                .subscribeBy(
                        onNext = {
                            _radioShowsList.value = it
                        },
                        onError = {
                            _errors.value = it
                        }
                )
    }

}
