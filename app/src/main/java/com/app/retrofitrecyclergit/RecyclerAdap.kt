package com.app.retrofitrecyclergit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.newsappcreate.modelclassfir.Article
import com.bumptech.glide.Glide

class RecyclerAdap(val context: Context, val list: List<Article>): RecyclerView.Adapter<RecyclerAdap.Viewholder>(){
    class Viewholder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val title=itemview.findViewById<TextView>(R.id.title)
        val desc=itemview.findViewById<TextView>(R.id.Description)
        val img=itemview.findViewById<ImageView>(R.id.image)
        val author=itemview.findViewById<TextView>(R.id.author)
        val links=itemview.findViewById<TextView>(R.id.link)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(context).inflate(R.layout.recylrview,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.title.text=list[position].title
        holder.desc.text=list[position].description
        Glide.with(context).load(list[position].urlToImage).into(holder.img)
        holder.author.text=list[position].url
        holder.links.text=list[position].publishedAt
    }


}