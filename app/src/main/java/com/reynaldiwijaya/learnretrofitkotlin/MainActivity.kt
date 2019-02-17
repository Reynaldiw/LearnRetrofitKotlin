package com.reynaldiwijaya.learnretrofitkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.reynaldiwijaya.learnretrofitkotlin.Model.PostModel
import com.reynaldiwijaya.learnretrofitkotlin.Network.DataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postServices = DataRepository.create()
        postServices.getPost().enqueue(object : Callback<List<PostModel>> {

            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("TAG", "Responsenya ${data?.size}")

                    data?.map {
                        Log.d("TAG", "datanya ${it.body}")
                    }
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Log.d("TAG", "datanya : ${t.message}")
            }

        })
    }
}
