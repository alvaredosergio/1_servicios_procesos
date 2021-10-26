package com.hilos;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class HilosCallable {

    //Declaramos una variable de entorno.
    private static final Instant INICIO = Instant.now();

    
    public static void main(String[] args) {
        System.out.println(INICIO.toString());

        Callable<String> tarea = () -> {
            try{
                Log("Empieza la tarea.");
                Thread.sleep(5000);
                Log("Termina la tarea.");
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            return "resultado del callable";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> futuro = executorService.submit(tarea);
        executorService.submit(tarea);
        executorService.submit(tarea);
        executorService.shutdown();
    }

    //Método para pintar el LOG de la duración de cada Hilo.
    private static void Log(String mensaje) {
        System.out.println(Duration.between(INICIO, Instant.now()) + mensaje);
	}

}

