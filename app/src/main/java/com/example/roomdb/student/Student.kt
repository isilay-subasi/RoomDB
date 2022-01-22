package com.example.roomdb.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "student")
data class Student(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "studentId")
    var studentId: Int = 0,

    @ColumnInfo(name = "studentName")
    var studentName: String,

    @ColumnInfo(name = "studentGrade")
    var studentGrade: Int


)
