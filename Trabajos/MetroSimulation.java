import kareltherobot.*;
import java.awt.Color;

class Racer extends Robot { 
    public Racer(int Street, int Avenue, Direction direction, int beeps, Color color) {
        super(Street, Avenue, direction, beeps, color);
        World.setupThread(this);
    }
    
    // Overloaded constructor with optional color (default is Color.RED)
    public Racer(int Street, int Avenue, Direction direction, int beeps) {
        super(Street, Avenue, direction, beeps);
        World.setupThread(this);
    }

    public void race() {
        while(!nextToABeeper())
            move();
        pickBeeper();
        turnOff();
    }

    public void run() {
        race();
    }
}

public class MetroSimulation implements Directions {
    public static void main(String [] args) {
        // Read the world Metro Medellín
        World.readWorld("MetroMed.kwld");
        World.setVisible(true);

        Racer first = new Racer(35, 1, West, 0);
        Racer second = new Racer(35, 2, West, 0, Color.BLUE);
    }
}