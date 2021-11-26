package program;

import java.util.List;

public class Consumer extends Thread {
    private List<Integer> numbers;
    boolean activo;

    public Consumer(List<Integer> numbers) {
        this.numbers = numbers;
        this.activo = true;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public void run() {
        
    }
}
