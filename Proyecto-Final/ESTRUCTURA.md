# GymPOS — Estructura del Proyecto

## Arquitectura MVC

```
GymPOS/
└── src/
    ├── app/
    │   └── MainApp.java                  ← Punto de entrada JavaFX (Application)
    │
    ├── model/                            ← MODELO: clases de dominio (Serializable)
    │   ├── Cliente.java
    │   ├── Membresia.java
    │   ├── Pago.java
    │   ├── Equipo.java
    │   ├── ClaseGrupal.java
    │   ├── RegistroAcceso.java
    │   └── Usuario.java
    │
    ├── controller/                       ← CONTROLADOR: lógica de negocio y CRUD
    │   ├── ClienteController.java
    │   ├── MembresiaController.java
    │   └── PagoController.java
    │   (Agrega: EquipoController, AccesoController, ClaseController según necesites)
    │
    ├── view/                             ← VISTA: controladores de FXML
    │   ├── LoginViewController.java
    │   └── ClienteViewController.java
    │   (Agrega un *ViewController.java por cada pantalla FXML)
    │
    ├── service/                          ← SERVICIOS: tareas técnicas transversales
    │   ├── PersistenciaService.java      ← Serialización (ObjectInputStream/OutputStream)
    │   ├── ReporteService.java           ← Generación de reportes en Thread separado
    │   └── NotificacionService.java      ← Monitor de vencimientos (Thread daemon)
    │
    └── exception/                        ← EXCEPCIONES personalizadas
        ├── GymPOSException.java          ← Excepción base
        ├── ClienteException.java
        ├── MembresiaException.java
        ├── PagoException.java
        └── PersistenciaException.java

resources/
└── view/
    ├── LoginView.fxml                    ← TODO: crear con SceneBuilder
    ├── MainView.fxml                     ← TODO: pantalla principal con TabPane
    ├── ClienteView.fxml                  ← TODO: tabla + formulario de clientes
    └── ...                              ← una .fxml por módulo
```

---

## Conteo de Clases (mínimo 15 requerido)

| #  | Clase                 | Package    |
|----|-----------------------|------------|
| 1  | MainApp               | app        |
| 2  | Cliente               | model      |
| 3  | Membresia             | model      |
| 4  | Pago                  | model      |
| 5  | Equipo                | model      |
| 6  | ClaseGrupal           | model      |
| 7  | RegistroAcceso        | model      |
| 8  | Usuario               | model      |
| 9  | ClienteController     | controller |
| 10 | MembresiaController   | controller |
| 11 | PagoController        | controller |
| 12 | LoginViewController   | view       |
| 13 | ClienteViewController | view       |
| 14 | PersistenciaService   | service    |
| 15 | ReporteService        | service    |
| 16 | NotificacionService   | service    |
| 17 | GymPOSException       | exception  |
| 18 | ClienteException      | exception  |
| 19 | MembresiaException    | exception  |
| 20 | PagoException         | exception  |
| 21 | PersistenciaException | exception  |

**Total: 21 clases** ✓

---

## Requisitos técnicos y dónde están

| Requisito                  | Dónde implementarlo                                    |
|----------------------------|--------------------------------------------------------|
| Patrón MVC                 | Packages `model`, `controller`, `view`                 |
| Serialización              | `PersistenciaService` — ObjectInputStream/OutputStream |
| Multithreading             | `ReporteService` y `NotificacionService`               |
| Excepciones personalizadas | Package `exception`, usadas en todos los controllers   |
| Interfaz JavaFX            | Archivos `.fxml` + `*ViewController.java`              |

---

## Notas de Implementación

- **Persistencia**: Cada controller llama a `PersistenciaService.guardar/cargar` con un
  archivo `.dat` separado por entidad (`clientes.dat`, `membresias.dat`, etc.).

- **Threads**: Los reportes y el monitor de notificaciones corren en Threads separados.
  Para actualizar la UI desde un Thread usa siempre `Platform.runLater(() -> { ... })`.

- **FXML**: Crea una vista `.fxml` por módulo usando SceneBuilder. El `fx:id` de cada
  control debe coincidir exactamente con el nombre del campo `@FXML` en el ViewController.

- **Datos de prueba**: Crea una clase `DataSeeder` o método `generarDatosPrueba()` en
  `MainApp` que inserte 20+ registros si la carpeta `data/` está vacía.
