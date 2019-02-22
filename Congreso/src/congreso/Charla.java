/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package congreso;

/**
 *
 * @author Juanra
 */
public class Charla {
    
    String titulo;
    double duracion;
    Ponente ponente;
    
    public Charla(){
        
        titulo="Vacio";
        duracion=-1;
        ponente=new Ponente();
        
    }
    
    public Charla(String t, double d, Ponente p){
        
        titulo=t;
        duracion=d;
        ponente=p;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Ponente getPonente() {
        return ponente;
    }

    public void setPonente(Ponente ponente) {
        this.ponente = ponente;
    }

    @Override
    public String toString() {
        return "Charla:\n\t" + "titulo=" + titulo + "\n\tduracion=" + duracion + "\n\tponente=" + ponente.toString();
    }
    
}
