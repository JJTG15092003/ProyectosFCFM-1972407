package com.example.gympos.controller;

import com.example.gympos.exception.PersistenciaException;
import com.example.gympos.model.Usuario;
import com.example.gympos.model.Usuario.Rol;
import com.example.gympos.service.PersistenciaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Controlador de usuarios del sistema
public class controladorUsuario
{

    private List<Usuario> usuarios;
    private PersistenciaService persistencia;
    private int nextId;
    private Usuario usuarioActual;

    public controladorUsuario()
    {
        this.persistencia = new PersistenciaService();
        this.usuarios = new ArrayList<>();
        this.nextId = 1;
        cargarDatos();
        crearAdminPorDefecto();
    }

    //Autenticar usuario con username y contrasena
    public boolean autenticar(String username, String password)
    {
        Optional<Usuario> usuario = usuarios.stream()
                .filter(u -> u.getUsername().equals(username) && u.isActivo())
                .findFirst();

        if (usuario.isPresent() && usuario.get().verificarPassword(password))
        {
            usuarioActual = usuario.get();
            return true;
        }
        return false;
    }

    //Cerrar sesion
    public void cerrarSesion()
    {
        usuarioActual = null;
    }

    //Obtener el usuario que inicio sesion
    public Usuario getUsuarioActual()
    {
        return usuarioActual;
    }

    //Registrar un nuevo usuario
    public Usuario registrarUsuario(String username, String password,
                                    String nombreCompleto, Rol rol)
    {
        Usuario nuevo = new Usuario(nextId++, username, password, nombreCompleto, rol);
        usuarios.add(nuevo);
        guardarDatos();
        return nuevo;
    }

    //Mostrar todos los usuarios
    public List<Usuario> obtenerTodos()
    {
        return new ArrayList<>(usuarios);
    }

    //Crea un admin por defecto si no hay ningun usuario guardado
    private void crearAdminPorDefecto()
    {
        if (usuarios.isEmpty())
        {
            Usuario admin = new Usuario(nextId++, "admin", "admin123",
                    "Administrador", Rol.ADMINISTRADOR);
            usuarios.add(admin);
            guardarDatos();
        }
    }

    //Cargar datos
    @SuppressWarnings("unchecked")
    private void cargarDatos()
    {
        try
        {
            Object obj = persistencia.cargar("usuarios.dat");
            if (obj != null)
            {
                usuarios = (List<Usuario>) obj;
                nextId = usuarios.stream()
                        .mapToInt(Usuario::getId)
                        .max()
                        .orElse(0) + 1;
            }
        } catch (PersistenciaException e)
        {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    //Guardar datos
    private void guardarDatos()
    {
        try
        {
            persistencia.guardar("usuarios.dat", usuarios);
        } catch (PersistenciaException e)
        {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }
}
