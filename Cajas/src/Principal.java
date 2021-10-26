import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List <Integer> recursos = new ArrayList <Integer>();

        Extraer ex = new Extraer(recursos);
        Colocar co = new Colocar(recursos);

        ex.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        co.start();
    }
}
