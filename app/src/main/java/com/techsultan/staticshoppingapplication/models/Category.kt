package com.techsultan.staticshoppingapplication.models

import com.techsultan.staticshoppingapplication.R
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Int,
    val name: String,
    val image: Int
)

val categoryList = listOf(
    Category(
        id = 1,
        name = "T-shirt",
        image = R.drawable.un_tshirt
    ),
    Category(
        id = 2,
        name = "Beanie",
        image = R.drawable.beanie
    ),
    Category(
        id = 3,
        name = "Jeans",
        image = R.drawable.jean
    ),
    Category(
        id = 4,
        name = "Watch",
        image = R.drawable.watch
    ),
    Category(
        id = 5,
        name = "Durag",
        image = R.drawable.durag
    )
)
