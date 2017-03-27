/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;
import modelo.Conexion;

/**
 *
 * @author Labing
 */
public class Metodos {

    public static Connection connection;
    public static PreparedStatement preparedStmt;
    public static String nombreA;
    public static int id;
    
    public static void Insetar(String tipo) {
        
        if (tipo.equalsIgnoreCase("Artista")) {
            
            String query = " insert into Productos (artist_id, artist_name)"
                    + " values (?, ?)";

            preparedStmt = null;

            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, nombreA);
                preparedStmt.execute();

                System.out.println("You made it, the insertion is ok!");

            } catch (SQLException e) {
                System.out.println("Failed to make insertion!");
                e.printStackTrace();
            }
        }

    }

    public static void Actualizar() {

        Scanner lec2 = new Scanner(System.in);
        System.out.println("Escriba el codigo el producto");
        int CodigoDelProducto = lec2.nextInt();
        System.out.println("Escriba el nuevo precio");
        int precioNuevo = lec2.nextInt();

        preparedStmt = null;

        try {

            String query = "update Productos set Precio = ? where CodProducto = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, precioNuevo);
            preparedStmt.setInt(2, CodigoDelProducto);

            int r = preparedStmt.executeUpdate();
            System.out.println(r);
        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }

    public static void Listar() {

        String query = "SELECT * FROM Productos";

        try {
            // create the java statement
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int codigoProducto = rs.getInt("CodProducto");
                int precio = rs.getInt("Precio");
                String Proveedor = rs.getString("Proveedor");
                String ciudad = rs.getString("ciudad");

                System.out.format("%s, %s, %s, %s\n", codigoProducto, precio, Proveedor, ciudad);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Borrar() {

        Scanner lec3 = new Scanner(System.in);
        System.out.println("Escriba el codigo del producto que desea borrar");
        int Codigo = lec3.nextInt();

        preparedStmt = null;

        try {
            String query = "delete from Productos where CodProducto = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, Codigo);
            preparedStmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }
}
