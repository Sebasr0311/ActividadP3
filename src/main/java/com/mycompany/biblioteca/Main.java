package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Sistema de gestion de biblioteca - en construccion");
    }

    private static void crearCliente() {
        System.out.println("\n--- CREAR CLIENTE ---");
        String id = leerTexto("ID del cliente: ");
        if (buscarCliente(id) != null) {
            System.out.println("Ya existe un cliente con el ID " + id + ".");
            return;
        }
        String nombre = leerTexto("Nombre: ");
        String telefono = leerTexto("Telefono: ");
        clientes.add(new Cliente(id, nombre, telefono));
        System.out.println("Cliente creado correctamente.");
    }

    private static void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
    }

    private static Cliente buscarCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equalsIgnoreCase(id)) {
                return cliente;
            }
        }
        return null;
    }

    private static void buscarClienteInteractivo() {
        System.out.println("\n--- BUSCAR CLIENTE ---");
        String id = leerTexto("ID del cliente a buscar: ");
        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("No se encontro un cliente con ID " + id + ".");
        } else {
            System.out.println("Cliente encontrado: " + cliente);
        }
    }

    private static void actualizarCliente() {
        System.out.println("\n--- ACTUALIZAR CLIENTE ---");
        String id = leerTexto("ID del cliente a actualizar: ");
        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("No se encontro un cliente con ID " + id + ".");
            return;
        }
        String nombre = leerTexto("Nuevo nombre (actual: " + cliente.getNombre() + "): ");
        String telefono = leerTexto("Nuevo telefono (actual: " + cliente.getTelefono() + "): ");
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        System.out.println("Cliente actualizado correctamente.");
    }

    private static void eliminarCliente() {
        System.out.println("\n--- ELIMINAR CLIENTE ---");
        String id = leerTexto("ID del cliente a eliminar: ");
        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("No se encontro un cliente con ID " + id + ".");
            return;
        }
        clientes.remove(cliente);
        System.out.println("Cliente eliminado correctamente.");
    }

    private static void crearLibro() {
        System.out.println("\n--- CREAR LIBRO ---");
        String codigo = leerTexto("Codigo del libro: ");
        if (buscarLibro(codigo) != null) {
            System.out.println("Ya existe un libro con el codigo " + codigo + ".");
            return;
        }
        String titulo = leerTexto("Titulo: ");
        String autor = leerTexto("Autor: ");
        libros.add(new Libro(codigo, titulo, autor));
        System.out.println("Libro creado correctamente.");
    }

    private static Libro buscarLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                return libro;
            }
        }
        return null;
    }

    private static void listarLibros() {
        System.out.println("\n--- LISTA DE LIBROS ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i + 1) + ". " + libros.get(i));
        }
    }

    private static void actualizarLibro() {
        System.out.println("\n--- ACTUALIZAR LIBRO ---");
        String codigo = leerTexto("Codigo del libro a actualizar: ");
        Libro libro = buscarLibro(codigo);
        if (libro == null) {
            System.out.println("No se encontro un libro con codigo " + codigo + ".");
            return;
        }
        String titulo = leerTexto("Nuevo titulo (actual: " + libro.getTitulo() + "): ");
        String autor = leerTexto("Nuevo autor (actual: " + libro.getAutor() + "): ");
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        System.out.println("Libro actualizado correctamente.");
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String texto = scanner.nextLine().trim();
        while (texto.isEmpty()) {
            System.out.print("El valor no puede estar vacio. " + mensaje);
            texto = scanner.nextLine().trim();
        }
        return texto;
    }
}