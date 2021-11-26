package ejemploClienteServidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Socket del servidor para especificar el puerto por el que escucha.
            ServerSocket ss = new ServerSocket(5111);
            System.out.println("SERVIDOR ESCUCHANDO: ");

            // Creamos un Socket para aceptar la conexion con el ServerSocket
            Socket socket = ss.accept();
            System.out.println("CLIENTE ACEPTADO.");

            // Creamos un DataInputStream y un OutputStream, para la entrada y salida de datos.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            // Mensaje va a leer la entrada del DataInputStream, y con readUTF puede leer texto.
            String mensajeRecibido = entrada.readUTF();
            System.out.println("MENSAJE de Client: " + mensajeRecibido);
            System.out.println("RESPUESTA ENVIADA.");
            
            // Mensaje que sale del servidor hacia el cliente.
            salida.writeUTF("Mensaje recibido.");

            // IMPORTANTE cerrar todos los recursos que no vamos a utilizar mas, entrada,salida, el socket, y si vamos a finalizar el servidor, ServerSocket.close
            entrada.close();
            salida.close();
            socket.close();
            ss.close();
            System.out.println("SERVIDOR CERRADO.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
