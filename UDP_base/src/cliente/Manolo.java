package cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Manolo extends Thread {
    static String nombre = "Manolo";
    private DatagramSocket socket;
	private DatagramPacket packet;

    

    public Manolo(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
    }

    @Override
    public void run() {
        while(true){
            byte [] buffer = new byte [1024];
            try {
                DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteRecibido);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, packet.getAddress(), packet.getPort());
            String mensaje = new String(paquete.getData());
            System.out.println(mensaje);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        try {
            byte buffer [] = new byte[1024];
            DatagramSocket socket = new DatagramSocket(5111);
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

            

            while (true) {
                String escribir = nombre + ": " + sc.nextLine();
                buffer = escribir.getBytes();
                DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length, paqueteInicial.getAddress(), paqueteInicial.getPort());
                socket.send(paqueteEnviado); 
            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
