package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//로그인 버튼 누르면 카테고리 화면으로 이동, 로그인 구현하고 db랑 일치해야 넘어가는걸로 수정 해야함
    val binding by lazy{ ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent= Intent(this, CategoryActivity::class.java)
        binding.loginBtn.setOnClickListener{ startActivity(intent) }

        val signup= Intent(this, SignUpActivity::class. java)
        binding.signupBtn.setOnClickListener{ startActivity(signup)}

//p.254 글자 실시간으로 처리하기 일단 구현해봤는데 필요없으면 삭제 (아이디 부분만 해당)
        binding.id.addTextChangedListener {
            Log.d("EditText", "현재 입력된 값=${it.toString()}")
        }
    }

}