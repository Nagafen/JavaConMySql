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
import java.util.Scanner;
import modelo.Conexion;

/**
 *
 * @author crist
 */
public class Main {
    public static void main(String[] args) {
        
        while (true) {

            Conexion.Conexion();

            Scanner menu = new Scanner(System.in);
            System.out.println("Opcion 1 : INSERTAR");
            System.out.println("Opcion 2 : ACTUALIZAR");
            System.out.println("Opcion 3 : LISTAR TODO");
            System.out.println("Opcion 4 : BORRAR");
            System.out.println("Opcion 5 : FINALIZAR");
            int opcion = menu.nextInt();

            if (opcion == 1) {
                Scanner tipo = new Scanner(System.in);
                String t = null;
                Insetar(t);
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
}
