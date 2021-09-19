package com.example.dh.model

import io.realm.RealmObject

open class Image  : RealmObject
{
    private lateinit var  Base64:String

    private lateinit var  ColorAvarage:String

    private lateinit var  Value:String

    private lateinit var  Height:String

    private lateinit var  Width:String
    constructor(Base64: String,ColorAvarage: String,Value: String,Height: String,Width: String){
        this.Base64=Base64
        this.ColorAvarage=ColorAvarage
        this.Value=Value
        this.Height=Height
        this.Width=Width
    }
    constructor(){

    }
    fun  getBase64 ():String
    {
        return Base64;
    }

    fun setBase64 ( Base64:String)
    {
        this.Base64 = Base64;
    }

    fun  getColorAvarage ():String
    {
        return ColorAvarage;
    }

    fun setColorAvarage ( ColorAvarage:String)
    {
        this.ColorAvarage = ColorAvarage;
    }

    fun  getValue ():String
    {
        return Value;
    }

    fun setValue ( Value:String)
    {
        this.Value = Value;
    }

    fun  getHeight ():String
    {
        return Height;
    }

    fun setHeight ( Height:String)
    {
        this.Height = Height;
    }

    fun  getWidth ():String
    {
        return Width;
    }

    fun setWidth ( Width:String)
    {
        this.Width = Width;
    }

    @Override
    override fun  toString():String
    {
        return "Image [Base64 = "+Base64+", ColorAvarage = "+ColorAvarage+", Value = "+Value+", Height = "+Height+", Width = "+Width+"]";
    }
}
