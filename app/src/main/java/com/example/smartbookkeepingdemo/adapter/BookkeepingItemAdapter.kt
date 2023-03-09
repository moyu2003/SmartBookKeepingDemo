package com.example.smartbookkeepingdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.databinding.BookkeepingItemBinding
import com.example.smartbookkeepingdemo.myclass.BookkeepingItem

class BookkeepingItemAdapter(private val itemList: ArrayList<BookkeepingItem>) :
    RecyclerView.Adapter<BookkeepingItemAdapter.ViewHolder>() {

    inner class ViewHolder(binding: BookkeepingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            val itemIcon: ImageView = binding.bookkeepingItemIconView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            BookkeepingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewHolder(binding)
        viewHolder.itemView.setOnClickListener { 
            val position = viewHolder.adapterPosition
            val item = itemList[position]
            // TODO: 添加item的点击事件（弹出键盘输入金额） 。。自定义键盘
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemIcon.setImageResource(itemList[position].iconId)
    }

}