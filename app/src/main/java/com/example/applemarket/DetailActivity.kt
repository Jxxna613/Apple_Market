package com.example.applemarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.applemarket.databinding.ActivityDetailBinding

class DetailPage : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getItem = intent.getParcelableExtra<MarketInfo>("MarketInfo")
        if (getItem != null) {
            binding.picture.setImageResource(getItem.itemImage)
            binding.nickname.text = getItem.nickName
            binding.address.text = getItem.address
            binding.title.text = getItem.itemTitle
            binding.nextTitle.text = getItem.itemInfo
            binding.price.text = (String.format("%,d원",getItem.priceInfo))
        }

        val back : ImageButton = binding.backButton
        back.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}