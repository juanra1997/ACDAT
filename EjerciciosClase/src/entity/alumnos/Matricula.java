package entity.alumnos;
// Generated 19-nov-2018 22:51:26 by Hibernate Tools 4.3.1



/**
 * Matricula generated by hbm2java
 */
public class Matricula  implements java.io.Serializable {


     private MatriculaId id;
     private Alumno alumno;
     private Asignatura asignatura;
     private Integer nota;
     private Integer nconvocatoria;

    public Matricula() {
    }

	
    public Matricula(MatriculaId id, Alumno alumno, Asignatura asignatura) {
        this.id = id;
        this.alumno = alumno;
        this.asignatura = asignatura;
    }
    public Matricula(MatriculaId id, Alumno alumno, Asignatura asignatura, Integer nota, Integer nconvocatoria) {
       this.id = id;
       this.alumno = alumno;
       this.asignatura = asignatura;
       this.nota = nota;
       this.nconvocatoria = nconvocatoria;
    }
   
    public MatriculaId getId() {
        return this.id;
    }
    
    public void setId(MatriculaId id) {
        this.id = id;
    }
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Asignatura getAsignatura() {
        return this.asignatura;
    }
    
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    public Integer getNota() {
        return this.nota;
    }
    
    public void setNota(Integer nota) {
        this.nota = nota;
    }
    public Integer getNconvocatoria() {
        return this.nconvocatoria;
    }
    
    public void setNconvocatoria(Integer nconvocatoria) {
        this.nconvocatoria = nconvocatoria;
    }




}


