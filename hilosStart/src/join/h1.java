package join;

public class h1 extends Thread {

    int numero;
    String nombre;

    public h1(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    @Override
    public void run(){
        for (int i = 0; i <= numero; i++) {
            System.out.println(nombre + " " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }        
    }
}
