package com.example.smartbookkeepingdemo.fragments

import android.app.DatePickerDialog
import android.graphics.drawable.Drawable
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.databinding.FragmentLawinBinding
import com.example.smartbookkeepingdemo.viewmodels.LawinViewModel
import com.example.smartbookkeepingdemo.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class LawinFragment : Fragment() {

    companion object {
        fun newInstance() = LawinFragment()
    }

    private lateinit var viewModel: LawinViewModel
    private var _binding: FragmentLawinBinding? = null
    private val binding get() = _binding!!
    private lateinit var mCalendar: Calendar
    private val fragments: ArrayList<Fragment> = arrayListOf(BillFragment(), BudgetFragment(), AssetFragment(), RestitutionFragment(), MoreFragment())
    private val tabIconList: ArrayList<Int> = arrayListOf(R.drawable.bill, R.drawable.budget, R.drawable.asset, R.drawable.restitution, R.drawable.more)
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLawinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LawinViewModel::class.java)
        // TODO: Use the ViewModel


//        设置ViewPager的适配器
        adapter = ViewPagerAdapter(requireFragmentManager(), fragments)
        binding.viewPager.adapter = adapter
//        关联ViewPager
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE

//        重新设置TabLayout的icon
        for (i in 0..4) {
            binding.tabLayout.getTabAt(i)?.icon = resources.getDrawable(tabIconList[i])
        }

        // TODO: 在各个Fragment的xml文件中定义展示数据的控件；展示数据


//        时间选择相关的操作
        binding.timeButton.setOnClickListener {
            mCalendar = Calendar.getInstance()
            val pickerDialog = DatePickerDialog(requireContext(), object : DatePickerDialog.OnDateSetListener {

                override fun onDateSet(arg0: DatePicker, year: Int, month: Int, day: Int) {
                    mCalendar.set(year, month, day);//将点击获得的年月日设置到calendar中。
                    val format = SimpleDateFormat("yyyy年MM月dd日");//转型
                    Toast.makeText(
                        requireContext(),
                        format.format(mCalendar.time),
                        Toast.LENGTH_LONG
                    ).show()
                    val year = mCalendar.get(Calendar.YEAR)
                    val month = mCalendar.get(Calendar.MONTH)
                    binding.timeButton.text = "${year}年\n${month}月"

                    // TODO:  根据选择的时间查询并储存对应数据
                }
            }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH))
            pickerDialog.show()
        }
    }

}