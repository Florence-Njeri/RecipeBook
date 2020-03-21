package com.example.recipebook.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.R
import com.example.recipebook.data.NetworkModules

typealias FavouritesClickListener = (Int) -> Unit

internal class FavouritesAdapter(
    private val moduleModelList: ArrayList<NetworkModules>,
    private val context: Context
) : RecyclerView.Adapter<FavouritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  FavouritesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.favourites_item, parent, false)
        return  FavouritesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moduleModelList.size
    }
    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        holder.bind(moduleModelList[position], context, position)    }
}

    internal class FavouritesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.imageViewModule)
        private val title: TextView = itemView.findViewById(R.id.textViewModule)

        fun bind(
            moduleModel:NetworkModules,
            context: Context,
            position: Int
        ) {
            image.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    moduleModel.moduleImage
                )
            )
            title.text = moduleModel.moduleTitle
            itemView.setOnClickListener {
//                clickListener(position)
            }
        }
    }

