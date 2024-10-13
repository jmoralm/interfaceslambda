package com.example.interfaceslambda.data

import com.example.interfaceslambda.logic.Client

class RepositoryClient {
    companion object {

        var primary = 100

        val clientList: List<Client> = listOf(
            Client(primaryIncrement(), "José", "Morillo", "678945365"),
            Client(primaryIncrement(), "Manuel", "Tavira", "673789345"),
            Client(primaryIncrement(), "Santiago", "Fuentes", "789345098"),
            Client(primaryIncrement(), "Angela", "Romero", "734123444")
        )

        fun primaryIncrement() = primary++
    }
}