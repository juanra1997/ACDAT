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
public class Ponente {
    
    private String nif;
    private String nombre;
    private String email;
    private float cache;
    
    public Ponente(){
        nif="Vacio";
        nombre="Vacio";
        email="Vacio";
        cache=-1;
    }
    public Ponente(String n, String nom, String e, float c){
        nif=n;
        nombre=nom;
        email=e;
        cache=c;
    }
    
    public Ponente(String n, String nom, String e){
        nif=n;
        nombre=nom;
        email=e;
        cache=-1;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getCache() {
        return cache;
    }

    public void setCache(float cache) {
        this.cache = cache;
    }

    @Override
    public String toString(){
        if(cache!=-1){
            return nif+" "+nombre+" "+email+" Cache: "+cache;
        }else{
            return nif+" "+nombre+" "+email;
        }
    }
    
}
