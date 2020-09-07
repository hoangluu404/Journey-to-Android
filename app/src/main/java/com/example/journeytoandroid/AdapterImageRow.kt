import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ImageView.*
import androidx.recyclerview.widget.RecyclerView
import com.example.journeytoandroid.AdapterEventAboutMe
import com.example.journeytoandroid.Post
import com.example.journeytoandroid.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_first_project.*
import kotlinx.android.synthetic.main.rv_images_row.view.*
import kotlinx.android.synthetic.main.rv_item.view.*

class AdapterImageRow(var posts: List<Post>) : RecyclerView.Adapter<AdapterImageRow.RowViewHolder>() {



    inner class RowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterImageRow.RowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_images_row, parent, false)
        return RowViewHolder(view)

    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.itemView.apply{
            Picasso.with(context).load(posts[position].display_url).into(ivPic)
            if(posts[position].id == "private"){

                tvCaption.visibility = View.GONE
                tvNumLikes.visibility = View.GONE
                tvNumComments.visibility = View.GONE


            } else {
                if(posts[position].caption.isNotEmpty())
                    tvCaption.text = posts[position].username + ": " + posts[position].caption
                else
                    tvCaption.visibility = View.GONE
                tvNumLikes.text = posts[position].like + " Likes"
                tvNumComments.text = posts[position].comment + " Comments"

            }
        }
    }
}