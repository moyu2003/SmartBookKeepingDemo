package com.example.smartbookkeepingdemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.myclass.MyApplication

class SplashActivity : AppCompatActivity() {

    val mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mHandler.postDelayed(object : Runnable {
            override fun run() {
                val intent = Intent()
                intent.setClass(MyApplication.context, LoadActivity::class.java) //SplashActivity.this
                startActivity(intent);
                finish();//销毁欢迎页面
            }
        },3000);//3秒后跳转

    }
}