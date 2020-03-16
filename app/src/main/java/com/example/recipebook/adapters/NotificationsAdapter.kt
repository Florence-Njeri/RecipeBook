package com.example.recipebook.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.R
import com.example.recipebook.data.Notifications
import com.example.recipebook.databinding.NotificationsItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1
class NotificationsAdapter( private val notificationsModelList: List<Notifications>) : ListAdapter<DataItem, RecyclerView.ViewHolder>(DiffCallback){
    //List conversions on background thread
    private val adapterScope= CoroutineScope(Dispatchers.Default)
    fun addHeaderAndSubmitList(list: List<Notifications>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(DataItem.Header)
                else -> listOf(DataItem.Header) + list.map{ DataItem.Notification(it)}
            }
            //Get back to UI thread to update UI
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }
//    override fun getItemCount(): Int {
//        return notificationsModelList.size+1
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)

        return when(viewType){
            ITEM_VIEW_TYPE_HEADER->TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM->MyViewHolder(NotificationsItemBinding.inflate(layoutInflater))
            else->throw ClassCastException("Unknown View Type: $viewType")
        }
    }
//    override fun getItemCount() = notificationsModelList.size
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is MyViewHolder ->{
                //Bind item at the given position to the recycler view
                val notifications = getItem(position) as DataItem.Notification
                holder.itemView.setOnClickListener {
//                    clickListener.onClick(notifications.notifications)
                }
                holder.bind(notifications.notifications)
            }
        }

    }
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.Notification-> ITEM_VIEW_TYPE_ITEM
        }
    }

    class MyViewHolder(private var binding: NotificationsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(
            notifications: Notifications
        ) {

            binding.textView3.text=notifications.notificationsTitle
            binding.textView4.text=notifications.time
            binding.executePendingBindings()
        }

    }
    class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.header, parent, false)
                return TextViewHolder(view)
            }
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<DataItem>() {

        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }
    }
}
class NewsListener(val clickListener:(news:Notifications)-> Unit){
    fun onClick(news:Notifications)=clickListener(news)

}
//Data holder class to either represent the Article object or the header
sealed class DataItem{
    //This represents an item in the adapter
    data class Notification(val notifications:Notifications):DataItem(){
        override val id = Long.MAX_VALUE
    }
    object Header:DataItem(){
        override val id = Long.MIN_VALUE
    }

    abstract val id:Long?

}