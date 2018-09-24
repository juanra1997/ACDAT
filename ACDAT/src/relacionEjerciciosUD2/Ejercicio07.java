/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Juanra
 */
public class Ejercicio07 {
    
    private static ObjectInputStream fs;
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un numero");
        int num=sc.nextInt();
        sc=new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero con su extension");
        String ruta=sc.nextLine();
        File archivo=new File(ruta);
        for(int i=0; i<num; i++){
            escribir(archivo);
        }
        sc.close();
    }
      
    private static ObjectOutputStream fos;
    
    public static void escribir(File archivo) {
        
        try{
            fos = new ObjectOutputStream(new FileOutputStream(archivo, true));
            int x=(int)(Math.random()*100+1);
            fos.writeInt(x);
	} catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");
	} catch (IOException e) {
            System.out.println("ERROR: Problema en la escritura");
	} finally {
            try {
		fos.close();
            } catch (IOException e) {
            }
	}
    }
}

//C:\Users\Juanra\Desktop\numeros.bin