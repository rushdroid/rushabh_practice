package com.example.obvious_rushabh.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.obvious_rushabh.R
import com.example.obvious_rushabh.adapter.SwipeViewPager
import com.example.obvious_rushabh.vm.MainViewModel
import kotlinx.android.synthetic.main.activity_nasa_detail.*

class NasaDetailActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nasa_detail)
        init()
    }

    private fun init() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val swipeViewPager = SwipeViewPager(this)
        viewpager.adapter = swipeViewPager
        mainViewModel.getJsonDataFromAsset(this, "nasa_data.json")
            ?.let { swipeViewPager.setData(it) }
        viewpager.currentItem = intent.getIntExtra("position", 0)
    }
}
