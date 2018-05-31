package radioshowslisting.radioshowslisting.main.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import radioshowslisting.radioshowslisting.R
import radioshowslisting.radioshowslisting.databinding.MainActivityBinding
import radioshowslisting.radioshowslisting.main.errors.MainErrorHandler
import javax.inject.Inject

class MainActivity @Inject constructor() : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainActivityBinding
    private lateinit var adapter: ShowsRecyclerViewAdapter

    @Inject
    internal lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var errorHandler: MainErrorHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory)[MainViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        adapter = ShowsRecyclerViewAdapter()
        setUpRecyclerViews()

        viewModel.radioShowsList.observe(this, Observer {
            it?.listRadioShows?.let {
                adapter.setItems(it)
            }
        })

        viewModel.errors.observe(this, Observer {
            it?.let { errorHandler.handleError(it) }
        })

    }

    private fun setUpRecyclerViews() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.isNestedScrollingEnabled = true
    }

}
