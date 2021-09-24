package com.basico;

public class Hijo extends Padre implements iTareas {

    // Esto es sobreescritura o Overriding.
    // Padre e hijo con diferente nombre, pero los argumentos son iguales.
    protected void escribir() {
        System.out.println("escribiendo el hijo");
    }

    // Esto es sobrecarga o Overload.
    // Diferentes argumentos, o los argumentos tienen diferente tipo.
    protected void escribir(String mensaje) {
        System.out.println("escribiendo el hijo");
    }

    @Override
    public void hito1(){

    }

    @Override
    public void examen1(){
        
    }

    @Override
    public void hito2(){
        
    }

    @Override
    public void hitogrupal(){
        
    }

    @Override
    public void examen2(){
        
    }
}


