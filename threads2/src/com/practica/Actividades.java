package com.practica;

import java.util.StringTokenizer;

public class Actividades {
    public static void main(String[] args) {
        numeros(); 
        contarPalabras("Hola que tal estas");
        bisiesto(1900);  
    }

    public static void numeros(){
        for(int i = 1; i < 11; i++){
            System.out.print(i + " ");
        }
        System.out.println();   
    } 
    
    public static void contarPalabras(String palabra){
        StringTokenizer stringTokenizer1 = new StringTokenizer(palabra);
        int contador  = stringTokenizer1.countTokens();
        System.out.println("La cadena tiene " + String.valueOf(contador) + " palabra/s.");
    }

    public static void bisiesto(int anio){
        if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
	        System.out.println("El año " + anio + "es bisiesto.");
        }
        else{
	        System.out.println("El año " + anio + " NO es bisiesto.");
        }
    }
}






















//tres metodos 
// 1. priemros 10 numeros
// 2. String, y contar cuantas palabras hay, (separadas por espacios)
// 3. Le pasas año, dice si es bisiesto

// Crear clase con hilos para llamar al 1. metodo. SimpleThread
// Crear clase con hilos(Executor) para llamar al 2.metodo. Runnable
// Crear clase de hilos(Executor) para llamar al 3.metodo. Callable