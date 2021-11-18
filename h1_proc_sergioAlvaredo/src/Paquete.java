import java.util.Random;

public class Paquete {
    private int codigo;
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
        int cod = r.nextInt(20000-10000) + 10000;

        this.codigo = cod;
        this.peso = Math.round(rPeso*10.0)/10.0;;
        this.volumen = Math.round(rVol*10.0)/10.0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return "Paquete [codigo=" + codigo + ", peso=" + peso + ", volumen=" + volumen + "]";
    }
}
