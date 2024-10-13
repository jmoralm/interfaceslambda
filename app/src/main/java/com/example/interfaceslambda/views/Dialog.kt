package com.example.interfaceslambda.views

import com.example.interfaceslambda.data.RepositoryClient
import com.example.interfaceslambda.logic.Client
import com.example.interfaceslambda.logic.Controller
import com.example.interfaceslambda.logic.intefaces.OperationsInterface

class Dialog (var controller : Controller) {

    private var listener: OperationsInterface? = null

    private var action : Int = 0

    fun setListener (_listener : OperationsInterface) {
        listener = _listener
    }

    fun show(typeAction : Int) {
        listener?.let {
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
    }

    private fun onDelete(id: Int) {
        listener!!.clientDel(id)
    }

    private fun onEdit(id : Int, name : String, lastName: String, phone: String) {
        listener!!.clientUpdate(id, name, lastName, phone)
    }

    private fun onAccept() {
        listener!!.clientAdd(RepositoryClient.primaryIncrement(), "NEW_CLIENT","NEW_LASTNAME", "NEW_PHONE")
    }
}