# AppGest
 Gestión de trabajadores-CCR & JM

AddWorler
La clase addWorker es una actividad de Android que se encarga de añadir un nuevo trabajador a la base de datos. En el método onCreate, se crea una instancia de la clase dataWorker, la cual es la encargada de manejar la base de datos SQLite donde se almacenan los trabajadores. Luego, se inicializa el Spinner que permite seleccionar el turno del nuevo trabajador, y se define un AdapterView.OnItemSelectedListener para obtener el valor seleccionado por el usuario.
Además, se definen los listeners para el botón "Enviar" y el LinearLayout "Listado", que permiten agregar un nuevo trabajador a la base de datos y mostrar el listado de trabajadores respectivamente. Cuando se presiona el botón "Enviar", se obtienen los valores de los EditText correspondientes al nombre y puesto del nuevo trabajador, y se inserta una nueva fila en la tabla "worker" de la base de datos. Si alguno de los campos está vacío, se muestra un mensaje de error mediante un Toast. Por otro lado, cuando se hace clic en el LinearLayout "Listado", se abre la actividad MainActivity para mostrar el listado de trabajadores.


DataWorker
La clase "dataWorker" es una clase que extiende de "SQLiteOpenHelper" y se encarga de manejar la base de datos SQLite de la aplicación. Tiene métodos para crear la tabla "worker" con sus respectivas columnas, agregar un nuevo trabajador a la base de datos, obtener todos los trabajadores almacenados, y eliminar un trabajador por su ID. Además, contiene constantes para el nombre de la base de datos, el nombre de la tabla y el nombre de las columnas de la tabla.


MainActivity
La clase MainActivity es la actividad principal de la aplicación. En su método onCreate(), se configura el RecyclerView para mostrar la lista de trabajadores obtenida a través de la instancia de la clase dataWorker. Además, se definen las acciones a realizar al hacer clic en los elementos del menú de navegación (en este caso, la opción de agregar trabajador abre la actividad addWorker).


Worker
La clase Worker es una clase modelo que representa a un trabajador y contiene sus atributos como id, nombre, horario y puesto. También tiene un constructor para inicializar un trabajador con estos atributos, así como métodos getter y setter para acceder y modificar los valores de sus atributos. Además, contiene un método toContentValues() que convierte un objeto Worker en un objeto ContentValues para su uso en la base de datos.

WorkersAdapter
Esta clase se encarga de crear un adaptador para el RecyclerView utilizado en la MainActivity. La clase define un ViewHolder que contiene los elementos de la vista de cada elemento en la lista (nombre, turno, puesto y botón de eliminación), y sobrescribe los métodos necesarios de RecyclerView.Adapter para mostrar los elementos de la lista de trabajadores en la vista.
En particular, el método onBindViewHolder() asigna los valores de nombre, turno y puesto a los elementos TextView correspondientes en el ViewHolder, y define un OnClickListener para el botón de eliminación que elimina el trabajador de la base de datos y actualiza la lista de trabajadores en la vista. El método getItemCount() devuelve el número total de elementos en la lista.

