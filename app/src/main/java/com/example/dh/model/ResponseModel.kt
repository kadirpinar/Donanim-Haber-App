package com.example.dh.model

import io.realm.RealmList
import io.realm.RealmObject
import java.util.*

open  class ResponseModel : RealmObject
{
    private lateinit var  Message : String

    private lateinit var  UnixTime:String

    private lateinit var Server:String

    private lateinit var  Data:RealmList<Data>

    private lateinit var  HashErrorCode:String

    private lateinit var HasError:String
    constructor(Message:String,Server: String,UnixTime: String,Data:RealmList<Data>,HasError: String,HashErrorCode: String){
        this.Message=Message
        this.Server=Server
        this.UnixTime=UnixTime
        this.Data=Data
        this.HasError=HasError
        this.HashErrorCode=HashErrorCode
    }
    constructor(){

    }
    fun  getMessage ():String
    {
        return Message;
    }

    fun  setMessage (Message:String)
    {
        this.Message = Message
    }

    fun  getUnixTime ():String
    {
        return UnixTime
    }

    fun  setUnixTime ( UnixTime:String)
    {
        this.UnixTime = UnixTime
    }

    fun  getServer ():String
    {
        return Server
    }

    fun  setServer (Server:String)
    {
        this.Server = Server;
    }

    fun getData (): RealmList<Data>
    {
        return Data;
    }

    fun  setData (Data:RealmList<Data>)
    {
        this.Data = Data
    }

    fun  getHashErrorCode ():String
    {
        return HashErrorCode
    }

    fun setHashErrorCode (HashErrorCode:String)
    {
        this.HashErrorCode = HashErrorCode
    }

    fun  getHasError ():String
    {
        return HasError;
    }

    fun  setHasError ( HasError:String)
    {
        this.HasError = HasError
    }

    @Override
    override fun  toString():String
    {
        return "Response [Message = "+Message+", UnixTime = "+UnixTime+", Server = "+Server+", Data = "+Data+", HashErrorCode = "+HashErrorCode+", HasError = "+HasError+"]";
    }
}