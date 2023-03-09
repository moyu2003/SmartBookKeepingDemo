package com.example.smartbookkeepingdemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.adapter.BookkeepingItemAdapter
import com.example.smartbookkeepingdemo.databinding.ActivityManualBookkeepingBinding
import com.example.smartbookkeepingdemo.myclass.BookkeepingItem

class ManualBookkeepingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManualBookkeepingBinding
    private val bookkeepingItemList: ArrayList<BookkeepingItem> =
        arrayListOf(
            BookkeepingItem("餐饮", R.drawable.repast),
            BookkeepingItem("交通", R.drawable.traffic),
            BookkeepingItem("娱乐", R.drawable.amusement),
            BookkeepingItem("日用", R.drawable.supply),
            BookkeepingItem("蔬菜", R.drawable.vegatable),
            BookkeepingItem("水果", R.drawable.snake),
            BookkeepingItem("通讯", R.drawable.correspond),
            BookkeepingItem("服饰", R.drawable.clother),
            BookkeepingItem("美容", R.drawable.beautify)
            // TODO: 添加各种item
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManualBookkeepingBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        初始化RecyclerView
        val layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        binding.bookkeepingItemRecyclerview.layoutManager = layoutManager
        val adapter = BookkeepingItemAdapter(bookkeepingItemList)
        binding.bookkeepingItemRecyclerview.adapter = adapter
    }
}