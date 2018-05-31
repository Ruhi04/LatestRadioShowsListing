package radioshowslisting.radioshowslisting.utils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import android.util.Log
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MediatorLiveData<T>() {

    companion object {
        private val TAG = "SingleLiveEvent"
    }

    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {

        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }

        super.observe(owner, Observer<T> {
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        })
    }

    @MainThread
    override fun setValue(t: T?) {
        pending.set(true)
        super.setValue(t)
    }

    @MainThread
    fun call() {
        value = null
    }
}

