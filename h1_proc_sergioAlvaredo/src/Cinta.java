public class Cinta {
    private int espacioLigero;
    private int espacioPesado;
    private int espacioUltraPesado;

    public Cinta() {
        this.espacioLigero = 0;
        this.espacioPesado = 0;
        this.espacioUltraPesado = 0;
    }

    public int getEspacioLigero() {
        return espacioLigero;
    }

    public void setSumarEspacioLigero(int espacioLigero) {
        this.espacioLigero = espacioLigero++;
    }

    public int getEspacioPesado() {
        return espacioPesado;
    }

    public void setSumarEspacioPesado(int espacioPesado) {
        this.espacioPesado = espacioPesado++;
    }

    public int getEspacioUltraPesado() {
        return espacioUltraPesado;
    }

    public void setSumarEspacioUltraPesado(int espacioUltraPesado) {
        this.espacioUltraPesado = espacioUltraPesado++;
    }

    

    
}
