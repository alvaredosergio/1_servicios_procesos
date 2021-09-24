package com.basico;

public class Ejecutar {
    public static void main(String[] args) {
        Hijo hijo = new Hijo();
        // Una clase abstracta no se puede instanciar. PADRE la establecemos como abstract y asi no se puede
        // crear en una clase hija.
        /*Padre padre = new Padre();*/
        String mensaje = hijo.comunicar();
        System.out.println(mensaje);
        hijo.escribir();

        // Como llamar a un metodo sobreescrito de la clase Padre ¿Super?
        
    }
}
