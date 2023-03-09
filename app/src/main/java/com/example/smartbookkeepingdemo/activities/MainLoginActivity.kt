package com.example.smartbookkeepingdemo.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.databinding.ActivityMainLoginBinding

class MainLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        读取之前储存的密码
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password", false)
        if (isRemember) {
            binding.loginName.setText(prefs.getString("name", ""))
            binding.loginPassword.setText(prefs.getString("password", ""))
            binding.rememberPassword.isChecked = true
            binding.loginPassword.apply {
                transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

//        用户点击注册按钮后，主登录按钮变为”注册并登录“，可以进行注册并登录操作；同时原注册按钮变成登录按钮
        binding.intercut.setOnClickListener {
            when (binding.intercut.text.toString()) {
                "注册账号" -> {
                    binding.intercut.text = "登录账号"
                    binding.loginButton.text = "注册并登录"
                }
                "登录账号" -> {
                    binding.intercut.text = "注册账号"
                    binding.loginButton.text = "登录"
                }
            }
        }
//        通过主按钮上的文字判断目前进行的是注册或是登录操作，执行对应的操作
        binding.loginButton.setOnClickListener {
            if (binding.loginButton.text.toString() == "登录") {
                // TODO:  进行登录操作，登录成功后打开主界面
//                CoroutineScope(Dispatchers.IO).launch {
//                    login()
//                }
            } else if (binding.loginButton.text.toString() == "注册并登录") {
                // TODO:  进行注册操作，注册成功登录后打开主界面
            }
        }
    }

    private suspend fun login() {
//        try {
//            val name = binding.loginName.text.toString()
//            val passsword = binding.loginPassword.text.toString()
//
//            val response = NetWork.login(User(name, passsword))
//            Log.d("TAG", response.toString())
//
//            CoroutineScope(Dispatchers.Main).launch {
//                //UI操作
//                response.msg.showToast()
//            }
//            if (response.code == 0) {
//                val prefs = getPreferences(Context.MODE_PRIVATE)
//                val editor = prefs.edit()
//                if (binding.rememberPassword.isChecked) {
//                    editor.putBoolean("remember_password", true)
//                    editor.putString("name", name)
//                    editor.putString("password", passsword)
//                } else {
//                    editor.clear()
//                }
//                editor.apply()
//                UserInfo.id = response.data.id
//                UserInfo.name = binding.loginName.text.toString()
//                val intent = Intent(this@login_activity, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        } catch (e: Exception) {
//            Log.e("TAG", "login(): ", e)
//        }
    }
}