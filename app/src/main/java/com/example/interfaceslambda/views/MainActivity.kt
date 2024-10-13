package com.example.interfaceslambda.views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.interfaceslambda.R
import com.example.interfaceslambda.logic.Client
import com.example.interfaceslambda.logic.Controller
import com.example.interfaceslambda.logic.intefaces.OperationsInterface

class MainActivity : AppCompatActivity(), OperationsInterface {

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

        myDialog = Dialog(controller)
        myDialog.setListener(this)

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

    companion object {
        const val TAG = "----SALIDA----"
    }

    override fun clientAdd(id: Int, name: String, lastName: String, phone: String) {
        val newClient = Client(id, name, lastName, phone)
        controller.clientAddController(newClient)
        val msg = "Client with $id - Correctly added"

        Log.d(TAG, msg)

    }

    override fun clientDel(id: Int) {
        val delete = controller.clientDelController(id)
        if(delete)
            Log.d(TAG, "Client with $id -> DELETED")
        else
            Log.d(TAG, "Client with id $id NOT FOUND $id par")
    }

    override fun clientUpdate(id: Int, name: String, lastName: String, phone: String) {
        val update = controller.clientEditController(id, name, lastName, phone)
        if(update)
            Log.d(TAG, "Client $id, $name, $lastName, $phone -> UPDATED")
        else
            Log.d(TAG, "CANNOT UPDATE THIS CLIENT")
    }
}