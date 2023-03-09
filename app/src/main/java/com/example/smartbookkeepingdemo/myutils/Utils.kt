package com.example.smartbookkeepingdemo.myutils

import android.graphics.Bitmap
import android.graphics.Matrix
import android.widget.Toast
import com.example.smartbookkeepingdemo.myclass.MyApplication
import com.google.android.material.textfield.TextInputLayout
import java.io.ByteArrayOutputStream

const val TAG = "TAG"

//"".showToast()，默认使用时间较短的Toast
fun String.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(MyApplication.context, this, duration).show()
}

fun TextInputLayout.setFocus() {
    editText?.setOnFocusChangeListener { view, hasFocus -> error = "" }
}

fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
    val byteArrayOutPutStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutPutStream)
    byteArrayOutPutStream.close()
    return byteArrayOutPutStream.toByteArray()
}

//图片压缩（float:500-700）
fun compressImage(image: Bitmap, trueWidth: Float): Bitmap {
    val matrix = Matrix()
    val w = image.width
    val h = image.height
    val trueHeight = trueWidth * h / w
    if (trueWidth > w) return image
    val wsx = trueHeight / w
    matrix.setScale(wsx, wsx)
    return Bitmap.createBitmap(image, 0, 0, w, h, matrix, true)
}


