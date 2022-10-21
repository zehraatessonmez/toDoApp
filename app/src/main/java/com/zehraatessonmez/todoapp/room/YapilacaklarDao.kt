package com.zehraatessonmez.todoapp.room

import androidx.room.*
import com.zehraatessonmez.todoapp.data.entity.Yapilacaklar


@Dao
interface YapilacaklarDao {

    @Query("SELECT*FROM yapilacaklar")
    suspend fun yapilacaklariYukle() : List<Yapilacaklar>

    @Insert
    suspend fun kaydet(yapilacak: Yapilacaklar)

    @Update
    suspend fun guncelle(yapilacak: Yapilacaklar)

    @Delete
    suspend fun sil(yapilacak: Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%' ")
    suspend fun ara(aramaKelimesi:String): List<Yapilacaklar>
}