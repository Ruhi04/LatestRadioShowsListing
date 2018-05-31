package radioshowslisting.radioshowslisting.main.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import radioshowslisting.radioshowslisting.R
import radioshowslisting.radioshowslisting.databinding.ListItemBinding
import radioshowslisting.radioshowslisting.main.models.RadioShowModel

class ShowsRecyclerViewAdapter(
        private val items: MutableList<RadioShowModel> = mutableListOf()
) : RecyclerView.Adapter<ShowsRecyclerViewAdapter.ShowsViewHolder>() {

    fun setItems(articles: List<RadioShowModel>) {
        this.items.clear()
        this.items.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.bindImage(items[position].thumbnailImageUrl)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemBinding>(
                inflater, R.layout.list_item, parent, false
        )
        return ShowsViewHolder(binding).listen { position, _ ->
            val item = items[position]
            binding.root.context.startActivity(Intent(binding.root.context, ShowDetailsActivity::class.java)
                    .apply {
                        putExtra("item", item)
                    })
        }

    }

    override fun getItemCount(): Int = items.size

    class ShowsViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindImage(url: String?) {
            url?.let {
                binding.image.loadImage(url)
            }
        }

        private fun ImageView.loadImage(url: String) {
            Glide.with(context)
                    .load(url)
                    .into(this)
        }
    }
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}

