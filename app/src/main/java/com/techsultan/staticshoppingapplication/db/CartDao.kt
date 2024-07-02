package com.techsultan.staticshoppingapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techsultan.staticshoppingapplication.models.CheckoutItems

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CheckoutItems)

    @Delete
    suspend fun deleteCartItem(cartItem: CheckoutItems)

    @Query("SELECT * FROM cart_items")
    suspend fun getAllCartItems(): List<CheckoutItems>
}