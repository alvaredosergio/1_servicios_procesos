package juegoTCPadivinanza;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerJuego {
    public static void main(String[] args) {
        Juego juego = new Juego(new Random().nextInt(100)+1);
        try {
            ServerSocket ss = new ServerSocket(5111);
            int jugadores = 0;
            while (true) {
                Socket socket = ss.accept();
                ServerHilo sh = new ServerHilo(socket,juego);
                sh.start();
                jugadores++;
                System.out.println(jugadores);
                

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
