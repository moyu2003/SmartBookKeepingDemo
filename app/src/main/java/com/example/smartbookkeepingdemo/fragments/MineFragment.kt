package com.example.smartbookkeepingdemo.fragments

import android.app.Application
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.activities.MainLoginActivity
import com.example.smartbookkeepingdemo.activities.ManualBookkeepingActivity
import com.example.smartbookkeepingdemo.logic.network.SmartBookKeepingNetwork
import com.example.smartbookkeepingdemo.myclass.MyApplication
import com.example.smartbookkeepingdemo.myclass.MyApplication.Companion.context
import com.example.smartbookkeepingdemo.myutils.showToast
import com.example.smartbookkeepingdemo.viewmodels.MineViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MineFragment : Fragment() {

    companion object {
        fun newInstance() = MineFragment()
    }

    private lateinit var viewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MineViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private suspend fun loginOut(){
        try{
            val response=SmartBookKeepingNetwork.loginOut()
            CoroutineScope(Dispatchers.Main).launch {
                response.message.showToast()
            }
            if(response.code==200){
                val intent = Intent(MyApplication.context, MainLoginActivity::class.java)
                startActivity(intent)
            }
        }catch (e: Exception) {
            Log.e("TAG", "login(): ", e)
        }
    }
}