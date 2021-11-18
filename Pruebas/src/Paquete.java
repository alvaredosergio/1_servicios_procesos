public class Paquete {
    int altura;

    public Paquete() { 
        this.altura =  (int)(Math. random()*10+1);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Paquete [altura=" + altura + "]";
    }

}
