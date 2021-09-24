package com.basico;

import java.util.Date;

public abstract class Padre {

    private String nombre;
    private int unidades;
    private boolean descuento;
    private Date fecha;

    public void saludar() {
        System.out.println("saludando");
    }

    protected void escribir() {
        System.out.println("escribiendo");
    }

    private void leer() {
        System.out.println("leyendo");
    }

    public String comunicar(){
        return "estoy comunicando";
    }

    public int sumar(int x, int y){
        return x + y;
    }
}




