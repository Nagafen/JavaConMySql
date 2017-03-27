/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;
import static Controlador.Metodos.connection;

/**
 *
 * @author crist
 */
public class Conexion {
    
    public static void Conexion(){
        
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
            
            connection = null;
            
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "root");

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
    }
}
