package com.example.obvious_rushabh.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.obvious_rushabh.R
import com.example.obvious_rushabh.adapter.NasaAdapter
import com.example.obvious_rushabh.util.GridItemDecoration
import com.example.obvious_rushabh.vm.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        recyclerview.addItemDecoration(GridItemDecoration(10, 2))
        val nasaAdapter = NasaAdapter()
        recyclerview.adapter = nasaAdapter
        nasaAdapter.setData(mainViewModel.getJsonDataFromAsset(this,"nasa_data.json"))
    }
}
