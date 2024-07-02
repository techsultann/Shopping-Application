package com.techsultan.staticshoppingapplication.repository

import androidx.lifecycle.LiveData
import com.techsultan.staticshoppingapplication.db.CartDao
import com.techsultan.staticshoppingapplication.models.CheckoutItems

class Repository(private val dao: CartDao) {
    //val allCartItems: LiveData<List<CheckoutItems>> = dao.getAllCartItems().asLiveData()

    private val quantity = 1
    suspend fun addCartItem(id: Int, image: Int, name: String, price: Double) =

        dao.insertCartItem(CheckoutItems(id = id, image = image, name = name, price = price, quantity = quantity))

    suspend fun deleteCartItem(checkoutItems: CheckoutItems) = dao.deleteCartItem(checkoutItems)
    suspend fun getCartItems() = dao.getAllCartItems()

}