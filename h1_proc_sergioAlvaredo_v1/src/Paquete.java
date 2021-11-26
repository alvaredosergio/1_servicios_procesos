import java.util.Random;

public class Paquete {
    private int codigo;
    private double peso;
    private double volumen;
    
    // Constructor
    public Paquete() {
        double vol = Math.random()+0.1;
        if(vol > 1){
            vol = 1;
        }
        double pes = Math.random()*20.0 + 0.1;
        if(pes > 20.0){
            pes = 20.0;
        }
        Random r = new Random();
        int cod = r.nextInt(20000-10000) + 10000;

        this.codigo = cod;
        this.peso = Math.round(pes*10.0)/10.0;;
        this.volumen = Math.round(vol*10.0)/10.0;
    }

    public Paquete(String tipoPaquete) {
        switch(tipoPaquete){
            case "ligero":
                this.peso = (int)(Math.random()*5+0.1);
                this.volumen = (int)(Math.random()*0.5+0.1);
            break;
            case "pesado":
            this.peso = (int)(Math.random()*20+5);
            this.volumen = (int)(Math.random()*0.5+0.1);
            break;
            case "ultra":
            this.peso = (int)(Math.random()*20+0.1);
            this.volumen = (int)(Math.random()+0.5);
            break;
        }
        Random r = new Random();
        int cod = r.nextInt(20000-10000) + 10000;
        this.codigo = cod;
    }

    // Getters y setters
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

    // toString
    @Override
    public String toString() {
        return "Paquete [codigo=" + codigo + ", peso=" + peso + ", volumen=" + volumen + "]";
    }
}
