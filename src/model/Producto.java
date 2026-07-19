package model;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;

    private static int contador = 0;

    public Producto(String nombre, double precio, int cantidad, String categoria) {
        this.id = ++contador;
        setNombre(nombre);
        setPrecio(precio);
        setCantidad(cantidad);
        setCategoria(categoria);
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            System.out.println("El nombre no puede estar vacio");
            return;
        }

        nombre = nombre.trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio");
            return;
        }

        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            System.out.println("El precio no puede ser negativo");
            return;
        }
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            System.out.println("La cantidad no puede ser negativa");
            return;
        }
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria) {
        if (categoria == null) {
            System.out.println("La categoria no puede estar vacia");
            return;
        }

        categoria = categoria.trim();

        if (categoria.isEmpty()) {
            System.out.println("La categoria no puede estar vacia");
            return;
        }

        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void mostrarInfo() {
        System.out.println(
                "\n==============================" +
                        "\nPRODUCTO" +
                        "\n==============================" +
                        "\nID: " + getId() +
                        "\nNombre: " + getNombre() +
                        "\nPrecio: $" + getPrecio() +
                        "\nCantidad del producto: " + getCantidad() +
                        "\nCategoría: " + getCategoria() +
                        "\n=============================="
        );
    }

}