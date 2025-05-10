import kareltherobot.*;
import java.awt.Color;
import java.util.concurrent.CyclicBarrier;

public class MetroMedellin implements Directions {

    // Matriz 2D para representar el mundo y conocer qué trenes están en cada posición
    // Tamaño del mundo
    public static final int avenida = 21;
    public static final int calle = 36;

    // Matriz de ocupación de trenes: 0 = vacío, > 0 = trenId
    public static int[][] ocupacion = new int[calle+1][avenida+1];
    public static final Object lock = new Object();

    // Variables para controlar el recorrido de los trenes
    // public static CyclicBarrier barreraInicio;
    public static boolean inicioRecorridos = false;
    public static final Object inicioLock = new Object();

    public static class Tren extends Robot implements Runnable {
        private String destino;
        private Color color;
        private int trenId;
        private int posCalle;
        private int posAvenida;
        private static final int TIEMPO_ESPERA_ESTACION = 3000; // 3 segundos en milisegundos

        // Coordenadas de las estaciones
        private static final int[][] ESTACIONES = {
            // Linea A
            {35, 19}, {34, 19}, // Niquía
            {31, 16}, {31, 17},
            {27, 15}, {27, 16},
            {24, 13}, {24, 14},
            {20, 11}, {20, 12},
            {19, 14}, {18, 14},
            {16, 16}, {16, 17},
            {14, 16}, {14, 17},
            {12, 16}, {12, 17},
            {11, 15}, {10, 15},
            {9, 13}, {9, 14},
            {6, 13}, {6, 14},
            {3, 12}, {3, 13},
            {2, 11}, {1, 11}, // Estrella
            
            // Linea B
            {16, 1}, {16, 2}, // San Javier
            {15, 5}, {14, 5},
            {14, 9}, {13, 9},
            {14, 12}, {13, 12},
            {14, 15} // San Antonio B
        };

        public Tren(int trenId, int street, int avenue, Direction direction, int beeps, Color color, String destino) {
            super(street, avenue, direction, beeps, color);
            this.trenId = trenId;
            this.destino = destino;
            this.color = color;
            this.posCalle = street;
            this.posAvenida = avenue;
            World.setupThread(this);
        }

        @Override
        public void run() {
            System.out.println("Tren " + trenId + " creado en calle " + posCalle + " y avenida " + posAvenida);

            // Salida del taller hasta la estación extrema según destino
            navegarHastaSalida();
            if (destino.equals("Niquia")) {
                Rutas.IrANiquia(this);
            } else if (destino.equals("Estrella")) {
                Rutas.IrAEstrella(this);
            } else if (destino.equals("SanJavier")) {
                Rutas.IrASanJavier(this);
            }

            // Esperamos a que todos los líderes lleguen a sus estaciones
            if (esTrenLider()) {
                // try {
                //     MetroMedellin.barreraInicio.await();
                //     // Cuando todos los líderes llegan, activamos el inicio de recorridos
                //     synchronized (MetroMedellin.inicioLock) {
                //         MetroMedellin.inicioRecorridos = true;
                //         MetroMedellin.inicioLock.notifyAll();
                //     }
                // } catch (Exception e) {
                //     e.printStackTrace();
                // }
                System.out.println("Tren líder " + trenId + " esperando instrucción para iniciar...");
            }

            // TODOS los trenes esperan la señal global
            synchronized (MetroMedellin.inicioLock) {
                while (!MetroMedellin.inicioRecorridos) {
                    try { MetroMedellin.inicioLock.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }

            // Inicio del recorrido principal
            if (destino.equals("Niquia")) {
                Rutas.rutaNiquia(this);
                Rutas.rutaNiquia(this);
            } else if (destino.equals("Estrella")) {
                Rutas.rutaEstrella(this);
                Rutas.rutaEstrella(this);
            } else if (destino.equals("SanJavier")) {
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
                        moveSafe();
                    }
                } else if (frontIsClear()) {
                    moveSafe();
                } else {
                    turnRight();
                }
            }
        }
        

        public int getTrenId() {
            return trenId;
        }

        public static boolean reservarPosicion(int trenId, int calle, int avenida) {
            if (calle < 1 || calle > 36 || avenida < 1 || avenida > 21) {
                System.out.println("Intento de reservar de " + trenId + " fuera de límites: (" + calle + ", " + avenida + ")");
                return false;
            }
            synchronized (lock) {
                if (ocupacion[calle][avenida] == 0) {
                    ocupacion[calle][avenida] = trenId;
                    System.out.println("Tren " + trenId + " reservó posición (" + calle + ", " + avenida + ")");
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

        private boolean esEstacion(int calle, int avenida) {
            for (int[] estacion : ESTACIONES) {
                if (estacion[0] == calle && estacion[1] == avenida) {
                    return true;
                }
            }
            return false;
        }

        private void esperarEnEstacion() {
            if (esEstacion(posCalle, posAvenida) && MetroMedellin.inicioRecorridos) {
                System.out.println("Tren " + trenId + " detenido en estación (" + posCalle + ", " + posAvenida + ")");
                try {
                    // Mantenemos la posición reservada durante la espera
                    Thread.sleep(TIEMPO_ESPERA_ESTACION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Tren " + trenId + " continuando desde estación (" + posCalle + ", " + posAvenida + ")");
            }
        }

        public void moveSafe() {
            int nextCalle = posCalle;
            int nextAvenida = posAvenida;

            // Calcula la siguiente posición
            if (facingNorth()) nextCalle++;
            else if (facingSouth()) nextCalle--;
            else if (facingEast()) nextAvenida++;
            else if (facingWest()) nextAvenida--;

            // Espera hasta que la posición esté libre y la reserva
            while (!Tren.reservarPosicion(this.trenId, nextCalle, nextAvenida)) {
                try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
            }

            // Si estamos en una estación y el recorrido ha iniciado, esperamos aquí
            if (esEstacion(posCalle, posAvenida) && MetroMedellin.inicioRecorridos) {
                System.out.println("Tren " + trenId + " detenido en estación (" + posCalle + ", " + posAvenida + ")");
                try {
                    Thread.sleep(TIEMPO_ESPERA_ESTACION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Tren " + trenId + " continuando desde estación (" + posCalle + ", " + posAvenida + ")");
            }

            // Libera la posición actual
            Tren.liberarPosicion(posCalle, posAvenida);

            // Actualiza la posición interna
            posCalle = nextCalle;
            posAvenida = nextAvenida;

            // Mueve el robot físicamente
            move();
        }

        // Método para identificar tren líder (ajusta la lógica según tu inicialización)
        public boolean esTrenLider() {
            // Primeros trenes creados para cada destino
            return trenId == 1 || trenId == 8 || trenId == 23;
        }
    }
}
