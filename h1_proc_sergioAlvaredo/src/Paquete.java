import java.util.Random;

public class Paquete {
    private int cBarras;
    private double peso;
    private double volumen;
    
    public Paquete() {
        double rVol = Math.random()+0.1;
        if(rVol > 1){
            rVol = 1;
        }
        double rPeso = Math.random()*20.0 + 0.1;
        if(rPeso > 20.0){
            rPeso = 20.0;
        }
        Random r = new Random();
        int rBar = r.nextInt(20000-10000) + 10000;

        this.cBarras = rBar;
        this.peso = Math.round(rPeso*10.0)/10.0;;
        this.volumen = Math.round(rVol*10.0)/10.0;
    }

    public int getcBarras() {
        return cBarras;
    }

    public void setcBarras(int cBarras) {
        this.cBarras = cBarras;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return "Paquete [cBarras=" + cBarras + ", peso=" + peso + ", volumen=" + volumen + "]";
    }
}
