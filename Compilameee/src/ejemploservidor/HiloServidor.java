/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Juanra
 */
public class HiloServidor implements Runnable{
    Socket con;
    ArrayList<Clientes> losClientes;
    Clientes miCliente;
    int id;
    BufferedReader entrada;
    PrintWriter salida;
    boolean privado=false;
    boolean servidor=false;
    int cliPrivado=-1;

    public HiloServidor(Socket con, ArrayList<Clientes> alc, int id){
        losClientes=alc;
        this.con=con;
        this.id=id;
    }
    @Override
    public void run(){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                PrintWriter pw= new PrintWriter(con.getOutputStream(), true)
                   )
        {
            entrada=br;
            salida=pw;
            iniciaCliente();

            String cad="";
            while(cad!=null){
                cad=entrada.readLine().trim();

                if (cad==null || cad.equalsIgnoreCase("exit")||cad.equals("/x")||miCliente.isDentro()) break;
                if(!miCliente.isBaneado()){
                    mandarMensaje(cad);
                }                
            }
            System.out.println("El Cliente: "+miCliente.getNomCli()+ " se ha desconectado!!!");
            losClientes.remove(miCliente);
        }catch(IOException ex){
           losClientes.remove(miCliente);
            System.out.println("Error en HiloServidor: " +ex.getMessage());
        }
    }
    //--------------------------------------------------------------------------
    public void iniciaCliente(){
        miCliente= new Clientes(id, entrada, salida);
        losClientes.add(miCliente);
        System.out.println("\tCliente: "+miCliente.getNomCli()+ ", Conectado");
        miCliente.getSalida().println("Bienvenido al Chat cliente \""+miCliente.getNomCli()+"\"");
        verAyuda();
    }
    //--------------------------------------------------------------------------
    public void mandarMensaje(String cad){

        if(cad.length()==2 && cad.charAt(0)=='/'){
            evaluaOrden(cad);
            return;
        }
        if(servidor){
            System.out.println("["+miCliente.getNomCli()+"]>"+cad);
            return;
        }
        if(!privado){
            System.out.println("["+miCliente.getNomCli()+"]>"+cad);
            for(Clientes c: losClientes){
                if(c!=miCliente){
                    if(c.isDentro()){
                        c.getSalida().println("["+miCliente.getNomCli()+"]>"+cad);
                    }
                }
            }
        }
        else{
             for(Clientes c: losClientes){
                if(c!=miCliente && c.getIdCli()==this.cliPrivado){
                    c.getSalida().println("<<"+miCliente.getNomCli()+">>: "+cad);
                }
            }
        }
    }
    //-------------------------------------------------------------------------
    public void evaluaOrden(String orden){
        char op=orden.charAt(1);
        switch(op){
            case 'l':
                listarUsuarios();
                break;
            case 'h' :
                verAyuda();
                break;
            case 'p' :
                    iniciarPrivado();
                    break;
            case 'z' :
                this.privado=false;
                this.servidor=false;
                break;
            case 's':
                chatPrivadoServidor();
                break;
            default :
                miCliente.getSalida().println("Orden erronea o comando NO implementado!!!");
        }
    }
    //--------------------------------------------------------------------------
    public void listarUsuarios(){
        int id=1;
        miCliente.getSalida().println("** Los Clientes Activos son :");
        for(Clientes c : this.losClientes){
            if(c!=miCliente) {
                miCliente.getSalida().println(id+".- "+c.getNomCli()+", Codigo Cliente: "+c.getIdCli());
                id++;
            }
        }
    }
    //--------------------------------------------------------------------------
    public void verAyuda(){
        miCliente.getSalida().println("** Los Comandos Activos son :");
        miCliente.getSalida().println("1.- /h Ayuda.");
        miCliente.getSalida().println("2.- /l Listar Usuarios.");
        miCliente.getSalida().println("3.- /p Chat Privado");
        miCliente.getSalida().println("4.- /z Salir Chat Privado");
        miCliente.getSalida().println("5.- /s Chat Privado Servidor");
        miCliente.getSalida().println("6.- /x Salir");
    }
    //--------------------------------------------------------------------------
    public void iniciarPrivado(){
        if(losClientes.size()<2){
            miCliente.getSalida().println("No Hay Clientes Suficientes!!!!");
            return;
        }
        listarUsuarios();
        String cad="";
        int opcion=0;
        do{
            miCliente.getSalida().println("Elija un id_cli (exit para anular): ");
           
            try{
                cad=miCliente.getEntrada().readLine().trim();
                if(cad.equalsIgnoreCase("exit")) break;
                opcion=Integer.parseInt(cad);

                if(evalua(opcion)==-1){
                    miCliente.getSalida().println("Opción Erronea!!!!");
                }
                else{
                   servidor=false;
                   privado=true;
                   this.cliPrivado=opcion;
                   return;
                }
            }catch(NumberFormatException ex){
                miCliente.getSalida().println("Error a convertir a int, Opción Erronea!!!!");
            }catch(IOException ex){
                System.err.println("Error al iniciar chat privado!!!");
            }
        }while(!cad.equalsIgnoreCase("exit"));
        
    }
    //--------------------------------------------------------------------------
    public int evalua(int o){
       int valor=-1;
       for(Clientes c: losClientes){
            if(o==c.getIdCli()){
                valor=c.getIdCli();
                return valor;
            }
        }
        return valor;
    }
    //--------------------------------------------------------------------------
    public void chatPrivadoServidor(){
        this.servidor=true;
        this.privado=false;
    }
    //--------------------------------------------------------------------------
}
