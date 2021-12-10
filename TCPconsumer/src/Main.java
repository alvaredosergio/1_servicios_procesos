import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
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
            String linea = "";
            while(true){
                if(br.ready()){
                    while((linea = br.readLine()) != null){

                        // SI RECORRIENDO LINEA A LINEA, ENCUENTRA <TITLE>, CAMBIA LINEA POR EL TITULO PARA MOSTRARNOS EL TITULO SOLO
                        if(linea.contains("<TITLE>")){
                            linea = linea.trim();
                            linea = linea.replace("<TITLE>","");
                            linea = linea.replace("</TITLE>","");
                            System.out.println(linea);
                        }
                    }
                    break;
                }
            }
            br.close();
            pw.close();
            socket.close();
        } catch (Exception e) {

        }
    }
}
