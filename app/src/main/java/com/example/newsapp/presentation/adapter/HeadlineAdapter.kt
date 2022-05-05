package com.example.newsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.data.api.entity.response.Article

class HeadlineAdapter : RecyclerView.Adapter<HeadlineViewHolder>() {

    private val listArticles: List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HeadlineViewHolder(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_headline,
                parent,
                false
            ), this
        )
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        holder.bind(listArticles[position])
    }

    override fun getItemCount(): Int = listArticles.size
}