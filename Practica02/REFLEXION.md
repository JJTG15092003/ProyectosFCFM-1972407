1. ¿Cuál es la diferencia entre una clase y un objeto? Da un ejemplo con tu
   propio código.
   - La clase es un contenedor para objetos, en ella se guardan las descripciones y las interacciones
   de los objetos para poder llamarlas desde otras funciones. Los objetos, por otro lado, son un conjunto
   de atributos, osease, empiezan a ser "algo" cuando se les asignan atributos, como el nombre, nivel, vida, etc.
   En mi código por ejemplo, estoy guardando una clase llamada "Monstruo", este Monstruo tiene sus "Atributos"
   que no son más que sus características especiales y únicas como su vida, nivel o nombre.


2. ¿Por qué usaste 3 constructores distintos? ¿Qué problema resuelve cada
   uno?
   - Usar tres, me permite ser más específico o ambigüo a la hora de diseñar un nuevo monstruo. Si por X motivo
   quisiera diseñar a un enemigo simple que solo tuviera el nombre, estar obligado a tener que agregarselo por
   un constructor podria ser algo negativo a largo plazo, más sín embargo, al crear más, me otorga más libertad.
   Por poner un ejemplo que no se toca en esta práctica, imagina que deseo en la misma clase declarar enemigos y
   aliados por igual. Ambos comparten cosas como el nombre y tipo, pero un aliado no puede ser un jefe, y un
   enemigo no puede tener una "tienda" para comprarle items, asi que creamos dos constructores, uno que contemple
   el booleano "esJefe" para los enemigos, y otro con el "tieneTienda" para los aliados.


3. ¿Qué pasaría si no tuvieras constructores definidos? ¿Java sigue
   funcionando? ¿Por qué?
   - Java necesita darle datos a los objetos para poder guardarlos en sus espacios de memoria, pero al no tener
   un constructor definido, Java crea el suyo propio, pero le agrega datos por default, en el caso de mi practica,
   aunque si declare un estado default, de no haberlo hecho, Java hubiera considerado el default con puros ceros, 
   los booleanos a "false", y los strings a "null"