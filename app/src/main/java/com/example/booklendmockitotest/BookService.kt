package com.example.booklendmockitotest

interface BookService {
    fun inStock(bookId: Int): Boolean
    fun lend(bookId: Int, memberId: Int)
    fun checkbook(bookname:String)
}