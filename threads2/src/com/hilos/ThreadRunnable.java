package com.hilos;

import java.time.Duration;
import java.time.Instant;

public class ThreadRunnable {

    //Declaramos una variable de entorno.
    private static final Instant INICIO = Instant.now();
    
    public static void main(String[] args) {
        System.out.println(INICIO);

        Runnable tarea = () -> {
            try{
                Log("Empieza la tarea.");
                Thread.sleep(5000);
                Log("Termina la tarea.");
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        };

        Thread thread1 = new Thread(tarea);
        Thread thread2 = new Thread(tarea);
        thread1.start();
        thread2.start();
    }

    //Método para pintar el LOG de la duración de cada Hilo.
    private static void Log(String mensaje) {
        System.out.println(Duration.between(INICIO, Instant.now()) + mensaje);
	}

}
