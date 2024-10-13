package com.example.interfaceslambda.views

import com.example.interfaceslambda.data.RepositoryClient
import com.example.interfaceslambda.logic.Controller

class Dialog(
    var controller: Controller,
    var clientAdd: (Int, String, String, String) -> Unit,
    var clientUpdate: (Int, String, String, String) -> Unit,
    var clientDel: (Int) -> Unit
) {

    private var action : Int = 0

    fun show(typeAction : Int) {
            val posibleName = "CAMBIADO"
            val randomId = controller.devIdRandom()
            when (typeAction) {
                0 -> onAccept()
                1 ->
                    if (randomId != -1)
                        onEdit(randomId, "NOMBRE_CAMBIADO", "APELLIDO_CAMBIADO", "TELEFONO_CAMBIADO")
                2 ->
                    if (randomId != -1)
                        onDelete(randomId)
            }
        }

    private fun onDelete(id: Int) {
        clientDel(id)
    }

    private fun onEdit(id : Int, name : String, lastName: String, phone: String) {
        clientUpdate(id, name, lastName, phone)
    }

    private fun onAccept() {
        clientAdd(RepositoryClient.primaryIncrement(), "NEW_CLIENT","NEW_LASTNAME", "NEW_PHONE")
    }
}