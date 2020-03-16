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
import com.example.recipebook.data.Module

typealias ClickListener = (Int) -> Unit

internal class ModulesAdapter(
    private val moduleModelList: List<Module>,
    private val context: Context
) : RecyclerView.Adapter<ModulesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row_modules, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moduleModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(moduleModelList[position], context, position)
    }

    internal class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.imageViewModule)
        private val title: TextView = itemView.findViewById(R.id.textViewModule)

        fun bind(
            moduleModel: Module,
            context: Context,
            position: Int
        ) {
            image.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.icon_networks
                )
            )
            title.text = "Title"
            itemView.setOnClickListener {
//                clickListener(position)
            }
        }
    }
}