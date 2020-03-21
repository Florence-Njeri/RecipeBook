package com.example.recipebook.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.R


class OpenedChatsAdapter(/*var list: ArrayList<LatestNewsEvents>*/) : RecyclerView.Adapter<OpenedChatsAdapter.LatestEventsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(inflater,parent)

    }

    override fun getItemCount()=4

    override fun onBindViewHolder(holder: LatestEventsViewHolder, position: Int) {
//        val news: LatestNewsEvents= list[position]

        holder.bind(/*news*/)
    }



    class LatestEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.chat_message_unread_item, parent, false)) {
        private var mBubbleMessage: TextView? = null

        init {
            mBubbleMessage = itemView.findViewById(R.id.chat_message)

        }

        fun bind(/*news:LatestNewsEvents*/) {

            mBubbleMessage?.text ="A selection of chicken dishes served together on a white table. This is comfort food heaven."

        }

    }


}