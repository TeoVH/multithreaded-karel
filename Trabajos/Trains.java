import kareltherobot.*;
import java.awt.Color;

public class Trains implements Directions {
    public static void main(String [] args) {
        // Read the world Metro Medellín
        World.readWorld("MetroMed.kwld");
        World.setVisible(true);
    }
}