package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class SignUpActivity : AppCompatActivity() {


    lateinit var id: EditText
    lateinit var password: EditText
    lateinit var name: EditText
    lateinit var phonenum: EditText
    lateinit var email: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        id=findViewById(R.id.textid)
        password=findViewById(R.id.textPassword)
        name=findViewById(R.id.textName)
        phonenum=findViewById(R.id.textPhonenum)
        email=findViewById(R.id.textEmail)
        button=findViewById(R.id.loginBtn)

        val retrofit= Retrofit.Builder()
            .baseUrl("http://3.34.141.115")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(RegisterService::class.java)
        button.setOnClickListener {
            val idStr=id.text.toString()
            val pwStr=password.text.toString()
            val nameStr=name.text.toString()
            val phoneStr=phonenum.text.toString()
            val emailStr=email.text.toString()
            service.register(idStr,pwStr,nameStr,phoneStr,emailStr).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    val result=response.body()
                    Log.d("로그인","${result}")
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("로그인","${t.localizedMessage}")
                }
            })
        }
    }
}

interface RegisterService{
    @FormUrlEncoded //@Field 필드 값을 받기 위해 선언해줘야함
    @POST("register.php")
    fun register(@Field("id")id:String
                 ,@Field("password")pw:String
                 ,@Field("name")name:String
                 ,@Field("phonenum")phonenum:String
                 ,@Field("email")email:String): Call<LoginResponse>
}