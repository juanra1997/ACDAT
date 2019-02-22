/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package congreso;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import java.util.List;
/**
 *
 * @author Juanra
 */
public class Main {
    
    static ObjectContainer db;
    static Ponente p, aux;
    static Charla c;
    static ObjectSet res, auxres;
    static Query query;
    static List resul;
    
    public static void main(String[] args0){
        
        db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "congreso.db4o");
        try{
            //almacenarPonentes(db);
            //consultarPonentes(db);
            //consultarSODAPonentes(db);
            //consultarPonenteNQcache200(db);
            consultaSODA(db);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            db.close();
        }
    }
    public static void almacenarPonentes(ObjectContainer db){
        Ponente p1=new Ponente("11A", "Antonio Camaco", "acamacho@gmail.es", 300);
        Ponente p2=new Ponente("22B", "Isabel Perez", "iperez@hotmail.es", 100);
        Ponente p3=new Ponente("33C", "Ana Navarro", "anavarro@yahoo.com", 200);
        Ponente p4=new Ponente("44D", "Pedro Sanchez", "psanchez@mixmail.com", 90);
        
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
    }
    public static void consultaSODA(ObjectContainer db){
        p=new Ponente(null, null, null, 0);
        c=new Charla();
    }
    public static void consultarPonentes(ObjectContainer db){
        
        System.out.println("CONSULTAS NORMALES\n");
        
        p=new Ponente("66P", null, null, 0);
        res=db.queryByExample(p);
        
        if(res.isEmpty()){
            System.out.println("El dni no existe");
        }else{
        
        System.out.println("Todos los datos:\n");
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        //System.out.println();
        System.out.println("\nPonentes con mas de 200 de cache:");

        res.reset();
        
        for(int i=0;i<res.size();i++){
            aux=(Ponente)res.get(i);
            if(aux.getCache()>200){
                System.out.println(aux.toString());
            }
        }
        //System.out.println();
        System.out.println("\nPonentes con gmail:");
        
        res.reset();
        
        for(int i=0;i<res.size();i++){
            aux=(Ponente)res.get(i);
            if(aux.getEmail().contains("gmail")){
                System.out.println(aux.toString());
            }
        }
        
        res.reset();
        
        System.out.println("\nNombre de los ponentes que tienen mas de 5 caracteres");
        
        for(int i=0;i<res.size();i++){
            aux=(Ponente)res.get(i);
            if(aux.getNombre().length()>5){
                System.out.println(aux.toString());
            }
        }
        
        res.reset();
        
        System.out.println("\nCorreos de ponentes cuyo cache sea mayor de 200");
        
        for(int i=0;i<res.size();i++){
            aux=(Ponente)res.get(i);
            if(aux.getCache()>200){
                System.out.println(aux.getEmail());
            }
        }
        
        res.reset();
        
        System.out.println("\nNombre y correo de los ponentes cuyo cache sea menor de 500 o tengan como letra del nif f");
        
        for(int i=0;i<res.size();i++){
            aux=(Ponente)res.get(i);
            if(aux.getCache()<500&&aux.getNif().charAt(1)=='F'){
                System.out.println(aux.getNombre()+" "+aux.getEmail());
            }
        }
        }
    }
    public static void consultarSODAPonentes(ObjectContainer db){
        
        System.out.println("\nCONSULTAS SODA\n");
        
        /*Query*/ query=db.query();
        
        Constraint constra1=query.descend("cache").constrain(50).greater();
        
        //query=db.query();
        
        query.constrain(Ponente.class);
        
        query.descend("cache").constrain(200).smaller().and(constra1);
        
        //query.descend("cache").constrain(50).greater();
        
        res=query.execute();
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        query=db.query();
        
        query.constrain(Ponente.class);
        
        query.descend("nombre").constrain(new String().length()>5);
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
    }
    
    public static void consultarPonenteNQcache200(ObjectContainer db){
        
        System.out.println("\nCONSULTAS NATIVAS\n");
        
        resul=db.query(new com.db4o.query.Predicate() {

            public boolean match(Ponente p){
                return p.getNombre().length()>5;
            }
            
            @Override
            public boolean match(Object et) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        auxres=(ObjectSet)resul;
        while(auxres.hasNext()){
            System.out.println(auxres.next().toString());
        }
    }
}
//Mostrar en pantalla el nombre de los ponentes que tienen un correo de gmail-->Hehco

//Mostrar en pantalla el nombre de los ponentes que tienen un cache superior a 200-->Hecho

//Nombre de los ponentes que tienen mas de 5 caracteres-->Falta soda

//Correos de ponentes cuyo cache sea mayor de 200-->Falta soda

//Nombre y correo de los ponentes cuyo cache sea menor de 500 o tengan como letra del nif f-->Falta soda

//Que devuelve si no encuentra ningun objeto: Devuelve un string vacio

