package app;

import model.Producto;
import service.GestorProductos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProductos gestor = new GestorProductos();

        int opcion;

        do {
            System.out.println("\n===== Inventory Management System =====\n" +
                    "\n" +
                    "1. Agregar producto\n" +
                    "2. Buscar producto\n" +
                    "3. Eliminar producto\n" +
                    "4. Listar productos\n" +
                    "5. Actualizar producto\n" +
                    "6. Buscar productos por categoría\n" +
                    "7. Mostrar productos con bajo stock\n" +
                    "8. Ordenar productos por nombre\n" +
                    "9. Ordenar productos por precio\n" +
                    "10. Salir\n" +
                    "\n" +
                    "elija una opcion numerica por favor: \n"
            );
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(gestor, scanner);
                    break;
                case 2:
                    buscarProducto(gestor, scanner);
                    break;
                case 3:
                    eliminarProducto(gestor, scanner);
                    break;
                case 4:
                    listarProductos(gestor);
                    break;
                case 5:
                    actualizarProducto(gestor, scanner);
                    break;
                case 6:
                    buscarPorCategoria(gestor, scanner);
                    break;
                case 7:
                    mostrarStockBajo(gestor, scanner);
                    break;
                case 8:
                    ordenarPorNombre(gestor);
                    break;
                case 9:
                    ordenarPorPrecio(gestor);
                    break;
                case 10:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Error, intente de nuevo");
                    break;
            }
        } while (opcion != 10);
    }


    public static void agregarProducto(GestorProductos gestor, Scanner scanner) {
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad en stock del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la categoria del producto: ");
        String categoria = scanner.nextLine();

        Producto producto = new Producto(nombre, precio, cantidad, categoria);
        gestor.agregarProducto(producto);
        System.out.println("Producto agregado correctamente");
    }

    public static void buscarProducto(GestorProductos gestor, Scanner scanner) {
        System.out.println("Ingrese el id del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Producto producto = gestor.buscarProducto(id);

        if (producto != null) {
            producto.mostrarInfo();
        } else {
            System.out.println("No existe el producto");
        }
    }

    public static void eliminarProducto(GestorProductos gestor, Scanner scanner) {
        System.out.println("Ingrese el id del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean eliminado = gestor.eliminarProducto(id);
        if (eliminado) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("ID no encontrado.");
        }
    }

    public static void listarProductos(GestorProductos gestor) {
        if (gestor.estaVacio()) {
            System.out.println("Lista vacía.");
            return;
        }

        gestor.listarProductos();
    }

    public static void actualizarProducto(GestorProductos gestor, Scanner scanner) {
        System.out.println("Ingrese el id del producto: ");
        int productoBuscado = scanner.nextInt();
        scanner.nextLine();
        Producto producto = gestor.buscarProducto(productoBuscado);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        int opcion;
        do {
            System.out.println("\nIngrese una opcion: \n" +
                    "\n1. Cambiar nombre\n " +
                    "\n2. Cambiar precio\n " +
                    "\n3. Cambiar cantidad\n " +
                    "\n4. Cambiar categoria\n " +
                    "\n5. Salir ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cambiarNombre(producto, scanner);
                    break;
                case 2:
                    cambiarPrecio(producto, scanner);
                    break;
                case 3:
                    cambiarCantidad(producto, scanner);
                    break;
                case 4:
                    cambiarCategoria(producto, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo de la opcion de cambio");
                    break;
                default:
                    System.out.println("Error, intente de nuevo");
                    break;
            }
        } while (opcion != 5);
    }

            public static void cambiarNombre(Producto producto, Scanner scanner) {
                System.out.println("Ingrese el nuevo nombre:");
                String nombre = scanner.nextLine();

                producto.setNombre(nombre);
                System.out.println("Nombre actualizado correctamente.");
            }

            public static void cambiarPrecio(Producto producto, Scanner scanner) {
                System.out.println("Ingrese el nuevo precio:");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                producto.setPrecio(precio);
                System.out.println("Precio actualizado correctamente.");
            }

            public static void cambiarCantidad(Producto producto, Scanner scanner) {
                System.out.println("Ingrese la nueva cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                producto.setCantidad(cantidad);
                System.out.println("Cantidad actualizada correctamente.");
            }

            public static void cambiarCategoria(Producto producto, Scanner scanner) {
                System.out.println("Ingrese la nueva categoria: ");
                String categoria = scanner.nextLine();

                producto.setCategoria(categoria);
                System.out.println("Categoria actualizada correctamente.");
            }

    public static void buscarPorCategoria(GestorProductos gestor, Scanner scanner) {
        System.out.println("Ingrese la categoria a buscar");
        String categoriaBuscada = scanner.nextLine();
        gestor.buscarPorCategoria(categoriaBuscada);
    }

    public static void mostrarStockBajo(GestorProductos gestor, Scanner scanner) {
        System.out.println("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        gestor.mostrarBajoStock(cantidad);
    }

    public static void ordenarPorNombre(GestorProductos gestor) {
        gestor.ordenarPorNombre();
    }

    public static void ordenarPorPrecio(GestorProductos gestor) {
        gestor.ordenarPorPrecio();
    }

}