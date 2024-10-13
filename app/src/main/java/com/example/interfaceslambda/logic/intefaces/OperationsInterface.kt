package com.example.interfaceslambda.logic.intefaces

interface OperationsInterface {

    fun clientAdd(id: Int, name: String, lastName: String, phone: String)
    fun clientDel(id: Int)
    fun clientUpdate(id: Int, name:String, lastName: String, phone: String)

}