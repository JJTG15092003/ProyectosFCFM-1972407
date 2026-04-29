"Por lo que entiendo, el bestiario ya no se arma de los constructores de Monstruo.java, sino que ahora tiene que
armarse de ademas otras dos clases con sus respectivos constructores y metodos no? O creo que me confundo un poco
con las jerarquias de lo que me piden."
Respuesta de la IA:
- Me explico que estaba equivocado, que en realidad tenia que crear interfaces, y estas como en la practica pasada,
    le otorgarian propiedades unicas a mis monstruos, y podia combinarlas para crear diferentes propiedades.

"Conversador tiene los metodos de intimidar y domesticar, los cuales se esperan que esten presentes si mi clase llama
a la interfaz completa. Pero por ejemplo, en mi ChaosSlime, quiero que solamente use persuadir, pues me interesa que
se llame la parte negativa de esos metodos en bestiario, por que no puede ni ser domesticado, ni intimidado.
Pero no ponerlas en ChaosSlime me da error por que de a fuerza debe de estar. Se puede arreglar esto?"
Respuesta de la IA:
- Me enseño a colocar "default" en mis metodos de interfaces. De esta manera puedo crear una situacion default y no
    tener que escribirla dentro de cada uno de mis monstruos si es que en ellos no aplica