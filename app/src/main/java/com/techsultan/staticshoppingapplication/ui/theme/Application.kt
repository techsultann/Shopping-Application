package com.techsultan.staticshoppingapplication.ui.theme

import android.app.Application
import com.techsultan.staticshoppingapplication.db.AppDataBase
import com.techsultan.staticshoppingapplication.repository.Repository

class ShopApplication : Application() {
    val database by lazy { AppDataBase.createDataBase(this) }
    val repository by lazy { Repository(database.cartDao()) }
}