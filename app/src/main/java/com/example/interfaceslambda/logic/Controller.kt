package com.example.interfaceslambda.logic

import com.example.interfaceslambda.data.RepositoryClient
import kotlin.random.Random

class Controller {

    private var myListClient: MutableList<Client>

    init {
        myListClient = RepositoryClient.clientList.toMutableList()
    }

    fun clientAddController(cli: Client) {
        myListClient.add(cli)
    }

    fun clientDelController(id: Int) :Boolean = myListClient.removeAll { it.id == id }

    fun clientEditController(id: Int, name: String, lastName: String, phone: String) :Boolean {
        val findClient: Client? = myListClient.find { it.id == id }
        return findClient?.let {
            it.name = name
            it.lastName = lastName
            it.phone = phone
            true
        }?:false
    }

    fun showData() = myListClient.toString()

    fun devIdRandom() : Int {
        return if (myListClient.size == 0)
            -1
        else {
            val p = Random.nextInt(0, myListClient.size)
            myListClient[p].id
        }
    }
}