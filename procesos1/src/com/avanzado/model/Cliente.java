package com.avanzado.model;

import com.basico.Hijo;

public class Cliente {
    private int id;
    private String nombre;
    private int unidades;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();  // Establecemos que el nombre siempre se escriba con mayusculas.
    }
    public int getUnidades() {
        return unidades;
    }
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}


