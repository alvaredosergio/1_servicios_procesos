// La clase Archivo tiene como atributo estado, para saber en que estado se encuentra el Archivo, para poder ser leido o no.
public class Archivo {
    private int estado;

    // Constructor
    public Archivo() {
        super();
        // Archivo establecemos en 1, osea, se puede leer.
        this.estado = 1;
    }

    // Getters and setters
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
