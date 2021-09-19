package com.example.dh.model

import io.realm.RealmObject

open class Data : RealmObject{


    private lateinit var Image: Image

    private lateinit var Url: String

    private lateinit var TextColor: String

    private lateinit var TotalComment: String

    private lateinit var ShareCount: String

    private lateinit var ColorAvarage: String


    private lateinit var Title: String

    private lateinit var ShortContent: String

    private  var Favorite: Boolean = false

    private lateinit var Type: String


    private lateinit var FavoriteCount: String


    private lateinit var Id: String

    private lateinit var SubTextColor: String

    constructor(
        ShortContent: String,
        Image: Image,
        Url: String,
        TextColor: String,
        TotalComment: String,
        ShareCount: String,
        ColorAvarage: String,
        Title: String,
        Favorite: Boolean,
        Type: String,
        FavoriteCount: String,
        Id: String,
        SubTextColor: String
    ) {
        this.Url = Url
        this.TextColor = TextColor
        this.TotalComment = TotalComment
        this.ShareCount = ShareCount
        this.ColorAvarage = ColorAvarage
        this.Title = Title
        this.Favorite = Favorite
        this.Type = Type
        this.FavoriteCount = FavoriteCount
        this.Id = Id
        this.Image = Image
        this.ShortContent = ShortContent
        this.SubTextColor = SubTextColor
    }

    constructor(){

    }

    fun getImage(): Image {
        return Image;
    }

    fun setImage(Image: Image) {
        this.Image = Image;
    }

    fun getShortContent(): String {
        return ShortContent;
    }

    fun setShortContent(ShortContent: String) {
        this.ShortContent = ShortContent;
    }

    fun getUrl(): String {
        return Url;
    }

    fun setUrl(Url: String) {
        this.Url = Url
    }

    fun getTextColor(): String {
        return TextColor
    }

    fun setTextColor(TextColor: String) {
        this.TextColor = TextColor
    }

    fun getTotalComment(): String {
        return TotalComment
    }

    fun setTotalComment(TotalComment: String) {
        this.TotalComment = TotalComment
    }


    fun getShareCount(): String {
        return ShareCount
    }

    fun setShareCount(ShareCount: String) {
        this.ShareCount = ShareCount
    }


    fun getColorAvarage(): String {
        return ColorAvarage
    }

    fun setColorAvarage(ColorAvarage: String) {
        this.ColorAvarage = ColorAvarage
    }


    fun getTitle(): String {
        return Title
    }

    fun setTitle(Title: String) {
        this.Title = Title
    }


    fun getIsFavorite(): Boolean {
        return Favorite
    }

    fun setIsFavorite(Favorite: Boolean) {
        this.Favorite = Favorite
    }

    fun getType(): String {
        return Type
    }

    fun setType(Type: String) {
        this.Type = Type;
    }


    fun getFavoriteCount(): String {
        return FavoriteCount
    }

    fun setFavoriteCount(FavoriteCount: String) {
        this.FavoriteCount = FavoriteCount
    }

    fun getId(): String {
        return Id
    }

    fun setId(Id: String) {
        this.Id = Id
    }

    fun getSubTextColor(): String {
        return SubTextColor
    }

    fun setSubTextColor(SubTextColor: String) {
        this.SubTextColor = SubTextColor
    }

    @Override
    override fun toString(): String {
        return "Data [Image = " + Image + ", Url = " + Url + ", TextColor = " + TextColor + ", TotalComment = " + TotalComment + ", ShareCount = " + ShareCount + ", ColorAvarage = " + ColorAvarage + ", Title = " + Title + ", Favorite = " + Favorite + ", Type = " + Type + ", FavoriteCount = " + FavoriteCount + ", Id = " + Id + ", SubTextColor = " + SubTextColor + "]"
    }
}
