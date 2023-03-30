package com.in28minutes.mockk.mockkdemo.list

import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class, MockKExtension::class)
class ListTest {

    companion object {
        @MockK
        private lateinit var myList: List<Any?>

        @JvmStatic
        @BeforeAll
        fun `Initializing List`() {
            myList = mockk()
        }

        @JvmStatic
        @AfterAll
        fun `Clear and UnMock All`() {
            clearMocks(myList)
            unmockkAll()
        }
    }


    @Test
    fun `Testing List with Mockk`() {
        every { myList.size } returns 3
        assertEquals(3, myList.size)
    }

    @Test
    fun `Multiple returns from List`() {
        every { myList.size } returnsMany (listOf(1, 2, 123))
        assertEquals(1, myList.size)
        assertEquals(2, myList.size)
        assertEquals(123, myList.size)
    }

    @Test
    fun `Specific Parameters`() {
        every { myList[0] } returns "Some String"
        every { myList[1] } returns null
        assertEquals("Some String", myList[0])
        assertEquals(null, myList[1])
    }

    @Test
    fun `Generic Parameters`() {
        every { myList[mockk()] } returns "Some String"
        assertEquals("Some String", myList[0])
    }


}