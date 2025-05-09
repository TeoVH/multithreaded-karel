import kareltherobot.*;
import java.awt.Color;

public class MetroMedellin implements Directions {

    // Matriz 2D para representar el mundo y conocer qué trenes están en cada posición
    // Tamaño del mundo
    public static final int avenida = 21;
    public static final int calle = 36;

    // Matriz de ocupación de trenes: 0 = vacío, > 0 = trenId
    public static int[][] ocupacion = new int[calle+1][avenida+1];
    public static final Object lock = new Object();

    public static class Tren extends Robot implements Runnable {
        private String destino;
        private Color color;
        private int trenId;

        public Tren(int trenId, int street, int avenue, Direction direction, int beeps, Color color, String destino) {
            super(street, avenue, direction, beeps, color);
            this.trenId = trenId;
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
                // Rutas.rutaNiquia(this);
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

        public int getTrenId() {
            return trenId;
        }

        public static boolean reservarPosicion(int trenId, int calle, int avenida) {
            synchronized (lock) {
                if (ocupacion[calle][avenida] == 0) {
                    ocupacion[calle][avenida] = trenId;
                    return true;
                }
                return false;
            }
        }

        public static void liberarPosicion(int calle, int avenida) {
            synchronized (lock) {
                ocupacion[calle][avenida] = 0;
            }
        }

        public void moveSafe() {
            int nextCalle = this.street();
            int nextAvenida = this.avenue();

            // Calulamos la siguiente posición según la dirección actual
            if (facingNorth()) {
                nextCalle--;
            } else if (facingSouth()) {
                nextCalle++;
            } else if (facingEast()) {
                nextAvenida++;
            } else if (facingWest()) {
                nextAvenida--;
            }

            // Verificamos si la posición siguiente está ocupada y la reservamos
            while (!MetroMedellin.reservarPosicion(this.trenId, nextCalle, nextAvenida)) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Liberamos la posición actual
            MetroMedellin.liberarPosicion(this.street(), this.avenue());

            // Movemos el tren a la nueva posición
            this.move();

        }
    }
}
