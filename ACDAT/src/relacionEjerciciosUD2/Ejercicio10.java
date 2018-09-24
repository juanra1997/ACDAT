/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Juanra
 */
public class Ejercicio10 {
    
    private static ObjectInputStream fs;
    private static ObjectOutputStream fos;
        
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        char resp='S';
        File archivo=new File("inventario.dat");
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
            }
        }
        if(archivo.length()!=0){
            try {
		fs = new ObjectInputStream(new FileInputStream(archivo));	
		Coche leido=new Coche();
		leido=(Coche) fs.readObject();
		do {
                    JOptionPane.showMessageDialog(null, "El vehiculo tiene una "
                    + "matricula "+leido.getMatricula()+", su marca es "
                    +leido.getMarca()+", el tamaño de su deposito es "
                    +leido.getDeposito()+" y su modelo es "+leido.getDeposito())
                    ;
                    leido= (Coche) fs.readObject();
		}while(true);
	} catch (EOFException eof){
	} catch (ClassNotFoundException e) {
            System.out.println("ERROR: Problema al leer objeto");
	} catch (FileNotFoundException e1) {
            System.out.println("ERROR: Archivo no encontrado");
	} catch (IOException e1) {
            System.out.println("ERROR: Problema en la lectura");
	} finally {
            try {
		fs.close();
            } catch (IOException e) {

            }
	}
        }
            
        System.out.println("¿Quieres añadir un coche? S/N");
        resp=Character.toUpperCase(sc.next().charAt(0));
        while(resp=='S'){
            sc=new Scanner(System.in);
            System.out.println("Introduce la matricula");
            String matricula=sc.nextLine();
            System.out.println("Introduce la marca");
            String marca=sc.nextLine();
            System.out.println("Introduce tamaño del deposito");
            double deposito=sc.nextDouble();
            sc=new Scanner(System.in);
            System.out.println("Introduce el modelo");
            String modelo=sc.nextLine();
            Coche miCoche=new Coche(matricula, marca, deposito, modelo);
            if(archivo.length()==0){
            try{
                fos = new ObjectOutputStream(new FileOutputStream(archivo, true)
                );
                fos.writeObject(miCoche);
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
            } else {
                try{
                fos = new MiObjectOutputStream(new FileOutputStream(archivo, 
                        true));
                    fos.writeObject(miCoche);
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
            System.out.println("¿Quieres añadir otro coche? S/N");
            resp=Character.toUpperCase(sc.next().charAt(0));
            }
    }
}

class MiObjectOutputStream extends ObjectOutputStream {

    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }


    protected MiObjectOutputStream() throws IOException, SecurityException {
        super();
    }


    protected void writeStreamHeader() throws IOException {
    	
    }

}