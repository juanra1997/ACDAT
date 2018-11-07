package ejercicios;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juanra
 */
public class CrearFichero {

    private static ObjectInputStream fs;
    private static ObjectOutputStream fos;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char resp = 'S';
        File archivo = new File("Departamentos.dat");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
            }
        }
        if (archivo.length() != 0) {
            try {
                int cont = 1;
                fs = new ObjectInputStream(new FileInputStream(archivo));
                Departamento leido = new Departamento();
                leido = (Departamento) fs.readObject();
                do {
                    JOptionPane.showMessageDialog(null, "Departamento: " + cont
                            + "\n\fID: " + leido.getId() + "\n\fTipo: " + leido.getTipo()
                            + "\n\fNombre: " + leido.getNombre() + "\n\fDomicilio: " + leido.getDomicilio()
                            + "\n\fCiudad: " + leido.getCiudad() + "\n\fCP: " + leido.getCp()
                            + "\n\fProvincia: " + leido.getProvincia() + "\n\fPais: " + leido.getPais());
                    leido = (Departamento) fs.readObject();
                    cont++;
                } while (true);
            } catch (EOFException eof) {
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

        System.out.println("¿Quieres añadir un departamentos? S/N");
        resp = Character.toUpperCase(sc.next().charAt(0));
        while (resp == 'S') {
            sc = new Scanner(System.in);
            System.out.println("Introduce el ID");
            String id = sc.nextLine();
            System.out.println("Introduce el tipo");
            String tipo = sc.nextLine();
            System.out.println("Introduce el nombre");
            String nombre = sc.nextLine();
            System.out.println("Introduce el domicilio");
            String domicilio = sc.nextLine();
            System.out.println("Introduce la ciudad");
            String ciudad = sc.nextLine();
            System.out.println("Introduce el CP");
            String cp = sc.nextLine();
            System.out.println("Introduce la provincia");
            String provincia = sc.nextLine();
            System.out.println("Introduce el pais");
            String pais = sc.nextLine();
            Departamento miDepartamento = new Departamento(id, tipo, nombre, domicilio, ciudad, cp, provincia, pais);
            if (archivo.length() == 0) {
                try {
                    fos = new ObjectOutputStream(new FileOutputStream(archivo, true));
                    fos.writeObject(miDepartamento);
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
                try {
                    fos = new MiObjectOutputStream(new FileOutputStream(archivo, true));
                    fos.writeObject(miDepartamento);
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
            System.out.println("¿Quieres añadir otro departamento? S/N");
            resp = Character.toUpperCase(sc.next().charAt(0));
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

    @Override
    protected void writeStreamHeader() throws IOException {

    }

}
