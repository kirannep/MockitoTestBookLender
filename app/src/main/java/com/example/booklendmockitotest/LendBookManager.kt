package com.example.booklendmockitotest

class LendBookManager(val bookService:BookService) {
    fun checkout(bookId: Int, memberId: Int) {
        if(bookService.inStock(bookId)) {
            bookService.lend(bookId, memberId)
        } else {
            throw IllegalStateException("Book is not available")
        }
    }

    fun updateUI(str: String) {
        bookService.checkbook(str)
    }

    fun booleanbook(str: String,bookId: Int){
        bookService.bool(str,bookId)
    }
}