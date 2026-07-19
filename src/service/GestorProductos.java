package service;

import model.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class GestorProductos {
    private HashMap<Integer, Producto> productos;

    public GestorProductos() {
        this.productos = new HashMap<>();
    }



    public void agregarProducto(Producto producto){

        productos.put(producto.getId(), producto);
    }

    public Producto buscarProducto(int id){

        return productos.get(id);
    }

    public boolean eliminarProducto(int id){
       if (productos.containsKey(id)){
           productos.remove(id);
           return true;
       }
        return false;
    }

    public void listarProductos(){
        for(Producto producto: productos.values()){
            producto.mostrarInfo();
        }
    }

    public boolean estaVacio(){
        return productos.isEmpty();
    }



    public void buscarPorCategoria(String categoria){
        boolean encontrado = false;
        for(Producto producto: productos.values()){
            if(producto.getCategoria().equals(categoria)) {
                producto.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos de esa categoría.");
        }
    }

    public void mostrarBajoStock(int limite){
        boolean encontrado = false;
        for (Producto producto : productos.values()){
            if(producto.getCantidad() <= limite){
                producto.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos de menor o igual stock.");
        }
    }

    public void ordenarPorNombre(){
        ArrayList<Producto> lista = new ArrayList<>(productos.values());
            Collections.sort(lista, Comparator.comparing(Producto :: getNombre));
            for(Producto productoArray : lista){
                productoArray.mostrarInfo();
            }
    }

    public void ordenarPorPrecio(){
        ArrayList<Producto> lista = new ArrayList<>(productos.values());
        Collections.sort(lista, Comparator.comparing(Producto :: getPrecio));
        for (Producto productoLista : lista){
            productoLista.mostrarInfo();
        }
    }

}