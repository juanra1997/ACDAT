/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.Serializable;

/**
 *
 * @author Juanra
 */
public class Coche implements Serializable {
    
    private String matricula;
    private String marca;
    private double deposito;
    private String modelo;
    
    public Coche(){
        
    }
    
    public Coche(String mat, String marc, double dep, String mod){
        
        this.matricula=mat;
        this.marca=marc;
        this.deposito=dep;
        this.modelo=mod;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
