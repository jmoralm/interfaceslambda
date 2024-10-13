package com.example.interfaceslambda.views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.interfaceslambda.R
import com.example.interfaceslambda.logic.Client
import com.example.interfaceslambda.logic.Controller

class MainActivity : AppCompatActivity(){

    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myDialog: Dialog
    private val controller = Controller()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge() // barra superior transparente. App de borde a borde
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Log.d(TAG, "¡¡Hola!!")
        start()
    }

    private fun start() {

        myButtonAdd = findViewById(R.id.imageView_myButtonAdd)
        myButtonDel = findViewById(R.id.imageView_myButtonDel)
        myButtonUpdate = findViewById(R.id.imageView_myButtonEdit)

        myDialog = Dialog(controller,

            { id, name, lastName, phone ->
                clientAdd(id, name, lastName, phone) },

            { id, name, lastName, phone ->
                clientUpdate(id, name, lastName, phone)
            },

            { id ->
                clientDel(id) })

        myButtonAdd.setOnClickListener {
            //
            myDialog.show(0)
        }

        myButtonDel.setOnClickListener {
            myDialog.show(2)
        }

        myButtonUpdate.setOnClickListener {
            myDialog.show(1)
        }
    }

    private fun clientDel(id: Int){
        val deleted = controller.clientDelController(id)
        if(deleted)
            Log.d(TAG, "CLIENT WITH ID $id DELETED")
        else
            Log.d(TAG, "CANNOT DELETE CLIENT WITH ID $id")
    }

    private fun clientUpdate(id: Int, name: String, lastName: String, phone: String) {
        val update = controller.clientEditController(id, name, lastName, phone)
        if (update)
            Log.d(TAG, "CLIENT WITH ID $id, UPDATED")
        else
            Log.d(TAG, "CANNOT UPDATE CLIENT WITH ID $id")
    }

    private fun clientAdd(id: Int, name: String, lastName: String, phone: String) {
        val newClient = Client(id, name, lastName, phone)
        controller.clientAddController(newClient)
        Log.d(TAG, "Client with ID: $id -> ADDED")
    }

    companion object {
        const val TAG = "----SALIDA----"
    }
}