package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion(1, 4);
            switch (opcion) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuLibros();
                    break;
                case 3:
                    menuPrestamos();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4 && opcion != -1);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
        System.out.println("1. Gestión de clientes");
        System.out.println("2. Gestión de libros");
        System.out.println("3. Gestión de préstamos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(1, 6);
            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarClienteInteractivo();
                    break;
                case 4:
                    actualizarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void menuLibros() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Crear libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(1, 6);
            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    buscarLibroInteractivo();
                    break;
                case 4:
                    actualizarLibro();
                    break;
                case 5:
                    eliminarLibro();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void menuPrestamos() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Registrar devolución");
            System.out.println("3. Listar préstamos activos");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(1, 4);
            switch (opcion) {
                case 1:
                    crearPrestamo();
                    break;
                case 2:
                    devolucion();
                    break;
                case 3:
                    listarPrestamos();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);
    }

    private static int leerOpcion(int minimo, int maximo) {
        int opcion = -1;
        boolean valida = false;
        while (!valida) {
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= minimo && opcion <= maximo) {
                    valida = true;
                } else {
                    System.out.print("Opción inválida. Intente de nuevo: ");
                }
            } else if (scanner.hasNext()) {
                System.out.print("Entrada inválida. Ingrese un número: ");
                scanner.next();
            } else {
                return -1;
            }
        }
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        return opcion;
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String texto = scanner.nextLine().trim();
        while (texto.isEmpty()) {
            System.out.print("El valor no puede estar vacío. " + mensaje);
            texto = scanner.nextLine().trim();
        }
        return texto;
    }

    private static void crearCliente() {
        System.out.println("\n--- CREAR CLIENTE ---");
        String id = leerTexto("ID del cliente: ");
        if (buscarCliente(id) != null) {
            System.out.println("Ya existe un cliente con el ID " + id + ".");
            return;
        }
        String nombre = leerTexto("Nombre: ");
        String telefono = leerTexto("Teléfono: ");
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
            System.out.println("No se encontró un cliente con ID " + id + ".");
        } else {
            System.out.println("Cliente encontrado: " + cliente);
        }
    }

    private static void actualizarCliente() {
        System.out.println("\n--- ACTUALIZAR CLIENTE ---");
        String id = leerTexto("ID del cliente a actualizar: ");
        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("No se encontró un cliente con ID " + id + ".");
            return;
        }
        String nombre = leerTexto("Nuevo nombre (actual: " + cliente.getNombre() + "): ");
        String telefono = leerTexto("Nuevo teléfono (actual: " + cliente.getTelefono() + "): ");
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        System.out.println("Cliente actualizado correctamente.");
    }

    private static void eliminarCliente() {
        System.out.println("\n--- ELIMINAR CLIENTE ---");
        String id = leerTexto("ID del cliente a eliminar: ");
        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("No se encontró un cliente con ID " + id + ".");
            return;
        }
        clientes.remove(cliente);
        System.out.println("Cliente eliminado correctamente.");
    }

    private static void crearLibro() {
        System.out.println("\n--- CREAR LIBRO ---");
        String codigo = leerTexto("Código del libro: ");
        if (buscarLibro(codigo) != null) {
            System.out.println("Ya existe un libro con el código " + codigo + ".");
            return;
        }
        String titulo = leerTexto("Título: ");
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

    private static void buscarLibroInteractivo() {
        System.out.println("\n--- BUSCAR LIBRO ---");
        String codigo = leerTexto("Código del libro a buscar: ");
        Libro libro = buscarLibro(codigo);
        if (libro == null) {
            System.out.println("No se encontró un libro con código " + codigo + ".");
        } else {
            System.out.println("Libro encontrado: " + libro);
        }
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
        String codigo = leerTexto("Código del libro a actualizar: ");
        Libro libro = buscarLibro(codigo);
        if (libro == null) {
            System.out.println("No se encontró un libro con código " + codigo + ".");
            return;
        }
        String titulo = leerTexto("Nuevo título (actual: " + libro.getTitulo() + "): ");
        String autor = leerTexto("Nuevo autor (actual: " + libro.getAutor() + "): ");
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        System.out.println("Libro actualizado correctamente.");
    }

    private static void eliminarLibro() {
        System.out.println("\n--- ELIMINAR LIBRO ---");
        String codigo = leerTexto("Código del libro a eliminar: ");
        Libro libro = buscarLibro(codigo);
        if (libro == null) {
            System.out.println("No se encontró un libro con código " + codigo + ".");
            return;
        }
        libros.remove(libro);
        System.out.println("Libro eliminado correctamente.");
    }

    private static void crearPrestamo() {
        System.out.println("\n--- REGISTRAR PRÉSTAMO ---");
        String idCliente = leerTexto("ID del cliente: ");
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("No existe un cliente con ID " + idCliente + ". Préstamo no registrado.");
            return;
        }
        String codigoLibro = leerTexto("Código del libro: ");
        Libro libro = buscarLibro(codigoLibro);
        if (libro == null) {
            System.out.println("No existe un libro con código " + codigoLibro + ". Préstamo no registrado.");
            return;
        }
        if (libroEstaPrestado(libro)) {
            System.out.println("El libro con código " + codigoLibro + " ya está prestado.");
            return;
        }
        prestamos.add(new Prestamo(cliente, libro));
        System.out.println("Préstamo registrado correctamente.");
    }

    private static boolean libroEstaPrestado(Libro libro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getCodigo().equalsIgnoreCase(libro.getCodigo())
                    && prestamo.estaActivo()) {
                return true;
            }
        }
        return false;
    }

    private static void devolucion() {
        System.out.println("\n--- REGISTRAR DEVOLUCIÓN ---");
        String idCliente = leerTexto("ID del cliente: ");
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("No existe un cliente con ID " + idCliente + ".");
            return;
        }
        String codigoLibro = leerTexto("Código del libro: ");
        Libro libro = buscarLibro(codigoLibro);
        if (libro == null) {
            System.out.println("No existe un libro con código " + codigoLibro + ".");
            return;
        }
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCliente().getId().equalsIgnoreCase(idCliente)
                    && prestamo.getLibro().getCodigo().equalsIgnoreCase(codigoLibro)
                    && prestamo.estaActivo()) {
                prestamo.registrarDevolucion();
                System.out.println("Devolución registrada correctamente.");
                return;
            }
        }
        System.out.println("No existe un préstamo activo para ese cliente y libro.");
    }

    private static void listarPrestamos() {
        System.out.println("\n--- PRÉSTAMOS ACTIVOS ---");
        boolean hayActivos = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaActivo()) {
                System.out.println("- Cliente: " + prestamo.getCliente().getNombre()
                        + " | Libro: " + prestamo.getLibro().getTitulo()
                        + " | Fecha préstamo: " + prestamo.getFechaPrestamo());
                hayActivos = true;
            }
        }
        if (!hayActivos) {
            System.out.println("No hay préstamos activos.");
        }
    }
}