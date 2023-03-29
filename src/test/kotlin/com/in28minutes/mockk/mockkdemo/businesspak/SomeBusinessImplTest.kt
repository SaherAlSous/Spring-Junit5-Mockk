package com.in28minutes.mockk.mockkdemo.businesspak

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SomeBusinessImplTest {
    companion object {
        @MockK
        private lateinit var dataService: DataService
        private lateinit var someBusinessImpl: SomeBusinessImpl
    }

    @BeforeEach
    fun `Initialize Mockk`() {
        dataService = mockk<DataService>()
        someBusinessImpl = SomeBusinessImpl(dataService)
    }

    @Test
    fun `Testing not null`() {
        Assertions.assertNotNull(dataService)
    }

    @Test
    fun `Retrieving Data from Interface`() {
        every { dataService.retrieveData() } returns listOf(25, 15 ,5)
        val result = someBusinessImpl.findTheGreatestFromAllData()

        Assertions.assertEquals(25, result)
    }
}