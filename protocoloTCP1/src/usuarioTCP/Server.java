package usuarioTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Server {
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String reset = "\u001B[0m";
    public static final String cyan = "\u001B[36m";

    public static void main(String[] args) {
        try {
            // Socket del servidor para especificar el puerto por el que escucha.
            ServerSocket ss = new ServerSocket(5111);
            System.out.println("Servidor " + yellow + "ACTIVO" + reset +  ", esperando usuarios..." + reset);

            // Creamos un Socket para aceptar la conexion con el ServerSocket
            Socket socket = ss.accept();
            System.out.print("\033[H\033[2J");
            System.out.println(green +  "Usuario CONECTADO." + reset);

            // Creamos un DataInputStream y un OutputStream, para la entrada y salida de datos.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            // Mensaje va a leer la entrada del DataInputStream, y con readUTF puede leer texto.
            String mensajeRecibido = entrada.readUTF();
            System.out.println(cyan + "Usuario: " + reset + mensajeRecibido);

            while (true) {
                Scanner sc = new Scanner (System.in);
                salida.writeUTF(sc.nextLine());

                // Pintamos el mensaje.
                String mensaje = entrada.readUTF();

                System.out.println(cyan + "Usuario: " + reset + mensaje);
            }
            
            // IMPORTANTE cerrar todos los recursos que no vamos a utilizar mas, entrada,salida, el socket, y si vamos a finalizar el servidor, ServerSocket.close
            /*entrada.close();
            salida.close();
            socket.close();
            ss.close();
            System.out.println(red + "SERVIDOR CERRADO." + reset);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
