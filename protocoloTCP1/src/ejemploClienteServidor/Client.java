package ejemploClienteServidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Creamos un socket para conectarse con la IP del servidor, y al puerto por el que escucha.
            Socket socket = new Socket("127.0.0.1", 5111);
            System.out.println("CONECTADO.");

            // Creamos los DataInput y Output para mandar y recibir mensajes.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            
            // Escribimos el mensaje al recibir conexion con el server.
            salida.writeUTF("Hola desde el cliente.");

            // Pintamos el mensaje.
            System.out.println("MENSAJE ENVIADO.");
            String mensaje = entrada.readUTF();
            System.out.println("RESPUESTA: " + mensaje);

            // Cerramos las conexiones.
            entrada.close();
            salida.close();
            socket.close();
            System.out.println("CLIENTE TERMINADO.");

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
