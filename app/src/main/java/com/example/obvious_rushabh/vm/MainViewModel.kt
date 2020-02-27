package com.example.obvious_rushabh.vm

import android.app.PendingIntent.getActivity
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.obvious_rushabh.model.NasaModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream

class MainViewModel : ViewModel() {
    
    fun getJsonDataFromAsset(context: Context, fileName: String): List<NasaModel>? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        val gson = Gson()
        val listPersonType = object : TypeToken<List<NasaModel>>() {}.type
        val nasaModel: List<NasaModel> = gson.fromJson(jsonString, listPersonType)
        nasaModel.forEachIndexed { idx, nasa -> Log.i("data", "> Item $idx:\n$nasa") }

        return nasaModel
    }

}