/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Controlador.Metodos.Actualizar;
import static Controlador.Metodos.Borrar;
import static Controlador.Metodos.Insetar;
import static Controlador.Metodos.Listar;
import Vistas.VistaPrincipal;
import java.util.Scanner;
import modelo.Conexion;

/**
 *
 * @author crist
 */
public class Principal {
    
    public static String tipo;
    
    public static void main(String[] args) {
        VistaPrincipal v = new VistaPrincipal();
        v.setVisible(true);
    }
}
