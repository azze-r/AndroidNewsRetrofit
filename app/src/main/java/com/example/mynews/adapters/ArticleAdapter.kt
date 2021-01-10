package com.example.mynews.adapters

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.R
import com.example.mynews.data.Articles
import com.example.mynews.ui.ArticlesListFragment
import com.example.mynews.utils.BaseListAdapter
import com.example.mynews.utils.ImageUtils
import kotlinx.android.synthetic.main.view_article.view.*


class ArticleAdapter(articlesListFragment: ArticlesListFragment) : BaseListAdapter<Articles>(){

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_article, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindChildViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repo = items[position]

        holder.itemView.apply {
            tvName.text = repo.title
            ImageUtils.loadImage(repo.urlToImage, R.mipmap.ic_launcher, picture)
        }

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
//            it.findNavController().navigate(R.id.action_navigation_repos_to_detail_repo,bundle)
        }
    }
}