package radioshowslisting.radioshowslisting.main.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import radioshowslisting.radioshowslisting.R
import radioshowslisting.radioshowslisting.databinding.ShowsDetailViewBinding
import radioshowslisting.radioshowslisting.main.models.RadioShowModel

class ShowDetailsActivity : AppCompatActivity() {

    lateinit var binding: ShowsDetailViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.shows_detail_view)
        bindItem()

        binding.toolbar.setNavigationOnClickListener {
            this.finish()
        }
    }

    private fun bindItem() {
        val item = intent.extras.getParcelable<RadioShowModel>("item")
        binding.item = item
    }

}
