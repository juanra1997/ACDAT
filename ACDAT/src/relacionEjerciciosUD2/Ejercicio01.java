/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Juanra
 */
public class Ejercicio01 {
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        String ruta;
        System.out.println("Introduce la ruta del directorio a listar");
        ruta=sc.nextLine();
        System.out.println("***************************************************"
                    + "**********************");
        File dir=new File(ruta);
        if(!dir.isDirectory()){
            System.out.println("No es un directorio valido");
        } else {
            String[] lista=dir.list();
            if(lista==null){
                System.out.println("El directorio esta vacio\n*****************"
                        + "****************************************************"
                        + "****");
            } else {
                System.out.println("Lista:");
                for(int i=0; i<lista.length; i++){
                    System.out.println(lista[i]);
                }
                System.out.println("*******************************************"
                        + "******************************");
            }    
        }
        sc.close();
    }
}
//C:\Users\Juanra\Desktop\prueba