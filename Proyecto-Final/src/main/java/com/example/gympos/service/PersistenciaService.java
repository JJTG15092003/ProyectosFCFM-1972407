package com.example.gympos.service;

import com.example.gympos.exception.PersistenciaException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

//Persistencia usando la serializacion de Java
//Todos los datos se guardan en la carpeta "data"
public class PersistenciaService
{

    private static final String CARPETA_DATOS = "data/";

    public PersistenciaService()
    {
        crearCarpetaDatos();
    }

    //Crea la carpeta "data" en caso de que no exista
    private void crearCarpetaDatos()
    {
        try
        {
            Files.createDirectories(Paths.get(CARPETA_DATOS));
        } catch (IOException e)
        {
            System.err.println("No se pudo crear la carpeta de datos: " + e.getMessage());
        }
    }

    //Serializa y guarda un objeto en un archivo .dat
    public void guardar(String nombreArchivo, Object objeto) throws PersistenciaException
    {
        String ruta = CARPETA_DATOS + nombreArchivo;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta)))
        {
            oos.writeObject(objeto);
        } catch (IOException e)
        {
            throw new PersistenciaException("Error al guardar " + nombreArchivo + ": " + e.getMessage());
        }
    }

    //Deserializa y carga un objeto desde un archivo .dat
    public Object cargar(String nombreArchivo) throws PersistenciaException
    {
        String ruta = CARPETA_DATOS + nombreArchivo;
        if (!Files.exists(Paths.get(ruta)))
        {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta)))
        {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e)
        {
            throw new PersistenciaException("Error al cargar " + nombreArchivo + ": " + e.getMessage());
        }
    }

    //Exporta texto plano a un archivo .txt (para reportes)
    public void exportarTexto(String nombreArchivo, String contenido) throws PersistenciaException
    {
        String ruta = CARPETA_DATOS + nombreArchivo;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta)))
        {
            writer.write(contenido);
        } catch (IOException e)
        {
            throw new PersistenciaException("Error al exportar " + nombreArchivo + ": " + e.getMessage());
        }
    }

    //Elimina un archivo de datos
    public boolean eliminarArchivo(String nombreArchivo)
    {
        try
        {
            return Files.deleteIfExists(Paths.get(CARPETA_DATOS + nombreArchivo));
        } catch (IOException e)
        {
            return false;
        }
    }
}
