package com.practica;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableThread {
    public static void main(String[] args) {
        Actividades actividad = new Actividades();
        ExecutorService ejecutor = Executors.newSingleThreadExecutor();
        Runnable tarea = () -> {
            try{
                actividad.numeros();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        };

        ejecutor.submit(tarea);
        ejecutor.shutdown();
    }
}
