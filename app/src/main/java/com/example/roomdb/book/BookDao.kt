package com.example.roomdb.book

import androidx.room.*
import com.example.roomdb.book.Book


@Dao
interface BookDao {

    @Insert
    suspend fun insertBook(book: Book)


    @Query("SELECT * FROM books_table")
    fun getAllBooks(): List<Book>

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

}