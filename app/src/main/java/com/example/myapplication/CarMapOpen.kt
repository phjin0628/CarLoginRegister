package com.example.myapplication

import com.example.myapplication.mapdata.CarMapJson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

class CarMapOpen {
    companion object{
        val DOMAIN="http://3.34.141.115/dbcon3.php/"
    }
}

interface CarOpenService{
    @GET //("http://3.34.141.115/dbcon3.php") //@GET이랑 @URL 같이 쓸 수 없음
    fun getCar(@Url url:String): Call<CarMapJson>
}