package cronometro;

public class Prueba {
    public static void main(String[] args) {
        Cronometro crono1 = new Cronometro();
        crono1.start();

        ThreadMinutos minutos = new ThreadMinutos();
        minutos.start();

        ThreadSegundos segundos = new ThreadSegundos();
        segundos.start();

        ThreadMili milisegundos = new ThreadMili();
        milisegundos.start();

    }
}
