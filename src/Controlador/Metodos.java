/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import modelo.Conexion;

/**
 *
 * @author Labing
 */
public class Metodos {

    public static Connection connection;
    public static PreparedStatement preparedStmt;

    public static void InsetarA(int id, String nombreA) {

        Conexion.Conexion();
        String query = " insert into artist (artist_id, artist_name)"
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

    public static void ActualizarA(int id, String nuevoNombre) {

        Conexion.Conexion();

        preparedStmt = null;

        try {

            String query = "update artist set artist_name = ? where artist_id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nuevoNombre);
            preparedStmt.setInt(2, id);

        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }

    public static void ListarA() {

        Conexion.Conexion();

        String query = "SELECT * FROM artist";

        try {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int codigoArtista = rs.getInt("artist_id");
                String Nombre = rs.getString("artist_name");

                System.out.format("%s, %s\n", codigoArtista, Nombre);
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

    public static void BorrarA(int id) {

        Conexion.Conexion();

        preparedStmt = null;

        try {
            String query = "delete from artist where artist_id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }

    public static void InsertarAL(int idA, int idAlb, String albName) {
        Conexion.Conexion();
        String query = " insert into album (artist_id, album_id, album_name)"
                + " values (?, ?, ?)";

        preparedStmt = null;
        
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, idA);
                preparedStmt.setInt(2, idAlb);
                preparedStmt.setString(3, albName);
                preparedStmt.execute();

                System.out.println("You made it, the insertion is ok!");

            } catch (SQLException e) {
                System.out.println("Failed to make insertion!");
                e.printStackTrace();
            }
    }

    public static void ActualizarAL(int idAl, String albumName) {
        Conexion.Conexion();
        preparedStmt = null;
        
        try {

            String query = "update album set album_name = ? where album_id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, albumName);
            preparedStmt.setInt(2, idAl);
            
        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }
    
    public static void ListarAL(){
        
        Conexion.Conexion();

        String query = "SELECT * FROM album";

        try {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int artista = rs.getInt("artist_id");
                int albumId = rs.getInt("album_id");
                String Nombre = rs.getString("album_name");

                System.out.format("%s, %s, %s\n", artista, albumId, Nombre);
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
    
    public static void BorrarAL(int idAl){
        Conexion.Conexion();

        preparedStmt = null;

        try {
            String query = "delete from album where album_id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, idAl);
            preparedStmt.execute();
        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }
    
    public static void InsertarT(int idT, String nameT, int artistaId, int albumId){
        
        Conexion.Conexion();
        String query = " insert into track (track_id, track_name, artist_id, album_id)"
                + " values (?, ?, ?, ?)";
        
        preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, idT);
            preparedStmt.setString(2, nameT);
            preparedStmt.setInt(3, artistaId);
            preparedStmt.setInt(4, albumId);
            preparedStmt.execute();
            

            System.out.println("You made it, the insertion is ok!");

        } catch (SQLException e) {
            System.out.println("Failed to make insertion!");
            e.printStackTrace();
        }
    }
    
    public static void ActualizarT(int id, String nombre){
        Conexion.Conexion();

        preparedStmt = null;

        try {

            String query = "update track set track_name = ? where track_id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nombre);
            preparedStmt.setInt(2, id);

        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }
    
    public static void ListarT(){
        Conexion.Conexion();

        String query = "SELECT * FROM track";
        
        try {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int trackId = rs.getInt("track_id");
                String trackName = rs.getString("track_name");
                int ArtistaID = rs.getInt("artist_id");
                int album_id = rs.getInt("album_id");
                
                

                System.out.format("%s, %s, %s, %s\n", trackId, trackName, ArtistaID, album_id);
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
    
    public static void BorrarT(int idT){
        Conexion.Conexion();

        preparedStmt = null;

        try {
            String query = "delete from track where track_id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, idT);
            preparedStmt.execute();
        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
    }
}
