package com.example.gympos.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//Usuario del sistema (Osea los duenos del gym)
public class Usuario implements Serializable
{

    private static final long serialVersionUID = 1L;

    public enum Rol
    {ADMINISTRADOR, RECEPCIONISTA, INSTRUCTOR}

    private int id;
    private String username;
    private String passwordHash;
    private String nombreCompleto;
    private Rol rol;
    private boolean activo;

    public Usuario()
    {
    }

    public Usuario(int id, String username, String password, String nombreCompleto, Rol rol)
    {
        this.id = id;
        this.username = username;
        this.passwordHash = hashPassword(password);
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.activo = true;
    }

    //Generar el hash de la contrasena
    private String hashPassword(String password)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes)
            {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e)
        {
            return String.valueOf(password.hashCode());
        }
    }

    //Verificar contrasena
    public boolean verificarPassword(String password)
    {
        return this.passwordHash.equals(hashPassword(password));
    }

    //Cambiar contrasena
    public void cambiarPassword(String nuevaPassword)
    {
        if (nuevaPassword != null && !nuevaPassword.isEmpty())
        {
            this.passwordHash = hashPassword(nuevaPassword);
        }
    }

    //Mis getters y setters

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getNombreCompleto()
    {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombre)
    {
        this.nombreCompleto = nombre;
    }

    public Rol getRol()
    {
        return rol;
    }

    public void setRol(Rol rol)
    {
        this.rol = rol;
    }

    public boolean isActivo()
    {
        return activo;
    }

    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }
}
