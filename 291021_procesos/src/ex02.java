import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) throws IOException {
        while(true){
            System.out.println("Que URL desea comprobar: ");
            Scanner sc = new Scanner(System.in);
            String dec = sc.nextLine();

            ProcessBuilder pb = new ProcessBuilder("cmd","/c","ping " + dec);
            FileWriter fw = new FileWriter("urls.txt");
            try {
                Process pro = pb.start();
                BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
                String line;

                while ((line = br.readLine()) != null) {
                    if(line.contains("no pudo")){
                        System.out.println("LA URL NO EXISTE.");
                    }else{
                        System.out.println(line);
                        fw.write(dec);
                        fw.close();
                    }
                }
                System.out.println("-----------------------------------------------------------------------");  
            } catch (IOException e) {

            }
        } 
    }   
}
