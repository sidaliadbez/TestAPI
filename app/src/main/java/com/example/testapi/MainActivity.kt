package com.example.testapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
var lsit = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lsit.add("sidali")
         fetchJson()


    }

     fun fetchJson()  {
         val client = OkHttpClient()
         val request = Request.Builder()
             .url("https://api.airvisual.com/v2/countries?key=7be3b8fb-772d-4a92-ab9b-01690c31aff6")
             .build()


         client.newCall(request).enqueue(object : Callback{
             override fun onFailure(call: Call, e: IOException) {
                print("sooooooooooooooooorry")
             }

             override fun onResponse(call: Call, response: Response) {
                 var cool = response.body()?.string()
                 print(cool )
                 val gson = GsonBuilder().create()
                val homeFeed= gson.fromJson(cool,HomeFeed::class.java)
                 runOnUiThread {
                     setupRecyclerView(homeFeed)
                 }
             }

         })
    }

    private fun setupRecyclerView(homeFeed: HomeFeed) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleview.layoutManager = layoutManager
        val adapter = ApiAdapter(
            this, homeFeed
        )
        recycleview.adapter = adapter
    }
}
class HomeFeed(val data : List<data>)
class data (val country :String)