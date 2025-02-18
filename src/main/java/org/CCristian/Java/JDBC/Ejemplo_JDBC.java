package org.CCristian.Java.JDBC;

import org.CCristian.Java.JDBC.Models.Categoria;
import org.CCristian.Java.JDBC.Models.Producto;
import org.CCristian.Java.JDBC.Repositorio.ProductoRepositorio_Implementacion;
import org.CCristian.Java.JDBC.Repositorio.Repositorio;

import java.util.Date;

public class Ejemplo_JDBC {
    public static void main(String[] args) {

        Repositorio<Producto> repositorio = new ProductoRepositorio_Implementacion();
        System.out.println("Listando");
        repositorio.listar().forEach(System.out::println);

        System.out.println("\nBuscando por 'id'");
        System.out.println(repositorio.buscarPorId(1L).toString());

        System.out.println("\nInsertar nuevo producto");
        Producto producto = new Producto();
        producto.setNombre("Notebook Asus ROG");
        producto.setPrecio(2550);
        producto.setFecha_registro(new Date());
        Categoria categoria = new Categoria();
        categoria.setId(3L);
        producto.setCategoria(categoria);
        repositorio.guardar(producto);
        System.out.println("Guardado");
        repositorio.listar().forEach(System.out::println);
    }
}
