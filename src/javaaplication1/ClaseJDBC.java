/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaaplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Labing
 */
public class ClaseJDBC {

    public static void main(String[] args) {

        while (true) {

            Scanner menu = new Scanner(System.in);
            System.out.println("Opcion 1 : INSERTAR");
            System.out.println("Opcion 2 : ACTUALIZAR");
            System.out.println("Opcion 3 : LISTAR TODO");
            System.out.println("Opcion 4 : BORRAR");
            System.out.println("Opcion 5 : FINALIZAR");
            int opcion = menu.nextInt();

            if (opcion == 1) {
                Insetar();
            }
            if (opcion == 2) {
                Actualizar();
            }
            if (opcion == 3) {
                Listar();
            }
            if (opcion == 4) {
                Borrar();
            }
            if (opcion == 5) {
                break;
            }
        }
    }

    public static void Insetar() {

        Scanner lec = new Scanner(System.in);
        System.out.println("Escriba el codigo del producto");
        int CodPro = lec.nextInt();
        System.out.println("Escriba el precio del producto");
        int PrecioPro = lec.nextInt();
        System.out.println("Escriba el proveedor del producto");
        String Proveedor = lec.next();
        System.out.println("Escriba la ciudad");
        String ciudad = lec.next();

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClaseJDBC", "root", "root");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        //Insertion 
        // create a sql date object so we can use it in our INSERT statement
//        Calendar calendar = Calendar.getInstance();
//        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        // the mysql insert statement
        String query = " insert into Productos (CodProducto, Precio, Proveedor, Ciudad)"
                + " values (?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, CodPro);
            preparedStmt.setInt(2, PrecioPro);
            preparedStmt.setString(3, Proveedor);
            preparedStmt.setString(4, ciudad);
            // execute the preparedstatement
            preparedStmt.execute();

            System.out.println("You made it, the insertion is ok!");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make insertion!");
            e.printStackTrace();
        }
    }

    public static void Actualizar() {

        Scanner lec2 = new Scanner(System.in);
        System.out.println("Escriba el codigo el producto");
        int CodigoDelProducto = lec2.nextInt();
        System.out.println("Escriba el nuevo precio");
        int precioNuevo = lec2.nextInt();
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClaseJDBC", "root", "root");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        PreparedStatement preparedStmt = null;

        try {
            //Update
            // create the java mysql update preparedstatement
            String query = "update Productos set Precio = ? where CodProducto = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, precioNuevo);
            preparedStmt.setInt(2, CodigoDelProducto);

            // execute the java preparedstatement
            int r = preparedStmt.executeUpdate();
            System.out.println(r);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }

    public static void Listar() {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClaseJDBC", "root", "root");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM Productos";

        try {
            // create the java statement
            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int codigoProducto = rs.getInt("CodProducto");
                int precio = rs.getInt("Precio");
                String Proveedor = rs.getString("Proveedor");
                String ciudad = rs.getString("ciudad");

                // print the results
                System.out.format("%s, %s, %s, %s\n", codigoProducto, precio, Proveedor, ciudad);
            }
            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void Borrar() {

        Scanner lec3 = new Scanner(System.in);
        System.out.println("Escriba el codigo del producto que desea borrar");
        int Codigo = lec3.nextInt();
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClaseJDBC", "root", "root");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        PreparedStatement preparedStmt = null;

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
