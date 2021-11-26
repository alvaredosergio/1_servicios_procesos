package juegoTCPadivinanza;

public class Juego {
    private int numeroAdivinar;
    private boolean fin;
    public int cant;

    public Juego(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
        this.fin = false;
        this.cant = 0;
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }
      
}
