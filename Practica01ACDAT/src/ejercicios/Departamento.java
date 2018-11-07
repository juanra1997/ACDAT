package ejercicios;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juanra
 */
@XStreamAlias("Departamento")
public class Departamento implements Serializable {

    @XStreamAlias("ID")
    String id;
    @XStreamAlias("Tipo")
    String tipo;
    @XStreamAlias("Nombre")
    String nombre;
    @XStreamAlias("Domicilio")
    String domicilio;
    @XStreamAlias("Ciudad")
    String ciudad;
    @XStreamAlias("CP")
    String cp;
    @XStreamAlias("Provincia")
    String provincia;
    @XStreamAlias("Pais")
    String pais;

    public Departamento() {

    }

    public Departamento(String ide, String tipoe, String nombree, String domicilioe, String ciudade, String cpe, String provinciae, String paise) {

        id = ide;
        nombre = nombree;
        tipo = tipoe;
        domicilio = domicilioe;
        ciudad = ciudade;
        cp = cpe;
        provincia = provinciae;
        pais = paise;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
