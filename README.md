# Proyecto Android - Interfaces - Lambdas

## RAMA MAIN - INTERFAZ
<br>

Métodos implementados en la interfaz OperationsInterface
![](doc/captura_1_Interfaces.png)

<br>

Clase Controller que maneja la lógica de negocio con los métodos CRUD
![](doc/captura_2_ClaseController.png)

<br>

Clase Dialog que simula la interacción con el usuario con un listener que recoge las interacciones.
<br>
![](doc/captura_3_ClaseDialog.png)

LogCat con trazas al hacer click en los iconos de la App
<br>
![](doc/captura_4_logconsole.png)

<br>
<br>
<br>
Código del metodo start() en el MainActivity:
<br>
        
    `private fun start() {

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
    }`

<br>
<br>
Métodos sobreescritos en el MainActivity que llaman al Controlador.
<br>

    `override fun clientAdd(id: Int, name: String, lastName: String, phone: String) {
        val newClient = Client(id, name, lastName, phone)
        controller.clientAddController(newClient)
        val msg = "Client with $id - Correctly added"

        Log.d(TAG, msg)

    }`

    `override fun clientDel(id: Int) {
        val delete = controller.clientDelController(id)
        if(delete)
            Log.d(TAG, "Client with $id -> DELETED")
        else
            Log.d(TAG, "Client with id $id NOT FOUND $id par")
    }`

    `override fun clientUpdate(id: Int, name: String, lastName: String, phone: String) {
        val update = controller.clientEditController(id, name, lastName, phone)
        if(update)
            Log.d(TAG, "Client $id, $name, $lastName, $phone -> UPDATED")
        else
            Log.d(TAG, "CANNOT UPDATE THIS CLIENT")
    }`
