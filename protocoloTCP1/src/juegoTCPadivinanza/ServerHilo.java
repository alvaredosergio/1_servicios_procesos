package juegoTCPadivinanza;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerHilo extends Thread {
    private Socket socket;
    private Juego juego;

    public ServerHilo(Socket socket, Juego juego) {
        this.socket = socket;
        this.juego = juego;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            String jugador = entrada.readUTF();
            System.out.println("Jugador conectado: " + jugador);
            juego.cant++;
            if(juego.cant>10){
                
            }
            synchronized(juego){
                juego.wait();
            }
            salida.writeUTF("Juego iniciado.");


            boolean ganador = false;

            while (true) {
                synchronized(juego){
                    if(!juego.isFin()){
                        int num = entrada.readInt();
                        if(num < juego.getNumeroAdivinar()){
                            salida.writeUTF("El numero es mayor.");
                        }else if (num < juego.getNumeroAdivinar()){
                        salida.writeUTF("El numero es menor.");
                        }else{
                            salida.writeUTF("Felicidades, has ganado.");
                            juego.setFin(true);
                            ganador = true;
                        }
                    }else{
                        break;
                    }
                }
                sleep(3000);
                salida.writeBoolean(juego.isFin());
            }
            
            if(ganador){
                salida.writeUTF("Juego termiando.");
                System.out.println(jugador + " ha ganado");
            }else{
                salida.writeUTF("Has perdido,\nJuego terminado.");
            }

            entrada.close();
            salida.close();
            socket.close();

        } catch (Exception e) {
        }
        
    }
    
}
