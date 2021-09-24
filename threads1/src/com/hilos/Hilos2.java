package com.hilos;

import java.util.Date;

public class Hilos2 implements Runnable {
    public static void main(String[] args) {
        Hilos2 hilos2 = new Hilos2();
        Thread hiloobjeto = new Thread(hilos2);
        Thread hiloobjeto1 = new Thread(hilos2);
        hiloobjeto1.setPriority(9);
        hiloobjeto1.setName("Raul");
        hiloobjeto1.start();
        hiloobjeto.setPriority(10);
        hiloobjeto.setName("Paco");
        hiloobjeto.start();
        System.out.println(hiloobjeto.isDaemon());
        
    }

    @Override
    public void run(){
        System.out.println("Mensaje de hilo, " + new Date() + Thread.currentThread());
        for(int i=0; i<1000; i++){
            System.out.println(Thread.currentThread());
           
        }
    }
}
