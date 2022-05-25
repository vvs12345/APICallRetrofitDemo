//package com.example.apicallretrofitdemo.datamodels
//
//import com.squareup.moshi.JsonClass
//import com.squareup.moshi.Json
//import com.example.apicallretrofitdemo.datamodels.Datum
//import com.example.apicallretrofitdemo.datamodels.Support
//
//@JsonClass(generateAdapter = true)
//class Example {
//    @get:Json(name = "page")
//    @set:Json(name = "page")
//    @Json(name = "page")
//    var page: Int? = null
//
//    @get:Json(name = "per_page")
//    @set:Json(name = "per_page")
//    @Json(name = "per_page")
//    var perPage: Int? = null
//
//    @get:Json(name = "total")
//    @set:Json(name = "total")
//    @Json(name = "total")
//    var total: Int? = null
//
//    @get:Json(name = "total_pages")
//    @set:Json(name = "total_pages")
//    @Json(name = "total_pages")
//    var totalPages: Int? = null
//
//    @get:Json(name = "data")
//    @set:Json(name = "data")
//    @Json(name = "data")
//    var data: List<Datum>? = null
//
//    @get:Json(name = "support")
//    @set:Json(name = "support")
//    @Json(name = "support")
//    var support: Support? = null
//}