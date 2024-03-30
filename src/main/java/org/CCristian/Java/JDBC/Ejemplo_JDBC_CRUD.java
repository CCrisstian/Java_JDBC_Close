package org.CCristian.Java.JDBC;

import org.CCristian.Java.JDBC.Models.Categoria;
import org.CCristian.Java.JDBC.Models.Producto;
import org.CCristian.Java.JDBC.Repositorio.ProductoRepositorio_Implementacion;
import org.CCristian.Java.JDBC.Repositorio.Repositorio;
import org.CCristian.Java.JDBC.Util.Conexion_BaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Ejemplo_JDBC_CRUD {
    public static void main(String[] args) {

        try (Connection connection = Conexion_BaseDeDatos.getInstance())
        {
            System.out.println("------------------------CRUD------------------------");
            Repositorio<Producto> repositorio = new ProductoRepositorio_Implementacion();
            System.out.println("\t\tBase de Datos");
            repositorio.listar().forEach(System.out::println);

            Producto producto = new Producto();
            producto.setNombre("productoCRUD");
            producto.setPrecio(11001);
            producto.setFecha_registro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            System.out.println("\n\t\t\tCreate");
            repositorio.guardar(producto);
            repositorio.listar().forEach(System.out::println);

            System.out.println("\n\t\t\tRead");
            repositorio.listar().forEach(System.out::println);

            producto.setId(5L);
            producto.setNombre("producto_CRUD");
            producto.setPrecio(10011);
            repositorio.guardar(producto);
            System.out.println("\n\t\t\tUpdate");
            repositorio.listar().forEach(System.out::println);

            repositorio.eliminar(5L);
            System.out.println("\n\t\t\tDelete");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
