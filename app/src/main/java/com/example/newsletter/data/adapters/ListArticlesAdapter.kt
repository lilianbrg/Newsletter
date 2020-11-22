package com.example.newsletter.data.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.newsapp.models.Utils
import com.example.newsletter.R
import com.example.newsletter.models.Article
import com.example.newsletter.models.ArticleResponse

class ListArticlesAdapter(
        items: ArticleResponse, val handler: ListArticlesHandler
) : RecyclerView.Adapter<ListArticlesAdapter.ViewHolder>() {

    private val mArticles: ArticleResponse = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListArticlesAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mArticles.articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article: Article = mArticles.articles[position]

        holder.mArticleTitle.text = article.title
        holder.mArticleDescription.text = article.description
        holder.mArticleName.text    = article.author
        holder.mArticleDate.text = article.publishedAt
        holder.mArticleSource.text = article.source.name

        var requestOptions : RequestOptions = RequestOptions()
        requestOptions.placeholder(Utils.getRandomDrawbleColor())
        requestOptions.error(Utils.getRandomDrawbleColor())
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
        requestOptions.centerCrop()

        val context = holder.itemView.context
        // Display  Avatar
        Glide.with(context)
                .load(article.urlToImage)
                .apply(requestOptions).
                listener(object : RequestListener<Drawable?> {
                    override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            isFirstResource: Boolean
                    ): Boolean {
                        holder.mArticleProgressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                    ): Boolean {
                        holder.mArticleProgressBar.visibility = View.GONE
                        return false
                    }

                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.mArticleImage)
    }

    inner class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
        val mArticleImage: ImageView
        val mArticleName: TextView
        val mArticleTitle: TextView
        val mArticleDate: TextView
        val mArticleDescription: TextView
        val mArticleSource: TextView
        val mArticleTime: TextView
        val mArticleProgressBar : ImageView

        init {
            // Enable click on item
            mArticleImage = view.findViewById(R.id.img)
            mArticleName = view.findViewById(R.id.author)
            mArticleTitle = view.findViewById(R.id.title)
            mArticleDate = view.findViewById(R.id.publishedAt)
            mArticleDescription = view.findViewById(R.id.desc)
            mArticleSource = view.findViewById(R.id.source)
            mArticleTime = view.findViewById(R.id.time)
            mArticleProgressBar = view.findViewById(R.id.progress_load_photo)
        }
    }
}

