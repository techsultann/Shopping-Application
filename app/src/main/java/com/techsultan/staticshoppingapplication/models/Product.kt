package com.techsultan.staticshoppingapplication.models

import android.os.Parcelable
import com.techsultan.staticshoppingapplication.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val image: Int,
    val price: Double
) : Parcelable

val allProducts = listOf(

    Product(
        id = 1,
        name = "Beanie",
        image = R.drawable.beanie,
        price = 2500.00
    ),
    Product(
        id = 2,
        name = "Makavelli T-Shirt",
        image = R.drawable.makavelli_shirt,
        price = 12500.00
    ),
    Product(
        id = 3,
        name = "Fit Rigid Jeans",
        image = R.drawable.jean,
        price = 32350.00
    ),
    Product(
        id = 4,
        name = "Jesus T-Shirt",
        image = R.drawable.jesus_statue,
        price = 13000.00
    ),
    Product(
        id = 5,
        name = "Durag",
        image = R.drawable.durag,
        price = 4000.00
    ),
    Product(
        id = 6,
        name = "Women Crop Top",
        image = R.drawable.mockup_of_a_fashionable_woman,
        price = 13000.00
    ),
    Product(
        id = 7,
        name = "Love Code T-Shirt",
        image = R.drawable.love_code,
        price = 35000.00
    ),
    Product(
        id = 8,
        name = "Hip Jesus T-Shirt",
        image = R.drawable.mockup_of_a_man_with_a_hip_hop,
        price = 22000.00
    ),
    Product(
        id = 9,
        name = "Summer Street Shirt",
        image = R.drawable.streetwear_styled,
        price = 15000.00
    ),
    Product(
        id = 10,
        name = "Undefined White Shirt",
        image = R.drawable.undefined_white,
        price = 25000.00
    ),
    Product(
        id = 11,
        name = "Undefined Black Shirt",
        image = R.drawable.un_tshirt,
        price = 13000.00
    ),
    Product(
        id = 11,
        name = "Summer",
        image = R.drawable.summer_shirt,
        price = 14500.00
    )

)
