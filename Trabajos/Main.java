import kareltherobot.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Main {
    // World configuration
    static {
        World.readWorld("MetroMedellin.kwld");
        World.setVisible(true);
        World.setDelay(10);
        // Desactivar mensajes de estado del robot
        World.setTrace(false);
    }

    public static void main(String[] args) {

        // MetroMedellin.barreraInicio = new CyclicBarrier(3);

        List<Thread> hilos = new ArrayList<>();
        int trenId = 1;
        
        // 7 trenes a Niquia
        hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 32, 15, Directions.East, 0, Color.BLUE, "Niquia")));

        for (int i = 0; i < 3; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 32 + i, 14, Directions.South, 0, Color.BLUE, "Niquia")));
        }

        for (int i = 3; i > 0; i--) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 34, 10+i, Directions.East, 0, Color.BLUE, "Niquia")));
        }

        // 15 trenes a Estrella
        for (int i = 9; i > 0; i--) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 34, 1 + i, Directions.East, 0, Color.BLUE, "Estrella")));
        }

        hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 34, 1, Directions.South, 0, Color.BLUE, "Estrella")));

        for (int i = 0; i < 5; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 35, 1 + i, Directions.West, 0, Color.BLUE, "Estrella")));
        }

        // 10 trenes a San Javier
        for (int i = 0; i < 9; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 35, 6 + i, Directions.West, 0, Color.GREEN, "SanJavier")));
        }
        
        hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 35, 15, Directions.North, 0, Color.GREEN, "SanJavier")));


        // Iniciamos todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperamos a que el usuario presione Enter para iniciar los recorridos
        System.out.println("\nPresione Enter para iniciar los recorridos de los trenes...");
        new java.util.Scanner(System.in).nextLine();

        // Activamos el inicio de recorridos
        synchronized (MetroMedellin.inicioLock) {
            MetroMedellin.inicioRecorridos = true;
            MetroMedellin.inicioLock.notifyAll();
        }

        // Esperamos la señal de las 11 PM
        System.out.println("\nPresione Enter cuando sean las 11 PM para finalizar la operación...");
        new java.util.Scanner(System.in).nextLine();

        // Activamos la señal de las 11 PM
        synchronized (MetroMedellin.oncePMLock) {
            MetroMedellin.esOncePM = true;
            // System.out.println("Se ha activado la señal de las 11 PM. Los trenes completarán su recorrido actual y finalizarán.");
        }

        // Esperamos a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
