import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

// ESTE PROGRAMA ABRE EL CMD, HACE PING EN GOOGLE.ES, E INTRODUCE LOS DATOS EN UN ARCHIVO TXT 'ARCHIVO.TXT'
public class Principal {
    public static void main(String[] args) throws Exception {

        ProcessBuilder pb = new ProcessBuilder("cmd","/c","D:/Users/Campus FP/Desktop/program.bat");
        File f = new File("archivo.txt");
        pb.redirectOutput(f);
        try {  
            Process pro = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
      
            }  
            pro.waitFor();
        } catch (IOException e) {
        }        
    }
}
