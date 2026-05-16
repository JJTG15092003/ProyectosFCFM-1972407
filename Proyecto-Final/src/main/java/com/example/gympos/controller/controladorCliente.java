package com.example.gympos.controller;

import com.example.gympos.exception.ClienteException;
import com.example.gympos.exception.PersistenciaException;
import com.example.gympos.model.Cliente;
import com.example.gympos.service.PersistenciaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Controlador para la gestion de clientes (Osea el CRUD)
public class controladorCliente
{

    private List<Cliente> clientes;
    private PersistenciaService persistencia;
    private int siguienteId;

    public controladorCliente()
    {
        this.persistencia = new PersistenciaService();
        this.clientes = new ArrayList<>();
        this.siguienteId = 1;
        cargarDatos();
    }

    //Registra un nuevo cliente con validaciones
    public Cliente registrarCliente(String nombre, String apellido,
                                    String email, String telefono) throws ClienteException
    {
        if (nombre == null || nombre.isBlank())
        {
            throw new ClienteException("El nombre no puede estar vacio");
        }
        if (apellido == null || apellido.isBlank())
        {
            throw new ClienteException("El apellido no puede estar vacio");
        }
        if (email == null || email.isBlank())
        {
            throw new ClienteException("El email no puede estar vacio");
        }
        if (telefono == null || telefono.isBlank())
        {
            throw new ClienteException("El telefono no puede estar vacio");
        }

        boolean emailDuplicado = clientes.stream()
                .anyMatch(c -> c.getEmail().equalsIgnoreCase(email));
        if (emailDuplicado)
        {
            throw new ClienteException("Ya existe un cliente con ese email");
        }

        Cliente cliente = new Cliente(siguienteId++, nombre, apellido, email, telefono);
        clientes.add(cliente);
        guardarDatos();
        return cliente;
    }

    //Buscar al cliente por su ID
    public Optional<Cliente> buscarPorId(int id)
    {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    //Buscar al cliente por su nombre
    public List<Cliente> buscarPorNombre(String nombre)
    {
        String busqueda = nombre.toLowerCase();
        return clientes.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(busqueda)
                        || c.getApellido().toLowerCase().contains(busqueda))
                .collect(Collectors.toList());
    }

    //Actualizar datos del cliente
    public void actualizarCliente(Cliente cliente) throws ClienteException
    {
        if (cliente == null)
        {
            throw new ClienteException("El cliente no puede ser nulo");
        }
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++)
        {
            if (clientes.get(i).getId() == cliente.getId())
            {
                clientes.set(i, cliente);
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
        {
            throw new ClienteException("No se encontro el cliente con ID: " + cliente.getId());
        }
        guardarDatos();
    }

    //Eliminar al cliente en base a su ID
    public void eliminarCliente(int id) throws ClienteException
    {
        Optional<Cliente> cliente = buscarPorId(id);
        if (cliente.isEmpty())
        {
            throw new ClienteException("No se encontro el cliente con ID: " + id);
        }
        clientes.remove(cliente.get());
        guardarDatos();
    }

    //Mostrar clientes registrados
    public List<Cliente> obtenerTodos()
    {
        return new ArrayList<>(clientes);
    }

    //Cargar datos
    @SuppressWarnings("unchecked")
    private void cargarDatos()
    {
        try
        {
            Object obj = persistencia.cargar("clientes.dat");
            if (obj != null)
            {
                clientes = (List<Cliente>) obj;
                siguienteId = clientes.stream()
                        .mapToInt(Cliente::getId)
                        .max()
                        .orElse(0) + 1;
            }
        } catch (PersistenciaException e)
        {
            System.err.println("Error al cargar clientes: " + e.getMessage());
        }
    }

    //Guardar datos
    private void guardarDatos()
    {
        try
        {
            persistencia.guardar("clientes.dat", clientes);
        } catch (PersistenciaException e)
        {
            System.err.println("Error al guardar clientes: " + e.getMessage());
        }
    }
}
