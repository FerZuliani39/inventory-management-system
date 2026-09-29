package app;

import model.Producto;
import database.Conexion;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n===== Inventory Management System =====\n" +
                    "\n" +
                    "1. Agregar producto\n" +
                    "2. Buscar producto\n" +
                    "3. Eliminar producto\n" +
                    "4. Listar productos\n" +
                    "5. Actualizar producto\n" +
                   /* "7. Buscar productos por categoría\n" +
                    "8. Mostrar productos con bajo stock\n" +
                    "9. Ordenar productos por nombre\n" +
                    "10. Ordenar productos por precio\n" +*/
                    "6. Salir\n" +
                    "\n" +
                    "elija una opcion numerica por favor: \n"
            );
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    buscarProducto(scanner);
                    break;
                case 3:
                     eliminarProducto(scanner);
                    break;
                case 4:
                    listarProductos();
                    break;
                case 5:
                    actualizarProducto(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    break;
                case 7:
                    // mostrarStockBajo(scanner);
                    break;
                case 8:
                    //ordenarPorNombre();
                    break;
                case 9:
                    //ordenarPorPrecio();
                    break;
                case 10:
                    // buscarPorCategoria(scanner);
                    break;
                default:
                    System.out.println("Error, intente de nuevo");
                    break;
            }
        } while (opcion != 6);
    }

    public static void agregarProducto( Scanner scanner) {
        String sql = "INSERT INTO productos (nombre, precio, cantidad, categoria) VALUES (?, ?, ?, ?)";
        try(
                Connection connection = Conexion.conectar();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            statement.setString(1, nombre);

            System.out.println("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();
            statement.setDouble(2, precio);
            scanner.nextLine();

            System.out.println("Ingrese la cantidad en stock del producto: ");
            int cantidad = scanner.nextInt();
            statement.setInt(3, cantidad);
            scanner.nextLine();

            System.out.println("Ingrese la categoria del producto: ");
            String categoria = scanner.nextLine();
            statement.setString(4, categoria);

            int filasAfectadas= statement.executeUpdate();

            System.out.println("Producto agregado correctamente.. filas afectadas: " + filasAfectadas);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void buscarProducto(Scanner scanner) {
        String sql = "SELECT * FROM productos WHERE id = ?";

            try (
                        Connection connection = Conexion.conectar();
                        PreparedStatement statement = connection.prepareStatement(sql);
                ){
                    System.out.println("Ingrese el id del producto: ");
                    int productoBuscado = scanner.nextInt();
                    statement.setInt(1, productoBuscado);
                    ResultSet result =  statement.executeQuery();

                    if(result.next()){
                        int id= result.getInt("id");
                        String nombre = result.getString("nombre");
                        Double precio = result.getDouble("precio");
                        int cantidad = result.getInt("cantidad");
                        String categoria = result.getString("categoria");

                        System.out.println(id + "-" +
                                nombre + "-$" +
                                precio + "- Stock: " +
                                cantidad + "-" +
                                categoria);

                    }else {
                        System.out.println("No se encontro el id del producto");
                    }
                }catch(SQLException e){
                e.printStackTrace();
                }

    }

    public static void eliminarProducto(Scanner scanner) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (
                Connection connection = Conexion.conectar();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            System.out.println("Ingrese el id del producto: ");
            int id = scanner.nextInt();
            statement.setInt(1,id);
            int filasAfectadas =  statement.executeUpdate();

            System.out.println("Filas afectadas: " + filasAfectadas);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void listarProductos() {
    String sql = "SELECT * FROM productos";

        try(
                Connection connection = Conexion.conectar();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet result = statement.executeQuery()
        ){
            while(result.next()){
                int id= result.getInt("id");
                String nombre = result.getString("nombre");
                Double precio = result.getDouble("precio");
                int cantidad = result.getInt("cantidad");
                String categoria = result.getString("categoria");

                System.out.println(id + "-" +
                        nombre + "-$" +
                        precio + "- Stock: " +
                        cantidad + "-" +
                        categoria);

            }

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Lista vacía.");
        }

    }

    public static void actualizarProducto(Scanner scanner) {
        System.out.println("Ingrese el id del producto: ");
        int productoBuscado = scanner.nextInt();
        String sql = "SELECT * FROM productos WHERE id = ?";
        Producto producto = null;

        try (
                Connection connection = Conexion.conectar();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, productoBuscado);
            ResultSet result = statement.executeQuery();

            if(result.next()){

                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                double precio = result.getDouble("precio");
                int cantidad = result.getInt("cantidad");
                String categoria = result.getString("categoria");

                producto = new Producto(id, nombre,precio,cantidad,categoria);
            }
            else {
                System.out.println("Producto no encontrado.");
                return;
            }
            //       if (id== null) {System.out.println("Producto no encontrado.");return;}
        }catch(SQLException e){
            e.printStackTrace();
        }

        /// ////////////////////////////////////////menu de actualizacion///////////////////////
        int opcion;
        do {
            System.out.println("\nIngrese una opcion: \n" +
                    "\n1. Cambiar nombre\n " +
                    "\n2. Cambiar precio\n " +
                    // "\n3. Cambiar cantidad\n " +
                    // "\n4. Cambiar categoria\n " +
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
        String sql = "UPDATE productos SET nombre = ? WHERE id = ?;";

        try (
                Connection connection = Conexion.conectar();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            System.out.println("Ingrese el nuevo nombre:");
            String nombre = scanner.nextLine();

            statement.setString(1, nombre);
            statement.setInt(2, producto.getId());

            int filasAfectadas = statement.executeUpdate();

            // scanner.nextLine();
            //producto.setNombre(nombre);
            System.out.println("Producto actualizado correctamente.. filas afectadas: " + filasAfectadas);


        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void cambiarPrecio(Producto producto, Scanner scanner) {
        String sql = "UPDATE productos SET precio = ? WHERE id = ?;";
        try (
                Connection connection = Conexion.conectar();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            System.out.println("Ingrese el nuevo precio:");
            double precio = scanner.nextDouble();

            statement.setDouble(1, precio);
            statement.setInt(2, producto.getId());

            int filasAfectadas = statement.executeUpdate();

            // producto.setPrecio(precio);
            System.out.println("Precio actualizado correctamente.");

            System.out.println("Producto actualizado correctamente.. filas afectadas: " + filasAfectadas);


        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void cambiarCantidad(Producto producto, Scanner scanner) {
        String sql= "UPDATE productos SET cantidad = ? WHERE id = ?;";
        try(
                Connection connection = Conexion.conectar();
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            System.out.println("Ingrese la nueva cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            statement.setInt(1, cantidad);
            statement.setInt(2, producto.getId());
            int filasAfectadas = statement.executeUpdate();

            System.out.println("Cantidad actualizada correctamente.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void cambiarCategoria(Producto producto, Scanner scanner) {
        String sql= "UPDATE productos SET categoria = ? WHERE id = ?;";
        try(
                Connection connection= Conexion.conectar();
                PreparedStatement statement =connection.prepareStatement(sql);
        ){
            System.out.println("Ingrese la nueva categoria: ");
            String categoria = scanner.nextLine();

            statement.setString(1, categoria);
            statement.setInt(2, producto.getId());
            int filasAfectadas = statement.executeUpdate();
            System.out.println("Categoria actualizada correctamente.");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    /*public static void buscarPorCategoria(Scanner scanner) {
       System.out.println("Ingrese la categoria a buscar");
        String categoriaBuscada = scanner.nextLine();
       gestor.buscarPorCategoria(categoriaBuscada);
    }*/

    /*public static void mostrarStockBajo(Scanner scanner) {
       System.out.println("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        gestor.mostrarBajoStock(cantidad);
    }*/

    /*public static void ordenarPorNombre(GestorProductos gestor) {
        gestor.ordenarPorNombre();
    }*/

    /*public static void ordenarPorPrecio(GestorProductos gestor) {
        gestor.ordenarPorPrecio();
    }*/
}
