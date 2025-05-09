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
        World.setDelay(15);
    }

    public static void main(String[] args) {

        MetroMedellin.barreraInicio = new CyclicBarrier(3);

        List<Thread> hilos = new ArrayList<>();
        int trenId = 1;
        
        // 7 trenes a Niquia
        hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 32, 15, Directions.East, 0, Color.RED, "Niquia")));

        for (int i = 0; i < 3; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 32 + i, 14, Directions.South, 0, Color.RED, "Niquia")));
        }

        for (int i = 3; i > 0; i--) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 34, 10+i, Directions.East, 0, Color.RED, "Niquia")));
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


        for (Thread hilo : hilos) {
            hilo.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
