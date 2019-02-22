package pruebas;//Paquete

import java.util.Scanner;//Importacion de la clase Scanner

public class prueba {//Comienzo de la clase

    public static void main(String[] args) {//Comienzo del metodo principal

        Scanner sc;//Objeto de tipo escaner que nos va a permitir la introduccion de datos por teclado
        boolean correcto = false;//Objeto de tipo booleanl que nos va a controlar la salida del bucle
        String linea;//Objeto de tipo String que nos va a permitir guardar los datos introducidos por teclado

        while (!correcto) {//Comienzo del bucle, mientras que la condicion sea verdadera, seguira ejecutandose. (La variable booleana es false pero la exclamacion cambia el significado, por lo tanto pasa a ser true)
            sc = new Scanner(System.in);//Instanciamos la variable aqui para asi evitar posibles futuros errores de buffer
            System.out.println("Introduce un numero de tres cifras");//Mostramos por patalla un mensaje
            linea = sc.nextLine();//Guardamos la introduccion del usuario por teclado en una variable
            if (linea.length() == 3) {//Ponemos las condiciones, si las condiciones se cumplen:
                System.out.println("\nDato correcto\n");//Mostramos por pantalla un mensaje
                correcto = true;//Cambiamos el valor de la variable booleana para poder salir del bucle
                for(int i=0; i<linea.length(); i++){
                    if(!Character.isDigit(linea.charAt(i))&&correcto){
                        System.out.println("No es un numero\n");
                        correcto=false;
                    }
                }
                if(correcto){
                    for(int i=0; i<linea.length(); i++){
                        switch (i){
                            case 0:
                                System.out.println("Centesimas: "+linea.charAt(i));
                                break;
                            case 1:
                                System.out.println("Decimas: "+linea.charAt(i));
                                break;
                            case 2:
                                System.out.println("Unidades: "+linea.charAt(i));
                                break;
                        }
                    }
                }
            } else {//Sino se cumplen
                System.out.println("Dato incorrecto\n");//Mostramos por pantalla un mensaje
            }//Salimos del if
            if (correcto) {
                sc.close();//Cerramos el Scanner
            }
        }//Salimos del bucle
        System.out.println("\nFin del programa");//Mostramos por pantalla un mensaje
    }//Fin del metodo

}//Fin de la clase
