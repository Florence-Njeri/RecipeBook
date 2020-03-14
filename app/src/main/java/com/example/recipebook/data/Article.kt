package com.example.recipebook.data
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    @Json(name = "author")
    val author: String?=null,
    @Json(name = "publishedAt")
    val publishedAt: String?=null,
    @Json(name = "title")
    val title: String?=null,
    @Json(name = "url")
    val url: String?=null,
    @Json(name = "urlToImage")
    val urlToImage: String?=null,
    @Json(name = "description")
    val description:String?=null

):Parcelable
