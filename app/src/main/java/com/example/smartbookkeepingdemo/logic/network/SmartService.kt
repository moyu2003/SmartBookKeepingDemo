package com.example.smartbookkeepingdemo.logic.network

import com.example.smartbookkeepingdemo.logic.model.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface SmartService {
    @POST("bill/submit")
    fun submitBill(@Body submitBills: SubmitBill):Call<ResponseBody>

    @DELETE("bill/delete")
    fun deleteBill(@Path("id") id :Int):Call<ResponseBody>

    @POST("bill/get/bt/time")
    fun getBillByTime(@Body getBillDataByTime: GetBillDataByTime):Call<GetBillByTime>

    @POST("bill/get/bt/amount")
    fun getBillByMoney(@Body getBillDataByMoney: GetBillDataByMoney):Call<GetBillByTime>

    @GET("bill/get/sum")
    fun getSum(@Query("e") early:String,@Query("l") later:String, @Query("b") bill:Int):Call<Int>

    @POST("user/login")
    fun login(@Body userLogin:UserLogin):Call<LoginResponse>

    @POST("user/register")
    fun register(@Body userRegister:UserRegister):Call<RegisterResponse>

    @POST("user/logout")
    fun loginOut():Call<OutResponse>

    @GET("user/search")
    fun searchUser():Call<UserSearch>

    @POST("user/addUserName")
    fun changeName(@Body userName:String):Call<ChangeNameResponse>

    @POST("user/addGender")
    fun changeGender(@Body gender:Int):Call<ChangeGenderResponse>

    @POST("user/addTag")
    fun changeAge(@Body tag:Int):Call<ChangeAgeResponse>

}