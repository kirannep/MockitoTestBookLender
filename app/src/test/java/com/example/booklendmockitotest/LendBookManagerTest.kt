package com.example.booklendmockitotest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LendBookManagerTest {

//These below annotations are only used when class being tested have background thread and Livedata
//    @Rule
//    @JvmField
//    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockbookService:BookService
    private lateinit var lendBookManager: LendBookManager

    @Before
    fun setUp(){
        lendBookManager = LendBookManager(mockbookService)
        `when`(mockbookService. inStock(100)).thenReturn(true)
    }


    //Verifying if lend method is actually called
    @Test
    fun testCheckoutMethod() {
        lendBookManager.checkout(100,1)
        verify(mockbookService).lend(100,1)
    }

    //Testing if expected gives illegaleStateException by passing true in line 44. If its true, it wont throw error
    @Test(expected = IllegalStateException::class)
    fun whenBookIsNotAvailable_thenAnExceptionIsThrown() {
        `when`(mockbookService. inStock(100)).thenReturn(false)
        lendBookManager = LendBookManager(mockbookService)
        lendBookManager.checkout(100, 1)
    }

    @Test
    fun testUpdateUImethod(){
        lendBookManager.updateUI("summer")
        verify(mockbookService).checkbook("summer")
    }
}