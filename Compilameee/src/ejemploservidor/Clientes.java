/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploServidor;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author Juanra
 */
public class Clientes {
    private int idCli;
    private String nomCli;
    private BufferedReader entrada;
    private PrintWriter salida;
    private boolean baneado=false;
    private boolean dentro=true;
    public Clientes(int id, BufferedReader br, PrintWriter pw){
        idCli=id;
        entrada=br;
        salida=pw;
        ponNombre();
    }
    public void ponNombre(){
            nomCli="Cliente_"+idCli;
    }

    public int getIdCli() {
        return idCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public BufferedReader getEntrada() {
        return entrada;
    }

    public PrintWriter getSalida() {
        return salida;
    }

    public boolean isBaneado() {
        return baneado;
    }

    public void setBaneado(boolean baneado) {
        this.baneado = baneado;
    }

    public boolean isDentro() {
        return dentro;
    }

    public void setDentro(boolean dentro) {
        this.dentro = dentro;
    }
    
}
