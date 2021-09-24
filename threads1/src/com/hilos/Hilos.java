package com.hilos;

import java.util.Date;

public class Hilos extends Thread {
    
    //override        Debemos sobreescribir el método run() de la class Thread para poder utilizarlo.
    public void run() {
        System.out.println("Mensaje de hilo, " + new Date() + Thread.currentThread());
    }
    public static void main(String[] args) {
        Hilos hilo1 = new Hilos();
        Hilos hilo2 = new Hilos();
        hilo1.start();
        hilo2.start();
    }
}
