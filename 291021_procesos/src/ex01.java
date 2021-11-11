import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex01 {
    public static void main(String[] args) throws Exception {

        ProcessBuilder pb = new ProcessBuilder("cmd","/c","ping google.es");
        try {
            Process pro = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }  
        } catch (IOException e) {

        }        
    }
}
