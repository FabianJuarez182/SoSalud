package com.example.sosalud.data

import com.example.sosalud.R
import com.example.sosalud.model.Services

class DataServices {

    fun loadServices(): List<Services>{
        return listOf<Services>(
            Services(R.string.Service1, R.drawable.tomaPresion),
            Services(R.string.Service2, R.drawable.tomaAzucar),
            Services(R.string.Service3, R.drawable.inyeccion),
            Services(R.string.Service4, R.drawable.chequeoCardiaco),
            Services(R.string.Service5, R.drawable.chequeoGeneral),
            Services(R.string.Service6, R.drawable.chequeoVision),
            Services(R.string.Service7, R.drawable.pruebaCovid),
            Services(R.string.Service8, R.drawable.muestrasLaboratorio),
            Services(R.string.Service9, R.drawable.odontologia),
            Services(R.string.Service10, R.drawable.rayosX)
        )
    }
}