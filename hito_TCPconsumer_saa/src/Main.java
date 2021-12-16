import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[36m";
    public static final String reset = "\u001B[0m";
    public static final String green = "\u001B[32m";
    public static final String red = "\u001B[31m";

    // edition.cnn.com  /EVENTS/1996/year.in.review/
    // resort.com       /~banshee/Misc/8ball/index.html
    // home.mcom.com    /home/welcome.html

    public static void main(String[] args) throws Exception {
        try {
            System.out.print("\033[H\033[2J");
            System.out.println(blue + "· BIENVENIDO AL ANALIZADOR DE PÁGINAS WEB ·" + reset);
            System.out.println("¿Que página desea analizar? (la URL debe estar correctamente escrita, sin protocolo HTTPS) \nEjemplos:");
            System.out.println("- "+yellow+"edition.cnn.com/EVENTS/1996/year.in.review/"+reset);
            System.out.println("- "+yellow+"resort.com/~banshee/Misc/8ball/index.html"+reset);
            System.out.println("- "+yellow+"home.mcom.com/home/welcome.html"+reset);
            System.out.println("------------------------------------------------------------------------------------------");
            Scanner sc = new Scanner (System.in);
            String web = sc.nextLine();

            String [] partes;
            partes = web.split("/",2);

            // CREAMOS EL SOCKET Y EL BUFFEREDREADER
            Socket socket = new Socket(partes[0],80); 
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // CREAMOS LA PETICION EN FORMA DE STRING PARA PODER UTILIZARLO POSTERIORMENTE
            String peticion = "GET /"+partes[1]+" HTTP/1.1\r\n"
            + "Host: "+partes[0]+"\r\n";

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

            //MOSTRAR DATOS
            System.out.print("\033[H\033[2J");
            System.out.println("Página seleccionada: " + yellow + partes[0] + reset);
            System.out.println("------------------------------------\n");

            //LLAMADA A FUNCIONES
            mostrarTitulo(lineas);
            mostrarMetadatos(lineas);
            comprobarJSyCSS(lineas);
            mostrarEncabezados(lineas);
            contarEtiquetas(lineas);

            System.out.println();

            br.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(red+"LA URL INTRODUCIDA NO EXISTE, O NO ESTÁ ESCRITA CORRECTAMENTE."+reset);
        }
    }

    // 1. MOSTRAR TIUTLO DE LA PAGINA
    public static void mostrarTitulo(List <String> lineas) {
        List <String> metadatos = new ArrayList<String>();
            for (String li : lineas) {
                metadatos.add(li); 
            }
        String listToString = String.join("", metadatos);
        String patron = "<TITLE>.*?</TITLE>";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(listToString);
        while(matcher.find()){
            String titulo = matcher.group();
            titulo = titulo.replace("<TITLE>", "");
            titulo = titulo.replace("</TITLE>", "");
            System.out.println(blue + "Título: \t\t" + reset + titulo);
        }
    }

    // 2. METADATOS DE LA PÁGINA
    public static void mostrarMetadatos(List <String> lineas) {
        List <String> metadatos = new ArrayList<String>();
            for (String li : lineas) {
                metadatos.add(li); 
            }
        String listToString = String.join("", metadatos);
        listToString = listToString.toUpperCase();
        String patron = "<HEAD>.*?/HEAD>";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(listToString);
        if(matcher.find()){
            System.out.println(blue + "Metadatos: \t\t" + reset + matcher.group());
        }else{
            System.out.println(blue + "Metadatos: \t\t" + reset + "No contiene metadatos.");
        }
    }
    
    // 3. COMPROBAR SI TIENE JAVASCRIPT O CSS EXTERNO
    public static void comprobarJSyCSS(List <String> lineas) {
        List <String> metadatos = new ArrayList<String>();
            for (String li : lineas) {
                metadatos.add(li); 
            }
        String listToString = String.join("", metadatos);
        listToString = listToString.toUpperCase();
        String patron1 = "<SCRIPT.*?>";
        Pattern pattern1 = Pattern.compile(patron1);
        Matcher matcher1 = pattern1.matcher(listToString);
        if(matcher1.find()){
            System.out.println(blue + "JavaScript: \t\t" + reset  + green + "SI" + reset);
        }else{
            System.out.println(blue + "JavaScript: \t\t" + reset  + red + "NO" + reset);
        }
        String patron2 = "<LINK.*?>";
        Pattern pattern2 = Pattern.compile(patron2);
        Matcher matcher2 = pattern2.matcher(listToString);
        if(matcher2.find() == true){
            System.out.println(blue + "CSS: \t\t\t" + reset  + green + "SI" + reset);
        }else{
            System.out.println(blue + "CSS: \t\t\t" + reset  + red + "NO" + reset);
        }
    }

    // 4. ENCABEZADOS DE LA PÁGINA
    public static void mostrarEncabezados(List <String> lineas) {
        List <String> metadatos = new ArrayList<String>();
            for (String li : lineas) {
                metadatos.add(li); 
            }
        String listToString = String.join("", metadatos);
        listToString = listToString.toUpperCase();
        String patron = "<H[1-6].*?>";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(listToString);
        List <String> encabezados = new ArrayList<String>();

        while(matcher.find()){
            encabezados.add(matcher.group());
        }
        System.out.print(blue + "Encabezados: " + reset + "\t\t");
        for (String e : encabezados) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // 5. CONTADOR DE ETIQUETAS
    public static void contarEtiquetas(List <String> lineas) {
        List <String> metadatos = new ArrayList<String>();
            for (String li : lineas) {
                metadatos.add(li); 
            }
        String listToString = String.join("", metadatos);
        listToString = listToString.toUpperCase();
        String patron = "<P.*?>";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(listToString);
        int contador = 0;
        while(matcher.find() == true){
            contador++;
        }
        System.out.println(blue + "Nº etiquetas <p>: \t" + reset + contador);
    }
}
