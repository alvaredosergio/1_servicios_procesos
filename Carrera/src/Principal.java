import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Corredor c1 = new Corredor("Raul");
        Corredor c2 = new Corredor("Paco");
        Corredor c3 = new Corredor("Maria");
        Corredor c4 = new Corredor("Julian");
        Corredor c5 = new Corredor("Jose");

        List <Correr> corredores = new ArrayList <Correr>();
        Posicion pos = new Posicion();

        corredores.add(new Correr(c1,100,pos));
        corredores.add(new Correr(c2,100,pos));
        corredores.add(new Correr(c3,100,pos));
        corredores.add(new Correr(c4,100,pos));
        corredores.add(new Correr(c5,100,pos));

        Carrera car = new Carrera(corredores);
        car.start();
        try {
            car.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Correr correr : corredores) {
            System.out.println(correr.getCorredor().getNombre() + " " + correr.getCorredor().getLugar());
        }
    }
}
