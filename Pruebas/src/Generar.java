import java.util.ArrayList;
import java.util.List;

public class Generar extends Thread {
    Paquete paquete;
    boolean activo;

    int peq;
    int med;
    int gran;

    public Generar() {
        this.activo = true;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    

    public int getPeq() {
        return peq;
    }

    public void setPeq(int peq) {
        this.peq = peq;
    }

    public int getMed() {
        return med;
    }

    public void setMed(int med) {
        this.med = med;
    }

    public int getGran() {
        return gran;
    }

    public void setGran(int gran) {
        this.gran = gran;
    }

    static String reset = "\u001B[0m";
    static String red = "\u001B[31m";
    static String green = "\u001B[32m";
    static String yellow = "\u001B[33m";

    @Override
    public void run() {
        while(activo){
            List <Paquete> paquetes = new ArrayList<Paquete>();
            paquetes.add(new Paquete());
            for(Paquete p : paquetes){
                if(p.altura <= 3){
                    peq++;
                    System.out.println(green + "PEQUEÑO: " + peq + reset);
                    if(peq > 9){
                        try {
                            synchronized(paquetes){
                                wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if(p.altura >= 4 && p.altura <= 7){
                    med++;
                    System.out.println(yellow + "MEDIANO: " + med + reset);
                    if(med > 9){
                        try {
                            synchronized(p){
                                wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    gran++;
                    System.out.println(red + "GRANDE: " + gran + reset);
                    if(gran > 9){
                        try {
                            synchronized(paquetes){
                                wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }  
}
