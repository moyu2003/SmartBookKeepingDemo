package com.example.smartbookkeepingdemo.logic.model

data class SubmitBill(
    val amount: Int,
    val bill: Int,
    val category: String,
    val consumeTime: String,
    val remark: String
)
data class GetBillByTime(
    val code: Int,
    val `data`: List<BillData>,
    val message: String
)
data class BillData(
    val amount: Double,
    val bill: Boolean,
    val category: String,
    val consumeTime: String,
    val createTime: String,
    val id: Long,
    val remark: String
)
data class GetBillDataByTime(
    val early:String,
    val later:String,
    val bill:Int,
    val pageNum:String,
    val pageSize:String
)
data class GetBillDataByMoney(
    val low:Number,
    val high:Number,
    val bill:Int,
    val pageNum:String,
    val pageSize:String
)

data class User(val code: Int, val `data`: Data, val message: String)
data class Data(
    val avatarUrl: Any,
    val gender: Any,
    val tag: Any,
    val token: String,
    val userId: Long,
    val userName: String,
    val userRole: Any
)
data class UserLogin(val userName:String,val userPassword:String)
data class LoginResponse(val code:Int,val data: User,val message:String)
data class UserRegister(val userName:String,val userPassword:String,val checkPassword:String)
data class RegisterResponse(val code:Int,val message:String)
data class OutResponse(val code:Int,val message:String)
data class UserSearch(val code:Int,val data:User,val message:String)
data class ChangeNameResponse(val code:Int,val message:String)
data class ChangeGenderResponse(val code:Int,val message:String)
data class ChangeAgeResponse(val code:Int,val message:String)

