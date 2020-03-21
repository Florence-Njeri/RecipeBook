package com.example.recipebook.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.R


class IngredientsAdapter(/*var list: ArrayList<LatestNewsEvents>*/) : RecyclerView.Adapter<IngredientsAdapter.LatestEventsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(inflater,parent)


    }

    override fun getItemCount()=10

    override fun onBindViewHolder(holder: LatestEventsViewHolder, position: Int) {
//        val news: LatestNewsEvents= list[position]
        holder.bind(/*news*/)
    }



    class LatestEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.recipe_item, parent, false)) {
        private var mRecipeName: TextView? = null


        init {
            mRecipeName = itemView.findViewById(R.id.title)

        }

        fun bind(/*news:LatestNewsEvents*/) {


            mRecipeName?.text ="Easy Mexican Casserole"

        }

    }


}