package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    var onSaveSuccess = MutableLiveData<Boolean>()

    var shoeItem = MutableLiveData(Shoe("", 0.0, "", ""))

    init {
        initShoeList()
    }

    private fun initShoeList() {
        val listShoeInit = mutableListOf(
            Shoe(
                name = "Shoe 1",
                size = 43.0,
                company = "Zhivago 1",
                description = "Description 1"
            ),
            Shoe(
                name = "Shoe 2",
                size = 42.0,
                company = "Zhivago 2",
                description = "Description 2"
            ),
            Shoe(
                name = "Shoe 3",
                size = 35.0,
                company = "Zhivago 3",
                description = "Description 3"
            ),
            Shoe(
                name = "Shoe 4",
                size = 42.0,
                company = "Zhivago 4",
                description = "Description 4"
            ),
            Shoe(
                name = "Shoe 5",
                size = 23.0,
                company = "Zhivago 5",
                description = "Description 5"
            )
        )
        _shoes.value = listShoeInit
    }

    fun saveShoe(shoe: Shoe?) {
        shoe?.let {
            _shoes.value?.add(it)
        }
        onSaveSuccess.value = true
    }
}