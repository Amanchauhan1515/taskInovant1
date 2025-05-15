package com.example.taskinovant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {

    private val _isProductInfoExpanded = MutableLiveData(false)
    val isProductInfoExpanded: LiveData<Boolean> = _isProductInfoExpanded

    fun toggleProductInfo() {
        _isProductInfoExpanded.value = _isProductInfoExpanded.value?.not()
    }


    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    init {
        loadSwatches()
    }

    private fun loadSwatches() {
        _product.value = Product(
            swatches = listOf(
                R.drawable.honey,
                R.drawable.blended_grey,
                R.drawable.brownish,
                R.drawable.caramello,
                R.drawable.cloudio,
                R.drawable.coffee,
                R.drawable.greyish,
                R.drawable.mistic,
                R.drawable.olivia,
                R.drawable.russet
            )
        )
    }
}
