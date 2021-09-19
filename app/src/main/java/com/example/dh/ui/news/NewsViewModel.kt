package com.example.dh.ui.news

import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dh.model.Data
import com.example.dh.model.ResponseModel
import com.example.dh.network.NewsService
import com.example.dh.network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    private val retrofit = RetroInstance()
    var  newsService = retrofit.getRetrofit()?.create(NewsService::class.java)
    var  requesting  =false
    val news = MutableLiveData<List<Data>>()
    val newsList = mutableListOf<Data>()
   var progressBar: ProgressBar? =null

    init {
        getDataFromApi(0)
    }

    fun  getNewsListObserver(): MutableLiveData<List<Data>> {
        return news;
    }

    fun getDataFromApi(page:Int){
        progressBar?.setVisibility(View.VISIBLE);
        requesting=true
        newsService?.getNews(page)?.enqueue(object : Callback<ResponseModel> {
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                requesting=false
                progressBar?.setVisibility(View.INVISIBLE);
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                progressBar?.setVisibility(View.INVISIBLE);
                requesting=false
                if (response.isSuccessful) {
                    newsList.addAll(response.body()?.getData()!!)
                    news.postValue(newsList)
                }
            }
        })


    }
    fun chechkInFavList(datas:List<Data>){
        for (i in datas){
            for (j in newsList){
                if (
                    i.getId()==j.getId()
                ){
                    j.setIsFavorite(true)
                }else{
                    j.setIsFavorite(false)
                }
            }
        }
        news.postValue(newsList)
    }
}