import kareltherobot.*;
import java.awt.Color;

public class MetroMedellin implements Directions {

    public static class Tren extends Robot implements Runnable {
        private String destino;
        private Color color;

        public Tren(int street, int avenue, Direction direction, int beeps, String destino, Color color) {
            super(street, avenue, direction, beeps);
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
}
