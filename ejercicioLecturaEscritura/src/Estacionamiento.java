public class Estacionamiento {
    private int plazas;
    private int atenciones;

    public Estacionamiento() {
        this.plazas = 20;
        this.atenciones = 0;
    }

    public int getPlazas() {
        return plazas;
    }

    public int getAtenciones() {
        return atenciones;
    }

    public void liberarPlaza() {
        this.plazas = plazas++;
    }

    public void ocuparPlaza() {
        this.plazas = plazas--;
    }

    public void aumentarAtencion() {
        this.plazas = atenciones++;
    }
}
