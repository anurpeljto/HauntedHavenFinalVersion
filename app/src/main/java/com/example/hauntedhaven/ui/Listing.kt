package com.example.hauntedhaven.ui

data class Listing(
    val title: String,
    val location: String,
    val image: Int,
    val category: listingCategory,
    val routee:String
)