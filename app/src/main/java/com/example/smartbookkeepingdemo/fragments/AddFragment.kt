package com.example.smartbookkeepingdemo.fragments

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.smartbookkeepingdemo.activities.ManualBookkeepingActivity
import com.example.smartbookkeepingdemo.databinding.FragmentAddBinding
import com.example.smartbookkeepingdemo.myclass.MyApplication
import com.example.smartbookkeepingdemo.viewmodels.AddViewModel
import java.io.*
import java.io.File
import java.net.HttpURLConnection
import java.net.URL


class AddFragment : DialogFragment() {

    companion object {
        fun newInstance() = AddFragment()
    }

    private lateinit var viewModel: AddViewModel
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    val takePhoto = 1
    lateinit var imageUri: Uri
    lateinit var outputImage: File

    override fun onStart() {
        super.onStart()

//        设置弹窗对应大小
        val dm = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(dm)
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        dialog!!.window!!.setLayout(width, 1500)//dm.heightPixels

        requireActivity().windowManager.defaultDisplay.getMetrics(dm)
        dialog!!.window!!.setLayout(dm.widthPixels, dialog!!.window!!.attributes.height)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        // TODO: Use the ViewModel

        binding.addByHand.setOnClickListener {
            val intent = Intent(requireContext(), ManualBookkeepingActivity::class.java)
            startActivity(intent)
        }
        binding.addByRobot.setOnClickListener {
            outputImage = File(MyApplication.context.externalCacheDir,"example.jpg")
            if (outputImage.exists()) {
                outputImage.delete()
            }
            outputImage.createNewFile()
            imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                FileProvider.getUriForFile(MyApplication.context, "com.example.smartbookkeepingdemo.fileprovider", outputImage)
            } else {
                Uri.fromFile(outputImage)
            }
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intent, takePhoto)
            test()
        }

        }

    private fun test(){
        // 通用文字识别
        val url = "https://api.textin.com/ai/service/v2/recognize"
        // 请登录后前往 “工作台-账号设置-开发者信息” 查看 x-ti-app-id
        // 示例代码中 x-ti-app-id 非真实数据
        val appId = "c83abe687f3af1306f01c33b31b9a4d7"
        // 请登录后前往 “工作台-账号设置-开发者信息” 查看 x-ti-secret-code
        // 示例代码中 x-ti-secret-code 非真实数据
        val secretCode = "e73373e00e16a505ed1d19333e6fdacf"
        var `in`: BufferedReader? = null
        var out: DataOutputStream? = null
        var result: String? = ""
        try {
            val imgData = readfile("example.jpg") // image
            val realUrl = URL(url)
            val conn: HttpURLConnection = realUrl.openConnection() as HttpURLConnection
            conn.setRequestProperty("connection", "Keep-Alive")
            conn.setRequestProperty("Content-Type", "application/octet-stream")
            conn.setRequestProperty("x-ti-app-id", appId)
            conn.setRequestProperty("x-ti-secret-code", secretCode)
            conn.setDoOutput(true)
            conn.setDoInput(true)
            conn.setRequestMethod("POST") // 设置请求方式
            out = DataOutputStream(conn.getOutputStream())
            out.write(imgData)
            out.flush()
            out.close()
            `in` = BufferedReader(
                InputStreamReader(conn.getInputStream(), "UTF-8")
            )
            var line: String?
            while (`in`.readLine().also { line = it } != null) {
                result += line
            }
        } catch (e: Exception) {
            Log.d("TAG","发送 POST 请求出现异常！$e")
            e.printStackTrace()
        } finally {
            try {
                if (out != null) {
                    out.close()
                }
                if (`in` != null) {
                    `in`.close()
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
        }
        Log.d("TAG",result.toString())
    }
    fun readfile(path: String): ByteArray? {
        var `in`: InputStream? = null
        var data: ByteArray? = null
        try {
            `in` = FileInputStream(path)
            data = ByteArray((`in` as FileInputStream).available())
            (`in` as FileInputStream).read(data)
            (`in` as FileInputStream).close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return data
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}