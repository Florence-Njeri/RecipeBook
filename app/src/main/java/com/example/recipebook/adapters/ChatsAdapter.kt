package com.example.recipebook.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.R
import de.hdodenhof.circleimageview.CircleImageView


class ChatsAdapter(/*var list: ArrayList<LatestNewsEvents>*/) : RecyclerView.Adapter<ChatsAdapter.LatestEventsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(inflater,parent)

    }

    override fun getItemCount()=6

    override fun onBindViewHolder(holder: LatestEventsViewHolder, position: Int) {
//        val news: LatestNewsEvents= list[position]
        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_chatsFragment_to_openedChatsFragment)
        )
        holder.bind(/*news*/)
    }



    class LatestEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.chat_item, parent, false)) {
        private var mSender: TextView? = null
        private var mMessage: TextView? = null
        private var mAvatar: CircleImageView? = null


        init {
            mSender = itemView.findViewById(R.id.senderName)
            mMessage= itemView.findViewById(R.id.message)
            mAvatar= itemView.findViewById(R.id.profile_image)

        }

        fun bind(/*news:LatestNewsEvents*/) {
            mAvatar?.setImageResource(R.drawable.avatar_placeholder)
//            mNewsTitle?.text = news.title
//            mNewsSubTitle?.text = news.subTitle

            mSender?.text ="Ronke Igboegwu"
            mMessage?.text ="A selection of chicken dishes served together ..."

        }

    }


}