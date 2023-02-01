package com.drovo.completeproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drovo.completeproject.databinding.EachRowBinding
import com.drovo.completeproject.models.Post

class PostAdapter constructor(
    private var postList: List<Post>
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private lateinit var binding: EachRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = EachRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tasks.text = postList[position].body
    }

    override fun getItemCount(): Int = postList.size

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    fun setData(postList: List<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }
}