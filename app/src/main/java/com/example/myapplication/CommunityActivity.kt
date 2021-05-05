package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCategoryBinding
import com.example.myapplication.databinding.ActivityCommunityBinding

class CommunityActivity : AppCompatActivity() {

    val binding by lazy {ActivityCommunityBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        val intent = Intent (this, PublicActivity::class.java)
        binding.btnPublic.setOnClickListener { startActivity(intent) }
    }
}