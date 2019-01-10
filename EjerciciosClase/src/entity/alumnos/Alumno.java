package entity.alumnos;
// Generated 19-nov-2018 22:51:26 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Alumno generated by hbm2java
 */
public class Alumno  implements java.io.Serializable {


     private String dni;
     private String nombre;
     private Integer edad;
     private String beca;
     private Set matriculas = new HashSet(0);

    public Alumno() {
    }

	
    public Alumno(String dni) {
        this.dni = dni;
    }
    public Alumno(String dni, String nombre, Integer edad, String beca, Set matriculas) {
       this.dni = dni;
       this.nombre = nombre;
       this.edad = edad;
       this.beca = beca;
       this.matriculas = matriculas;
    }
   
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return this.edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getBeca() {
        return this.beca;
    }
    
    public void setBeca(String beca) {
        this.beca = beca;
    }
    public Set getMatriculas() {
        return this.matriculas;
    }
    
    public void setMatriculas(Set matriculas) {
        this.matriculas = matriculas;
    }




}

