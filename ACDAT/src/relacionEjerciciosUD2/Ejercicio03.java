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
public class Ejercicio03 {
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el directorio a borrar");
        String ruta=sc.nextLine();
        borrarCarpeta(new File(ruta));
        sc.close();
    }
    private static void borrarCarpeta(File archivo) {
        
        if(archivo.isDirectory()){            
            if(archivo.list().length==0){
                archivo.delete();
            } else {
                String[] prueba=archivo.list();
                for(int i=0; i<prueba.length; i++){
                    File borrar=new File(archivo.getAbsoluteFile()+"\\"+prueba[i
                        ]);
                    borrarCarpeta(borrar);
                }
                if(archivo.list().length==0){
                   archivo.delete();  
                }
            }
        } else {
            archivo.delete();            
        }
    }
}