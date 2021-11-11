package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {

        // Creamos un array de buffer, definiendo el tamaño en bytes de lo que ocupara el mensaje aproximadamente.
        // Creamos el Socket para realizar nuestro envio de paquetes de info. Necesita de un try/catch por si el puerto ya está en uso.
        // Creamos un Paquete donde se recibira el buffer en bytes, de tamaño determinado por nuestro propio array buffer.

        try {
            byte buffer [] = new byte[1024];
            DatagramSocket socket = new DatagramSocket(5111);
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
            System.out.println("Esperando solicitud de conexión...");

            // El socket recibe el paquete.
            socket.receive(paquete);

            // Creamos un mensaje, para pasar la Data de bytes a String.
            String mensaje = new String(paquete.getData());

            // Mostramos el mensaje.
            System.out.println("Mensaje recibido: " + mensaje);
            mensaje = "Mensaje recibido con éxito.";

            // Pasamos el mensaje nuevo a bytes.
            buffer = mensaje.getBytes();

            // Creamos de nuevo el paquete que recibe el buffer, el tamaño del buffer, la dirección y el puerto a donde envian.
            paquete = new DatagramPacket(buffer, buffer.length, paquete.getAddress(), paquete.getPort());
            
            // Cerramos al fin el socket.
            socket.close();
            
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
