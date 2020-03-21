package com.example.recipebook.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.R
import de.hdodenhof.circleimageview.CircleImageView


class FriendsAdapter(/*var list: ArrayList<LatestNewsEvents>*/) : RecyclerView.Adapter<FriendsAdapter.LatestEventsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(inflater,parent)

    }

    override fun getItemCount()=5

    override fun onBindViewHolder(holder: LatestEventsViewHolder, position: Int) {
//        val news: LatestNewsEvents= list[position]

        holder.bind(/*news*/)
    }



    class LatestEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.friends_list_item, parent, false)) {
        private var mName: TextView? = null
        private var mCount: TextView? = null
        private var mAvatar: CircleImageView? = null


        init {
            mName = itemView.findViewById(R.id.name)
            mCount= itemView.findViewById(R.id.count)
            mAvatar= itemView.findViewById(R.id.profile_image)

        }

        fun bind(/*news:LatestNewsEvents*/) {
            mAvatar?.setImageResource(R.drawable.avatar_placeholder)
//            mNewsTitle?.text = news.title
//            mNewsSubTitle?.text = news.subTitle

            mName?.text ="Ronke Igboegwu"
            mCount?.text ="200 Friends"

        }

    }


}