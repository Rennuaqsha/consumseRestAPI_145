package com.example.consumserestapi.ui.home.viewmodel

import retrofit2.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumserestapi.model.Kontak
import com.example.consumserestapi.repository.KontakRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed class KontakUIState{
    data class Success(val kontak: List<Kontak> ) : KontakUIState()
    object Error : KontakUIState()
    object Loading : KontakUIState()
}


class HomeViewModel(private val KontakRepository: KontakRepository) : ViewModel() {
    var KontakUiState: KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set

    init {
        getKontak()
    }

    fun getKontak() {
        viewModelScope.launch {
            KontakUiState = KontakUIState.Loading
            KontakUiState= try {
                KontakUIState.Success(KontakRepository.getKontak())
            } catch (e: IOException) {
                KontakUIState.Error
            } catch (e: HttpException) {
                KontakUIState.Error
            }
        }
    }
}