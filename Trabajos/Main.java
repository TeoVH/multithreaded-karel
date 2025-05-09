import kareltherobot.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // World configuration
    static {
        World.readWorld("MetroMedellin.kwld");
        World.setVisible(true);
        World.setDelay(10);
    }

    public static void main(String[] args) {

        List<Thread> hilos = new ArrayList<>();
        int trenId = 1;
        
        // 7 trenes a Niquia
        hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 32, 15, Directions.East, 0, Color.RED, "Niquia")));

        for (int i = 0; i < 3; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 32 + i, 14, Directions.South, 0, Color.RED, "Niquia")));
        }

        for (int i = 0; i < 3; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 34, (11 + i), Directions.East, 0, Color.RED, "Niquia")));
        }

        // 15 trenes a Estrella
        for (int i = 0; i < 10; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 34, 1 + i, Directions.East, 0, Color.BLUE, "Estrella")));
        }

        for (int i = 0; i < 5; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 35, 1 + i, Directions.West, 0, Color.BLUE, "Estrella")));
        }

        // 10 trenes a San Javier
        for (int i = 0; i < 10; i++) {
            hilos.add(new Thread(new MetroMedellin.Tren(trenId++, 35, 6 + i, Directions.West, 0, Color.GREEN, "SanJavier")));
        }

        // for (Thread hilo : hilos) {
        //     hilo.start();
        //     try {
        //         Thread.sleep(500);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }
        
        

        // MetroMedellin.Tren trenNiquia = new MetroMedellin.Tren(35, 12, Directions.West, 0, Color.RED, "Estrella");
        // MetroMedellin.Tren trenEstrella = new MetroMedellin.Tren(34, 1, Directions.East, 0, Color.BLUE, "Estrella");
        // MetroMedellin.Tren trenSanJavier = new MetroMedellin.Tren(34, 7, Directions.East, 0, Color.GREEN, "Estrella");

        // Thread hiloNiquia = new Thread(trenNiquia);
        // Thread hiloEstrella = new Thread(trenEstrella);
        // Thread hiloSanJavier = new Thread(trenSanJavier);

        // hiloNiquia.start();
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // hiloEstrella.start();
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // hiloSanJavier.start();
    }
}
