package com.example.dh.network

import androidx.lifecycle.MutableLiveData
import com.example.dh.model.Data
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.kotlin.where

object RealmService {
    private  val config:RealmConfiguration
    private  val realm : Realm
    val newsLive = MutableLiveData<List<Data>>()

    init {
        config = RealmConfiguration.Builder().name( "dh.realm").allowWritesOnUiThread(true).allowQueriesOnUiThread(true).build()
        realm = Realm.getInstance(config)
    }

    fun insertData(currentItem:Data){
        realm.executeTransaction { transactionRealm ->
            transactionRealm.insert(currentItem)
        }
    }
    fun getAllData():List<Data>{
        val news : List<Data> = realm.where<Data>().findAll()
        newsLive.postValue(news)
        return news
    }
    fun getData(currentItem:Data): Data? {
        val new :List<Data> = realm.where<Data>().equalTo("Id",currentItem.getId()).findAll()
       if(new.isEmpty()){
           return null
       }else{
        return new.first()
    }}
    fun removeData(currentItem:Data) {

        realm.executeTransaction { transactionRealm ->
            val new :RealmResults<Data> = transactionRealm.where<Data>().equalTo("Id",currentItem.getId()).findAll()
            new.deleteAllFromRealm()
        }

    }

}