package com.example.sosalud.data

import com.example.sosalud.R
import com.example.sosalud.model.Services

class DataServices {

    fun loadServices(): List<Services>{
        return listOf<Services>(
            Services(R.string.Service1, R.drawable.tomapresion),
            Services(R.string.Service2, R.drawable.tomaazucar),
            Services(R.string.Service3, R.drawable.inyeccion),
            Services(R.string.Service4, R.drawable.chequeocardiaco),
            Services(R.string.Service5, R.drawable.chequeogeneral),
            Services(R.string.Service6, R.drawable.chequeovision),
            Services(R.string.Service7, R.drawable.pruebacovid),
            Services(R.string.Service8, R.drawable.muestraslaboratorio),
            Services(R.string.Service9, R.drawable.odontologia),
            Services(R.string.Service10, R.drawable.rayosx)
        )
    }
}