package com.samrumi.retrofitsetup.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.samrumi.retrofitsetup.R
import com.samrumi.retrofitsetup.model.UserData

class PostAdapter(private val activity: Activity,
                  private val postItems: List<UserData>) : RecyclerView.Adapter<PostAdapter.PostItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemHolder {
        return PostItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_users,
                parent, false))
    }

    override fun getItemCount(): Int {
        return postItems.size
    }

    override fun onBindViewHolder(holder: PostItemHolder, position: Int) {
        holder.setInfo(postItems[position])
    }

    inner class PostItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mImage = itemView.findViewById<AppCompatImageView>(R.id.iv_user)
        private val mTitle = itemView.findViewById<AppCompatTextView>(R.id.tv_title)
        private val mBody = itemView.findViewById<AppCompatTextView>(R.id.tv_body)

        fun setInfo(posts: UserData) {
            Glide.with(activity).load(posts.avatar).into(mImage)
            mTitle.text = posts.first_name
            mBody.text = posts.last_name
        }
    }
}