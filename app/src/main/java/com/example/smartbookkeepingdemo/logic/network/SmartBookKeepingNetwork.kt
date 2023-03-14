package com.example.smartbookkeepingdemo.logic.network

import com.example.smartbookkeepingdemo.logic.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Query
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SmartBookKeepingNetwork {
    private val smartService = ServiceCreator.create<SmartService>()
    suspend fun submitBill(submitBills: SubmitBill) = smartService.submitBill(submitBills).await()
    suspend fun deleteBill(id :Int)= smartService.deleteBill(id).await()
    suspend fun getBillByTime(getBillDataByTime: GetBillDataByTime)= smartService.getBillByTime(getBillDataByTime).await()
    suspend fun getBillByMoney(getBillDataByMoney: GetBillDataByMoney)= smartService.getBillByMoney(getBillDataByMoney).await()
    suspend fun getSum(early:String, later:String, bill:Int)= smartService.getSum(early,later, bill).await()
    suspend fun login(userLogin: UserLogin)= smartService.login(userLogin)
    suspend fun register( userRegister: UserRegister)= smartService.register(userRegister)
    suspend fun loginOut()= smartService.loginOut()
    suspend fun searchUser()= smartService.searchUser()
    suspend fun changeName( userName:String)= smartService.changeName(userName)
    suspend fun changeGender( gender:Int)= smartService.changeGender(gender)
    suspend fun changeAge( tag:Int)= smartService.changeAge(tag)
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null"))
                }
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}