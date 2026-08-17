package com.mycompany.biblioteca;

public class Cliente extends Persona {

    private String id;

    public Cliente() {
    }

    public Cliente(String id, String nombre, String telefono) {
        super(nombre, telefono);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + getNombre() + ", telefono=" + getTelefono() + "]";
    }
}