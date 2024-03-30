package org.CCristian.Java.JDBC;

import org.CCristian.Java.JDBC.Models.Producto;
import org.CCristian.Java.JDBC.Repositorio.ProductoRepositorio_Implementacion;
import org.CCristian.Java.JDBC.Repositorio.Repositorio;
import org.CCristian.Java.JDBC.Util.Conexion_BaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class Ejemplo_JDBC_Delete {
    public static void main(String[] args) {

        try (Connection connection = Conexion_BaseDeDatos.getInstance())
        {
            Repositorio<Producto> repositorio = new ProductoRepositorio_Implementacion();
            System.out.println("Listando");
            repositorio.listar().forEach(System.out::println);

            System.out.println("\nBuscando por 'id'");
            System.out.println(repositorio.buscarPorId(1L).toString());

            System.out.println("\nEliminado producto");
            repositorio.eliminar(3L);
            System.out.println("Delete");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
