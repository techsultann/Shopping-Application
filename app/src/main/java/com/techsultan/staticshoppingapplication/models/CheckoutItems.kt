package com.techsultan.staticshoppingapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "cart_items")
data class CheckoutItems(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: Int,
    val price: Double,
    val quantity: Int
)
