package com.hilos;

import java.lang.reflect.Executable;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableThreadPool {

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

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(tarea);
        executorService.submit(tarea);
        executorService.shutdown();
    }

    //Método para pintar el LOG de la duración de cada Hilo.
    private static void Log(String mensaje) {
        System.out.println(Duration.between(INICIO, Instant.now()) + mensaje);
	}

}
