import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","program.bat");
        File f = new File("archivo.txt");
        pb.redirectOutput(f);

        try {  
            Process pro = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);  
            }  
        } catch (IOException e) {
        }


        ProcessBuilder pb1 = new ProcessBuilder("cmd","/c","program.bat");
        try {
            Process pro1 = pb1.start();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(pro1.getInputStream()));
            String line1;
            
            int cont = 0;

            System.out.println("Estos son los numeros que superan 30000: ");
            while(!(line1 = br1.readLine()).equals(".")){

                if(Integer.parseInt(line1) > 30000){
                    cont++;
                    System.out.println(line1);
                }
            }
            System.out.println("Total de numeros: " + cont);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
