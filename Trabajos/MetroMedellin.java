import kareltherobot.*;
import java.awt.Color;

public class MetroMedellin implements Directions {

    public static class Tren extends Robot implements Runnable {
        private String destino;
        private Color color;

        public Tren(int street, int avenue, Direction direction, int beeps, Color color, String destino) {
            super(street, avenue, direction, beeps, color);
            this.destino = destino;
            this.color = color;
            World.setupThread(this);
        }

        @Override
        public void run() {
            navegarHastaSalida();

            // Lógica de rutas delegada a clase Rutas
            if (destino.equals("Niquia")) {
                Rutas.IrANiquia(this);
                Rutas.rutaNiquia(this);
            } else if (destino.equals("Estrella")) {
                Rutas.IrAEstrella(this);
                Rutas.rutaEstrella(this);
            } else if (destino.equals("SanJavier")) {
                Rutas.IrASanJavier(this);
                Rutas.rutaSanJavier(this);
            }
        }

        // Métodos auxiliares
        public void turnRight() {
            turnLeft(); turnLeft(); turnLeft();
        }

        public boolean leftIsClear() {
            turnLeft();
            boolean isClear = frontIsClear();
            turnRight();
            return isClear;
        }

        public void navegarHastaSalida() {
            while (!(leftIsClear() && frontIsClear())) {
                if (leftIsClear()) {
                    turnLeft();
                    if (frontIsClear()) {
                        move();
                    }
                } else if (frontIsClear()) {
                    move();
                } else {
                    turnRight();
                }
            }
        }
    }

    // World configuration
    static {
        World.readWorld("MetroMedellin.kwld");
        World.setVisible(true);
        World.setDelay(10);
    }

    public static void main(String[] args) {

        Tren trenNiquia = new Tren(34, 6, East, 0, Color.red, "Niquia");
        Tren trenEstrella = new Tren(32, 14, East, 0, Color.blue, "Estrella");
        Tren trenSanJavier = new Tren(33, 14, South, 0, Color.green, "SanJavier");

        Thread hiloNiquia = new Thread(trenNiquia);
        Thread hiloEstrella = new Thread(trenEstrella);
        Thread hiloSanJavier = new Thread(trenSanJavier);

        hiloNiquia.start();
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e){}
        
        hiloEstrella.start();
        try { 
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        
        hiloSanJavier.start();
    }
}
