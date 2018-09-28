/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearXML;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Juanra
 */
public class CrearAccesoAleatorio {
    
    public static void main(String[] args) {
        File directorio = new File("AleatorioEmple.dat");
        try{
            // creacion del flujo
            RandomAccessFile acceso = new RandomAccessFile(directorio, "rw");
            // id 2 apellido 60 departamento 60 salario 2 = 122
            long posicionIn = acceso.length();
            
            acceso.seek(posicionIn);
            acceso.writeInt(1234);
            acceso.writeUTF("Gonzalez");
            acceso.writeUTF("Informatica");
            acceso.writeInt(2222);
            acceso.setLength(acceso.getFilePointer()+(122-( acceso.getFilePointer()-posicionIn)));
            System.out.println(acceso.length());
            // id 2 apellido 60 departamento 60 salario 2 = 122
            posicionIn = acceso.length();
            
            acceso.seek(posicionIn);
            acceso.writeInt(1234);
            acceso.writeUTF("valenzuela");
            acceso.writeUTF("matrioskas");
            acceso.writeInt(4000);
            acceso.setLength(acceso.getFilePointer()+(122-( acceso.getFilePointer()-posicionIn)));
            // id 2 apellido 60 departamento 60 salario 2 = 122
            posicionIn = acceso.length();
            
            acceso.seek(posicionIn);
            acceso.writeInt(1234);
            acceso.writeUTF("valenzuela");
            acceso.writeUTF("matrioskas");
            acceso.writeInt(4000);
            acceso.setLength(acceso.getFilePointer()+(122-( acceso.getFilePointer()-posicionIn)));
            System.out.println(acceso.length());
        }catch(IOException io){
            System.out.println("error entrada salida");
            io.printStackTrace();
        }catch(Exception ex){
            System.out.println("error");
            ex.printStackTrace();
        }
    }
}

