import java.io.IOException;

public class ex03 {
    public static void main(String[] args) {
        abrirNotepad(10000);  
    }

    public static void abrirNotepad(int x){
        for (int i = 1; i <= x; i++) {
            ProcessBuilder pb = new ProcessBuilder("notepad");
            try {
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
