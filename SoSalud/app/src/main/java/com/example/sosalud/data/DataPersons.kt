package com.example.sosalud.data

import com.example.sosalud.R
import com.example.sosalud.model.Persons
import com.example.sosalud.model.Services

class DataPersons {

    fun loadPersons(): List<Persons>{
        return listOf<Persons>(
            Persons(R.string.Person1,R.string.Hour1,R.string.Addres1,R.drawable.fernanda),
            Persons(R.string.Person2,R.string.Hour2,R.string.Addres2,R.drawable.marcos),
            Persons(R.string.Person3,R.string.Hour3,R.string.Addres3,R.drawable.jose),
            Persons(R.string.Person4,R.string.Hour4,R.string.Addres4,R.drawable.javier),
            Persons(R.string.Person5,R.string.Hour5,R.string.Addres5,R.drawable.clarissa),
            Persons(R.string.Person6,R.string.Hour6,R.string.Addres6,R.drawable.sofia)
        )
    }
}