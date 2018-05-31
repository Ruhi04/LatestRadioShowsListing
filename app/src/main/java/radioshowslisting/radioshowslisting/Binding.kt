package radioshowslisting.radioshowslisting

import android.content.Intent
import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

object Binding {

    @JvmStatic
    @BindingAdapter("app:onClickUrl")
    fun setOnClickUrl(view: TextView, url: String?) {
        url?.let {
            view.setOnClickListener {
                view.context.startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(url)
                })
            }
        }
    }

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(view: ImageView, imageUrl: String?) {
        imageUrl?.let {
            Glide.with(view)
                    .load(it)
                    .into(view)
        }
    }
}
