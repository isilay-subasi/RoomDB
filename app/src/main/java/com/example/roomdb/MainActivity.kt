package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.roomdb.book.Book
import com.example.roomdb.book.BookDao
import com.example.roomdb.book.BookDatabase
import com.example.roomdb.databinding.ActivityMainBinding
import com.example.roomdb.student.Student
import com.example.roomdb.student.StudentDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // ->BookDatabase
    //private lateinit var bookDao: BookDao


    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        /* ->BookDatabase

            val db = Room.databaseBuilder(
            applicationContext,
            BookDatabase::class.java, "book_database"
        ).build()

        bookDao=db.bookDao()
         */

        val studentDatabase = StudentDatabase.getStudentDatabase(this)


        mainBinding.buttonSave.setOnClickListener {

            val name = mainBinding.editTextStudentName.text.toString()
            val grade = Integer.valueOf(mainBinding.editTextTextStudentGrade.text.toString())

            val student = Student(studentName = name, studentGrade = grade)
            studentDatabase?.studentDao()?.insert(student)

        }

        mainBinding.buttonAllStudent.setOnClickListener {

            var result = ""

            val students: ArrayList<Student> =
                studentDatabase?.studentDao()?.getAllStudent() as ArrayList<Student>

            students.forEach {

                result += it.studentName + "->" + it.studentGrade + "\n"
            }

            mainBinding.textViewResult.text = result
        }

    }



    }

    //Dao arayüzünde tanımladığımız veritabanı fonksiyonlarını test etmek için bir fonksiyon
    //Book-Database
    /*
        private fun testDb(){

        //Arkaplanda çalıştırmak için: coroutine,launch
        lifecycleScope.launch(Dispatchers.IO) {

            //Insert
            Log.i("MyTAG","*****     Inserting 3 Books     **********")
            bookDao.insertBook(Book(0,"Java","Alex"))
            bookDao.insertBook(Book(0,"PHP","Mike"))
            bookDao.insertBook(Book(0,"Kotlin","Amelia"))
            Log.i("MyTAG","*****     Inserted 3 Books       **********")

            //Query
            val books = bookDao.getAllBooks()
            Log.i("MyTAG","*****   ${books.size} books there *****")
            for(book in books){
                Log.i("MyTAG","id: ${book.id} name: ${book.name} author: ${book.author}")
            }

            //Update
            Log.i("MyTAG","*****      Updating a book      **********")
            bookDao.updateBook(Book(1,"PHPUpdated","Mike"))
            //Query
            val books2 = bookDao.getAllBooks()
            Log.i("MyTAG","*****   ${books2.size} books there *****")
            for(book in books2){
                Log.i("MyTAG","id: ${book.id} name: ${book.name} author: ${book.author}")
            }

            //delete
            Log.i("MyTAG","*****       Deleting a book      **********")
            bookDao.deleteBook(Book(2,"Kotlin","Amelia"))
            //Query
            val books3 = bookDao.getAllBooks()
            Log.i("MyTAG","*****   ${books3.size} books there *****")
            for(book in books3){
                Log.i("MyTAG","id: ${book.id} name: ${book.name} author: ${book.author}")
            }



        }
    }
     */



