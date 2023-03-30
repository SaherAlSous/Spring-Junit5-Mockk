package com.in28minutes.mockk.mockkdemo.businesspak

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
class SomeBusinessImplTest {

    companion object {
        @MockK
        private lateinit var dataService: DataService
        private lateinit var someBusinessImpl: SomeBusinessImpl

        @JvmStatic
        @BeforeAll
        fun `Initialize Classes`() {
            dataService = mockk<DataService>()
            someBusinessImpl = SomeBusinessImpl(dataService)
        }
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