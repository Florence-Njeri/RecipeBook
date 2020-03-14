package com.example.recipebook.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.data.Article
import androidx.recyclerview.widget.ListAdapter
import com.example.recipebook.R
import com.example.recipebook.databinding.NotificationsItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1
class NotificationsAdapter(val clickListener:NewsListener) : ListAdapter<DataItem, RecyclerView.ViewHolder>(DiffCallback){
    //List conversions on background thread
    private val adapterScope= CoroutineScope(Dispatchers.Default)
    fun addHeaderAndSubmitList(list: List<Article>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(DataItem.Header)
                else -> listOf(DataItem.Header) + list.map{ DataItem.NewsArticle(it)}
            }
            //Get back to UI thread to update UI
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)

        return when(viewType){
            ITEM_VIEW_TYPE_HEADER->TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM->MyViewHolder(NotificationsItemBinding.inflate(layoutInflater))
            else->throw ClassCastException("Unknown View Type: $viewType")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is MyViewHolder ->{
                //Bind item at the given position to the recycler view
                val news = getItem(position) as DataItem.NewsArticle
                holder.itemView.setOnClickListener {
                    clickListener.onClick(news.article)
                }
                holder.bind(news.article,clickListener)
            }
        }

    }
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.NewsArticle-> ITEM_VIEW_TYPE_ITEM
        }
    }

    class MyViewHolder(private var binding: NotificationsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(
            news: Article,
            clickListener: NewsListener
        ) {

//            binding.newsItem=news
//            binding.clickListener=clickListener
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
class NewsListener(val clickListener:(news:Article)-> Unit){
    fun onClick(news:Article)=clickListener(news)

}
//Data holder class to either represent the Article object or the header
sealed class DataItem{
    //This represents an item in the adapter
    data class NewsArticle(val article:Article):DataItem(){
        override val id = Long.MAX_VALUE
    }
    object Header:DataItem(){
        override val id = Long.MIN_VALUE
    }

    abstract val id:Long?

}