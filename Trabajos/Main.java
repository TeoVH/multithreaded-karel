import kareltherobot.*;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        World.readWorld("MetroMedellin.kwld");
        World.setVisible(true);
        World.setDelay(10);

        MetroMedellin.Tren trenNiquia = new MetroMedellin.Tren(32, 15, Directions.East, 0, "Niquia", Color.RED);
        MetroMedellin.Tren trenEstrella = new MetroMedellin.Tren(32, 14, Directions.East, 0, "Estrella", Color.BLUE);
        MetroMedellin.Tren trenSanJavier = new MetroMedellin.Tren(33, 14, Directions.South, 0, "SanJavier", Color.GREEN);

        Thread hiloNiquia = new Thread(trenNiquia);
        Thread hiloEstrella = new Thread(trenEstrella);
        Thread hiloSanJavier = new Thread(trenSanJavier);

        hiloNiquia.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hiloEstrella.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hiloSanJavier.start();
    }
}
