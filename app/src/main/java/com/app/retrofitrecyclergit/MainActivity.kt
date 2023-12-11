package com.app.retrofitrecyclergit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.newsappcreate.modelclassfir.Newslistch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recycler)

        val apiKey="key_id"
        val country="us"
        val category="business"

        val call = RetrofitInstance.apiService.getNews(apiKey, country, category)

        call.enqueue(object : Callback<Newslistch> {
            override fun onResponse(call: Call<Newslistch>, response: Response<Newslistch>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity,"sucess", Toast.LENGTH_LONG).show()
                    val newsResponse = response.body()
                    newsResponse?.let {
                        val adapter =RecyclerAdap(this@MainActivity,it.articles)
                        recyclerView.adapter = adapter
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                } else {
                    Toast.makeText(this@MainActivity,"fail1", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Newslistch>, t: Throwable) {
                // Handle network errors
//                println("Network Error: ${t.message}")
                Toast.makeText(this@MainActivity,"fail2", Toast.LENGTH_LONG).show()
            }
        })

    }
}