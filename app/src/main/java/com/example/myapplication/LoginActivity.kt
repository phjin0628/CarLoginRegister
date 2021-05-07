package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class LoginActivity : AppCompatActivity() {

    lateinit var id:EditText
    lateinit var password:EditText
    lateinit var button:Button
    lateinit var btnRegister:Button

    val binding by lazy{ ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) //binding.root

        id=findViewById(R.id.textid)
        password=findViewById(R.id.textPassword)
        button=findViewById(R.id.loginBtn)
        btnRegister=findViewById(R.id.btnRegister)


        val retrofit=Retrofit.Builder()
            .baseUrl("http://3.34.141.115")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


            btnRegister.setOnClickListener{
            Intent(this,SignUpActivity::class.java).run{
                   startActivity(this)
            }

         /*
          val binding by lazy{ ActivityLoginBinding.inflate(layoutInflater)

            val signup= Intent(this, SignUpActivity::class. java)
            binding.btnRegister.setOnClickListener{ startActivity(signup)}
*/
        val service=retrofit.create(SignService::class.java)
        button.setOnClickListener {
            val idStr=id.text.toString()
            val pwStr=password.text.toString()
            service.login(idStr,pwStr).enqueue(object : Callback<LoginResponse> {
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


        /*
        val intent= Intent(this, CategoryActivity::class.java)
        binding.loginBtn.setOnClickListener{ startActivity(intent) }

        val signup= Intent(this, SignUpActivity::class. java)
        binding.signupBtn.setOnClickListener{ startActivity(signup)}

         */
}


interface SignService{ //레트로핏을 활용하기 위한 코드
    @FormUrlEncoded //@Field 필드 값을 받기 위해 선언해줘야함
    @POST("login.php")
    fun login(@Field("id")id:String,@Field("password")pw:String): Call<LoginResponse>
}}
