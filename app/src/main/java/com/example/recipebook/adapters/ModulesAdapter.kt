package com.example.recipebook.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.data.Module
import com.example.recipebook.databinding.RowModulesBinding

typealias ClickListener = (Int) -> Unit

internal class ModulesAdapter(
    private val moduleModelList: List<Module>,
    private val context: Context?,
    val listener: ModulesListener
) : RecyclerView.Adapter<ModulesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(RowModulesBinding.inflate(inflater))
    }

    override fun getItemCount(): Int {
        return moduleModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module: Module = moduleModelList[position]

        if (context != null) {
            holder.itemView.setOnClickListener {
                listener.onClick()
            }
            holder.bind(moduleModelList[position], context, listener)
        }
    }

    internal class ViewHolder(private var binding: RowModulesBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(
            moduleModel: Module,
            context: Context,
            clickListener: ModulesListener
        ) {
            binding.clickListener = clickListener

           binding.imageViewModule.setImageDrawable(
               moduleModel.moduleImage?.let {
                   ContextCompat.getDrawable(
                       context,
                       it
                   )
               }
            )
            binding.textViewModule.text = moduleModel.moduleTitle
//            itemView.setOnClickListener {
//                //                clickListener(position)
//            }
        }
    }

    class ModulesListener(val clickListener: () -> Unit) {
        fun onClick() = clickListener()
    }
}