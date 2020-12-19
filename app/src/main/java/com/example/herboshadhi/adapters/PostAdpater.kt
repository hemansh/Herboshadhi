package com.example.herboshadhi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.herboshadhi.CellClickListener
import com.example.herboshadhi.PostModel
import com.example.herboshadhi.R
import com.squareup.picasso.Picasso

class PostAdpater(private val cellClickListener: CellClickListener):RecyclerView.Adapter<PostAdpater.PostViewHolder>() {
    private var postList: MutableList<PostModel> = ArrayList()

    fun setPosts(posts: MutableList<PostModel>) {

        postList.clear()
        postList.addAll(posts)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_list, parent, false)

        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {

        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val post = postList[position]

        holder.posttitle.text=post.title?.rendered
        Picasso.get().load(post._embedded?.featuremedia?.get(0)?.source_url).into(holder.img)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(post)
        }

    }

    class PostViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

        val posttitle = parent.findViewById<TextView>(R.id.herbotitle)
        var img = parent.findViewById<ImageView>(R.id.herboicon)
    }

}