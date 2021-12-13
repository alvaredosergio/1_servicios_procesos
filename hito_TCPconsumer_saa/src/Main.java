import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String reset = "\u001B[0m";
    public static void main(String[] args) throws Exception {
        try {
            System.out.print("\033[H\033[2J");
            System.out.println(yellow + "· BIENVENIDO AL ANALIZADOR DE PÁGINAS WEB ·" + reset);
            System.out.println("¿Que página desea analizar? (ejemplo: google.com, facebook.com, etc...)");
            System.out.println("-----------------------------------------------------------------------");
            // Scanner sc = new Scanner (System.in);
            // String web = sc.nextLine();
            // CREAMOS EL SOCKET Y EL BUFFEREDREADER
            Socket socket = new Socket("edition.cnn.com",80); 
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // CREAMOS LA PETICION EN FORMA DE STRING PARA PODER UTILIZARLO POSTERIORMENTE
            String peticion = "GET /EVENTS/1996/year.in.review/ HTTP/1.1\r\n"
            + "Host: edition.cnn.com\r\n";

            // PRINTWRITER PARA PODER ESCRIBIR
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

            // ESCRIBIMOS LA PETICION CON EL PRINTWRITER
            pw.println(peticion);

            // SI EL BUFFEREDREADER ESTÁ LISTO, RECORRE LINEA A LINEA EL HTML
            String line = "";
            List<String> lineas = new ArrayList<String>();

            while(true){
                if(br.ready()){
                    while(br.ready() && (line = br.readLine()) != null){
                        lineas.add(line);
                    }
                    break;
                }
            }

            for (String li : lineas) {
                if(li.contains("<TITLE>")){
                    
                }
            }

            br.close();
            pw.close();
            socket.close();
        } catch (Exception e) {

        }
    }
}
