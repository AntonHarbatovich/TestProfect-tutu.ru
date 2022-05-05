package com.example.newsapp.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.databinding.ItemHeadlineBinding
import com.squareup.picasso.Picasso

class HeadlineViewHolder(
    private val binding: ItemHeadlineBinding,
    private val adapter: HeadlineAdapter
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.itemHeadlineTitle.text = article.title
        binding.itemHeadlineSource.text = article.source.name
        loadImage(article.urlToImage)
    }

    private fun loadImage(url: String?) {
        if (url != null) {
            Picasso.get().load(url).into(binding.itemHeadlineImage)
        }
    }

}