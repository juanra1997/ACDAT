/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploServidor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juanra
 */
public class HablarServidor implements Runnable {

    Scanner teclado = new Scanner(System.in);
    ArrayList<Clientes> clientes;
    boolean salir;
    int privado=-1;

    public HablarServidor(ArrayList<Clientes> c, boolean exit) {
        clientes = c;
        salir = exit;
    }

    @Override
    public void run() {
        String cad;
        System.out.println("** Los Comandos Activos son :");
        System.out.println("1.- /h Ayuda.");
        System.out.println("2.- /b Banear cliente.");
        System.out.println("3.- /d Expulsar cliente.");
        System.out.println("4.- /l Listar Usuarios.");
        System.out.println("5.- /r Ver clientes baneados.");
        System.out.println("6.- /p Chat Privado");
        System.out.println("7.- /q Quitar baneo");
        System.out.println("8.- /z Salir de privado");
        while (true) {
            cad = teclado.nextLine();
            if (cad.trim().equalsIgnoreCase("cerrar") || cad.trim().equalsIgnoreCase("exit")) {
                salir = true;
                break;
            }
            if (cad.length() == 2 && cad.charAt(0) == '/') {
                switch (cad.charAt(1)) {
                    case 'h':
                        System.out.println("** Los Comandos Activos son :");
                        System.out.println("1.- /h Ayuda.");
                        System.out.println("2.- /b Banear cliente.");
                        System.out.println("3.- /d Expulsar cliente.");
                        System.out.println("4.- /l Listar Usuarios.");
                        System.out.println("5.- /r Ver clientes baneados.");
                        System.out.println("6.- /p Chat Privado");
                        System.out.println("7.- /q Quitar baneo");
                        System.out.println("8.- /z Salir de privado");
                        break;
                    case 'b':
                        banear();
                        break;
                    case 'd':
                        expulsar();
                        break;
                    case 'l':
                        listarUsuarios();
                        break;
                    case 'r':
                        verBaneados();
                        break;
                    case 'p':
                        iniciarPrivado();
                        break;
                    case 'q':
                        desbanear();
                        break;
                    case 'z':
                        privado=-1;
                        break;
                }
            } else {
                if (clientes.size()!=0) {
                    if (!cad.isEmpty()) {
                        if(privado==-1){
                            for (Clientes c : clientes) {
                                c.getSalida().println("[Servidor]>" + cad);
                            }
                        }else{
                            for (Clientes c : clientes) {
                                if(c.getIdCli()==privado){
                                    c.getSalida().println("[Servidor]>" + cad);
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("\tNingún Cliente Conectado al Chat!!!!!!");
                }
            }
        }
    }

    //--------------------------------------------------------------------------
    public void listarUsuarios() {
        if (clientes.size() != 0) {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(clientes.get(i).getNomCli() + ", Codigo Cliente: " + clientes.get(i).getIdCli());
            }
        } else {
            System.out.println("No hay clientes");
        }
    }

    //--------------------------------------------------------------------------
    public void verBaneados() {
        if (clientes.size() != 0) {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).isBaneado()) {
                    System.out.println(clientes.get(i).getNomCli() + ", Codigo Cliente: " + clientes.get(i).getIdCli());
                }
            }
        } else {
            System.out.println("No hay clientes");
        }
    }

    //--------------------------------------------------------------------------
    public void banear() {
        int id = -1;
        if (clientes.size() != 0) {
            for (int i = 0; i < clientes.size(); i++) {
                if (!clientes.get(i).isBaneado()) {
                    System.out.println(clientes.get(i).getNomCli() + ", Codigo Cliente: " + clientes.get(i).getIdCli());
                }
            }
            System.out.println("Selecciona el id del usuario a banear");
            try {
                id = teclado.nextInt();
                if (id != -1) {
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getIdCli() == id) {
                            clientes.get(i).setBaneado(true);
                            clientes.get(i).getSalida().println("Has sido baneado");
                            System.out.println("Baneo realizado con exito");
                        }
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("No es un id valido");
            }
        } else {
            System.out.println("No hay clientes");
        }
    }

    //--------------------------------------------------------------------------

    public void desbanear() {
        int id = -1;
        if (clientes.size() != 0) {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).isBaneado()) {
                    System.out.println(clientes.get(i).getNomCli() + ", Codigo Cliente: " + clientes.get(i).getIdCli());
                }
            }
            System.out.println("Selecciona el id del usuario a desbanear");
            try {
                id = teclado.nextInt();
                if (id != -1) {
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getIdCli() == id && clientes.get(i).isBaneado()) {
                            clientes.get(i).setBaneado(false);
                            clientes.get(i).getSalida().println("Has sido desbaneado");
                            System.out.println("Desbaneo realizado con exito");
                        }
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("No es un id valido");
            }
        } else {
            System.out.println("No hay clientes");
        }
    }

    //--------------------------------------------------------------------------

    public void expulsar() {
        int id=-1;
        listarUsuarios();
        System.out.println("Selecciona el codigo del usuario a expulsar");
        try {
            id = teclado.nextInt();
            if (id != -1) {
                for (int i = 0; i < clientes.size(); i++) {
                    if (clientes.get(i).getIdCli() == id) {
                        clientes.get(i).getSalida().println("Has sido expulsado");
                        clientes.remove(i);
                        System.out.println("Expulsion realizada con exito");
                    }
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("No es un id valido");
        }
    }
    
    //--------------------------------------------------------------------------
    public void iniciarPrivado(){
        listarUsuarios();
        System.out.println("Selecciona el codigo del cliente con el que iniciar el chat privado");
        try {
            privado = teclado.nextInt();           
        } catch (Exception e) {
            System.out.println("No es un id valido");
            privado=-1;
        }
    }
}

