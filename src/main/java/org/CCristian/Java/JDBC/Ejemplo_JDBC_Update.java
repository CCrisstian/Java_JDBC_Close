package org.CCristian.Java.JDBC;

import org.CCristian.Java.JDBC.Models.Categoria;
import org.CCristian.Java.JDBC.Models.Producto;
import org.CCristian.Java.JDBC.Repositorio.ProductoRepositorio_Implementacion;
import org.CCristian.Java.JDBC.Repositorio.Repositorio;

public class Ejemplo_JDBC_Update {
    public static void main(String[] args) {

        Repositorio<Producto> repositorio = new ProductoRepositorio_Implementacion();
        System.out.println("Listando");
        repositorio.listar().forEach(System.out::println);

        System.out.println("\nBuscando por 'id'");
        System.out.println(repositorio.buscarPorId(1L).toString());

        System.out.println("\nModificar producto");
        Producto producto = new Producto();
        producto.setId(4L);
        producto.setNombre("Teclado Corsair k95 mecánico");
        producto.setPrecio(700);
        Categoria categoria = new Categoria();
        categoria.setId(2L);
        producto.setCategoria(categoria);
        repositorio.guardar(producto);
        System.out.println("Update");
        repositorio.listar().forEach(System.out::println);

    }
}
