package com.techsultan.staticshoppingapplication.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techsultan.staticshoppingapplication.models.CheckoutItems


@Database(entities = [CheckoutItems::class], version = 1, exportSchema = true)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cartDao() : CartDao

    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun createDataBase(context: Context) : AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "shop_db"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}