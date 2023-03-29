package com.in28minutes.mockk.mockkdemo.businesspak

class SomeBusinessImpl(
    private val dataService: DataService
) {

    fun findTheGreatestFromAllData(): Int {
        val result = dataService.retrieveData()
        return result.max()
    }

}