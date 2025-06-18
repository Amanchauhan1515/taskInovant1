package com.example.taskinovant

data class Product(
    val name: String,
    val price: String,
    val subtitle: String,
    val sku: String,
    val description: String,
    val paymentInfo1: String,
    val paymentInfo2: String,
    val swatches: List<Int>,
    val imageResId: Int,
    val tabby_logo: Int
)
