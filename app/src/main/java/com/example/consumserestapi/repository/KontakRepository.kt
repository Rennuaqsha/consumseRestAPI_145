package com.example.consumserestapi.repository
import com.example.consumserestapi.model.Kontak
import com.example.consumserestapi.service_api.KontakService

interface KontakRepository {
    /** Fetches list of kontak from kontakApi*/
    suspend fun getKontak(): List<Kontak>
}
class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository{
    /**Fetches list of kontak from kontakApi */
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}