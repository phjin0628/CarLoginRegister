package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    val binding by lazy{ActivityCategoryBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //편의시설 누르면 편의시설 화면으로 이동
        val intent = Intent(this, PublicActivity::class.java)
        binding.publicBtn.setOnClickListener{startActivity(intent)}

        //캠핑장 검색 누르면 캠핑장 검색 화면으로 이동
        val carmap = Intent(this, CarMap::class.java)
        binding.CarMapbtn.setOnClickListener{startActivity(carmap)}

        //커뮤니티 누르면 커뮤니티 화면으로 이동
        val intent3 = Intent(this, CommunityActivity::class.java)
        binding.communityBtn.setOnClickListener{startActivity(intent3)}

        //더보기 누르면 더보기 화면으로 이동
        val intent4 = Intent(this, MoreActivity::class.java)
        binding.etcBtn.setOnClickListener{startActivity(intent4)}

    }
}