package com.example.roomdb.book

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.book.Book
import com.example.roomdb.book.BookDao


@Database(entities = [Book::class],version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao() : BookDao

}