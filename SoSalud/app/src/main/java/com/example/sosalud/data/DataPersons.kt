package com.example.sosalud.data

import com.example.sosalud.R
import com.example.sosalud.model.Persons
import com.example.sosalud.model.Services

class DataPersons {

    fun loadPersons(): List<Persons>{
        return listOf<Persons>(
            Persons(R.string.Person1,R.string.Hour1,R.string.Addres1,R.drawable.fernanda)
        )
    }
}