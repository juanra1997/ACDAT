/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author Juanra
 */
public class Servidor {
    static boolean salir=false;
    public static void main(String[] args){
        int puerto=15000;
        int id=1;
        ArrayList<Clientes> misClientes= new ArrayList<>();
        try {
            ServerSocket conexiones= new ServerSocket(puerto);
            banner();
            HablarServidor habSer= new HablarServidor(misClientes, salir); 
            (new Thread(habSer)).start();
            while(!salir){
                HiloServidor hiloServ=new HiloServidor(conexiones.accept(), misClientes, id++);
                (new Thread(hiloServ)).start();
            }
            
        } catch (IOException ex) {
            System.err.println("Error al Iniciar el Chat, mensaje: "+ex.getMessage());
        }
    }
    //--------------------------------------------------------------------------
    public static void banner(){
        System.out.println("+--------------------------------------+");
        System.out.println("|                                      |");
        System.out.println("|    **** Chat V 2.0 Iniciado ****     |");
        System.out.println("|    ****    Puerto 15000     ****     |");
        System.out.println("|                                      |");
        System.out.println("+--------------------------------------+\n");
        
    }
    
}
