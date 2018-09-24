/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Juanra
 */
public class Ejercicio09 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        char resp='S';
        File archivo=new File("AleatorioEmple.dat");
        if(!archivo.exists()){
            System.out.println("El archivo no existe");
        } else{
            RandomAccessFile archivor;
            try {
                archivor = new RandomAccessFile(archivo, "rw");
                System.out.println("¿Quieres borrar empleados? S/N");
                resp=Character.toUpperCase(sc.next().charAt(0));
                    while(resp=='S'){
                    String nom;
                    sc=new Scanner(System.in);
                    System.out.println("Introduce el apellido");
                    nom=sc.nextLine();
                    try {
                    while(true){
                        String apell=archivor.readUTF();
                        String depl=archivor.readUTF();
                        double sall=archivor.readDouble();
                        Empleado leido=new Empleado(apell, depl, sall);
                        if(leido.getApellido().toUpperCase().equals(
                        nom.toUpperCase())){
                            leido.setApellido("-1");
                            System.out.println(leido.toString());
                        }
                    }
                } catch (EOFException ex) {
                
                } catch (IOException exf){
            }
                System.out.println("¿Quieres borrar mas empleados? S/N");
                resp=Character.toUpperCase(sc.next().charAt(0));
            }
            } catch (FileNotFoundException ex) {
            }
        }
        sc.close();
    }
}