package empresa.entity;
// Generated 13-nov-2018 9:03:45 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Empleados generated by hbm2java
 */
public class Empleados  implements java.io.Serializable {


     private short empNo;
     private Departamentos departamentos;
     private String apellido;
     private String oficio;
     private Short dir;
     private Date fechaAlt;
     private Float salario;
     private Float comision;

    public Empleados() {
    }

	
    public Empleados(short empNo, Departamentos departamentos) {
        this.empNo = empNo;
        this.departamentos = departamentos;
    }
    public Empleados(short empNo, Departamentos departamentos, String apellido, String oficio, Short dir, Date fechaAlt, Float salario, Float comision) {
       this.empNo = empNo;
       this.departamentos = departamentos;
       this.apellido = apellido;
       this.oficio = oficio;
       this.dir = dir;
       this.fechaAlt = fechaAlt;
       this.salario = salario;
       this.comision = comision;
    }
   
    public short getEmpNo() {
        return this.empNo;
    }
    
    public void setEmpNo(short empNo) {
        this.empNo = empNo;
    }
    public Departamentos getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getOficio() {
        return this.oficio;
    }
    
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    public Short getDir() {
        return this.dir;
    }
    
    public void setDir(Short dir) {
        this.dir = dir;
    }
    public Date getFechaAlt() {
        return this.fechaAlt;
    }
    
    public void setFechaAlt(Date fechaAlt) {
        this.fechaAlt = fechaAlt;
    }
    public Float getSalario() {
        return this.salario;
    }
    
    public void setSalario(Float salario) {
        this.salario = salario;
    }
    public Float getComision() {
        return this.comision;
    }
    
    public void setComision(Float comision) {
        this.comision = comision;
    }




}


