package com.example.consumserestapi

import android.app.Application
import com.example.consumserestapi.repository.AppContainer
import com.example.consumserestapi.repository.KontakContainer

class KontakAplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain depedencies */
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container = KontakContainer()
    }
}