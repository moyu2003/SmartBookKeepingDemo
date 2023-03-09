package com.example.smartbookkeepingdemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.databinding.ActivityLoadBinding
import com.example.smartbookkeepingdemo.myutils.showToast

class LoadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apple登录
        binding.byApple.setOnClickListener {
            if (agreePact()) {
                var flag = false
//                 此处逻辑鉴别输入的账号密码是否匹配
                if (flag) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    "暂时不支持Apple登录~".showToast()
                }
            }
        }
        // WeChat登录
        binding.byWeChat.setOnClickListener {
            if (agreePact()) {
                var flag = false
//                 此处逻辑鉴别输入的账号密码是否匹配
                if (flag) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    "暂时不支持微信登录~".showToast()
                }
            }
        }
        // 更多登录方式
        binding.moreWay.setOnClickListener {
            if (agreePact()) {
                val intent = Intent(this, MainLoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // 是否同意隐私政策
    private fun agreePact(): Boolean {
        if (binding.pactBox.isChecked) {
            return true
        } else {
            "请先阅读并同意《用户协议》和《隐私政策》~".showToast()
        }
        return false
    }
}