import java.util.ArrayList;
import java.util.List;

// Clase para instanciar nuestro objeto Leer, y ejecutar.
public class Principal {
    public static void main(String[] args) {
        
        // Creamos una lista lectores para guardar nuestros Hilos que van a leer.
        List <Leer> lectores = new ArrayList<Leer>();
        // Instanciamos un nuevo Archivo.
        Archivo arch = new Archivo();
        lectores.add(new Leer("Raul", arch));
        lectores.add(new Leer("Maria", arch));
        lectores.add(new Leer("Paquito", arch));
        lectores.add(new Leer("Julio", arch));
        // Recorremos la lista e iniciamos cada hilo.
        for (Leer l : lectores) {
            l.start();
        }
    }
}
