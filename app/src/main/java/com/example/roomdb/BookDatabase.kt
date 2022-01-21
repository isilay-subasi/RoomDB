package com.example.roomdb

import androidx.room.Database


@Database(entities = [Book::class],version = 1)
abstract class BookDatabase {
    abstract fun bookDao() :BookDao

}