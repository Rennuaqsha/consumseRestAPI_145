package com.example.consumserestapi.service_api
import com.example.consumserestapi.model.Kontak
import retrofit2.http.GET
import retrofit2.http.Headers


interface KontakService {
    @Headers(
    "Accept: application/json"    )
    @GET("siswa.json")
    suspend fun getKontak(): List<Kontak>
}