package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Sistema de gestion de biblioteca - en construccion");
    }

    private static void crearCliente() {
        System.out.println("\n--- CREAR CLIENTE ---");
        String id = leerTexto("ID del cliente: ");
        if (existeCliente(id)) {
            System.out.println("Ya existe un cliente con el ID " + id + ".");
            return;
        }
        String nombre = leerTexto("Nombre: ");
        String telefono = leerTexto("Telefono: ");
        clientes.add(new Cliente(id, nombre, telefono));
        System.out.println("Cliente creado correctamente.");
    }

    private static boolean existeCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
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