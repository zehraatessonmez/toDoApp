package com.zehraatessonmez.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zehraatessonmez.todoapp.data.entity.Yapilacaklar


@Database(entities = [Yapilacaklar::class], version = 4)
abstract class Veritabani : RoomDatabase() {
    abstract fun getYapilacaklarDao() : YapilacaklarDao
}