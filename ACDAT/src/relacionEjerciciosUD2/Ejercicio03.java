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
        System.out.println("Introduce la ruta del directorio a borrar");
        String dir=sc.nextLine();
        File del=new File(dir);
        if(!del.isDirectory()){
            System.out.println("No es un directorio valido");
        } else {
            if(!dir.isEmpty()){
                //System.out.println(dir);
                //System.out.println(entrar(del.getAbsolutePath()));
                borrar(dir);
            }
            /*del.delete();
            if(!del.exists()){
                System.out.println("Borrado con exito");
            } else {
                System.out.println("No borrado");
            }*/
        }
    }
    
    public static String entrar(String ruta){
        
        File dir=new File(ruta);
        String[] dentro=dir.list();
        return ruta+"\\"+dentro[0];
    }
    
    public static void borrar(String ruta){
        
        File dir=new File(ruta);
        String[] borrar=dir.list();
        for(int i=0; i<borrar.length; i++){
            File ter=new File(ruta+"\\"+borrar[i]);
            if(ter.isFile()){
                ter.delete();
            }
        }
    }
}
//C:\Users\Juanra\Desktop\prueba\prueba2

//Borra los ficheros, entra en los directorios, falta que entre los borre,
//salga y borre el directorio.