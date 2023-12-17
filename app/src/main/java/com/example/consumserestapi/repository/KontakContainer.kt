package com.example.consumserestapi.repository

import com.example.consumserestapi.service_api.KontakService

interface AppContainer{
    val kontakRepository: KontakRepository
}

class KontakContainer : AppContainer {
    private val baseUrl = "https://kancadonor.net//donorq/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val kontakService: KontakService by lazy {
        retrofit.create(KontakService::class.java)
    }
    override val kontakRepository: KontakRepository by lazy {
        NetworkKontakRepository(kontakService)
    }
}