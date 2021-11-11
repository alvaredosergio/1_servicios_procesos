package cliente;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
    
        try {
            byte buffer [] = new byte [1024];
            DatagramSocket socket = new DatagramSocket();
            String mensaje = "Hola.";
            buffer = mensaje.getBytes();
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 5111);
            System.out.println("Enviado paquete de datos...");
            socket.send(paquete);
            buffer = new byte [1024];
            paquete.setLength(1024);
            socket.receive(paquete);
            mensaje = new String(paquete.getData());
            System.out.println("Mensaje recibido: " + mensaje);
            socket.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
