package juegoTCPadivinanza;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientJuego {
    public static void main(String[] args) {
        try {
            // Creamos un socket para conectarse con la IP del servidor, y al puerto por el que escucha.
            Socket socket = new Socket("192.168.101.115", 5111);
            System.out.println("CONECTADO AL SERVIDOR DE LUISMI.");

            // Creamos los DataInput y Output para mandar y recibir mensajes.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            String red = "\u001B[31m";
            String green = "\u001B[32m";
            String yellow = "\u001B[33m";
            String blue = "\u001B[34m";
            String purple = "\u001B[35m";
            String reset = "\u001B[0m";

            System.out.println("Introduce su nombre: ");
            Scanner sc = new Scanner(System.in);
            salida.writeUTF(sc.nextLine());
            
            String mensaje = entrada.readUTF();
            System.out.println(mensaje);
            while (true) {
                System.out.println("Introduce un numero");
                salida.writeInt(Integer.parseInt(sc.nextLine()));
                mensaje = entrada.readUTF();
                System.out.println(mensaje);
                if(entrada.readBoolean()){
                    break;
                }
            }
            mensaje = entrada.readUTF();
            System.out.println(mensaje);
            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
