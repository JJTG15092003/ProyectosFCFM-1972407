"Como se utilizan los hilos en java a diferencia de C++?"
Repuesta de la IA:
- En Java me muesta que existe el Garbage collector que se encarga de limpiar los residuos de los hilos, que a
    diferencia de C++, tenia que encargarme de ellos personalmente con join() u detach()

"Para que sirve public synchronized?"
Respuesta de la IA:
- Sirve para crear un "candado" para que cuando los hilos quieran acceder a metodos marcados con synchronized, tengan
    que esperar a que los hilos que llegaron primero terminen su trabajo. De esta manera evita los "Race Conditions"
    que consisten en hilos modificando una variable al mismo tiempo

"para que sirve ExecutorService y por que se le agrega el "Executors.newFixedThreadPool" ¿que funcion logran en el
codigo?"
Respuesta de la IA:
- El ExecutorService es un framework que gestiona el como se hacen las tareas "asincronas". El newFixedThreadPool
    es similar a los pools de Unity. Pero en lugar de guardar prefabs para reutilizarlos, guarda hilos para llenarlos
    otra vez con tareas