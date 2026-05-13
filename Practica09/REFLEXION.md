1. ¿Qué es la serialización y cuándo es útil en comparación con guardar
   texto plano?
    - Esta "empaqueta" los datos en una secuencia de bytes. Es util para guardar los datos de los monstruos, o en
    general de datos grandes. Pues me ahorra el tener que convertirlos a texto, luego releerlos a codigo otra vez.
    Los mandan de forma directa y permite su lectura rapida.
2. ¿Por qué usamos =BufferedReader= en lugar de leer byte a byte? ¿Qué
   mejora en rendimiento ofrece?
    - Este crea una pequeña "isla" de bytes, en lugar de andar leyendo byte a byte todos los datos, que en el caso de
    mi proyecto es sumamente tardado, directamente se guardan en la isla, y ya esta es la que considero para mandar
    datos.
3. ¿Qué riesgos tiene no cerrar un archivo después de usarlo? ¿Cómo los
   mitigaste?
    - De no cerrarlo, se puede crear el famoso "memory leak", o que por estar abierto, no se pueda abrir otro archivo
    en el caso de que halla varios. Para evitarlo, nada mas hay que usar try-with-resources, para que se cierre
    de forma automatica cuando finaliza un bloque de codigo que lo este usando.