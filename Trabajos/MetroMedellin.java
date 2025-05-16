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
    public static boolean esOncePM = false;
    public static final Object inicioLock = new Object();
    public static final Object oncePMLock = new Object();
    public static final Object sanAntonioBLock = new Object();
    public static boolean sanAntonioBOcupada = false;

    public static class Tren extends Robot implements Runnable {
        private String destino;
        private Color color;
        private int trenId;
        private int posCalle;
        private int posAvenida;
        private static final int TIEMPO_ESPERA_ESTACION = 3000; // 3 segundos en milisegundos
        private boolean volviendoAlTaller = false; // Nueva variable para controlar si está volviendo al taller

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
                System.out.println("Tren líder " + trenId + " esperando instrucción para iniciar...");
            }

            // TODOS los trenes esperan la señal global
            synchronized (MetroMedellin.inicioLock) {
                while (!MetroMedellin.inicioRecorridos) {
                    try { MetroMedellin.inicioLock.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }

            boolean esOncePM = false;
            // Bucle principal de recorridos hasta las 11 PM
            while (!esOncePM) {
                // Verificar si es 11 PM antes de cada recorrido
                synchronized (MetroMedellin.oncePMLock) {
                    esOncePM = MetroMedellin.esOncePM;
                }

                if (esOncePM) {
                    System.out.println("Tren " + trenId + " recibió señal de 11 PM. Volviendo al taller.");
                    volviendoAlTaller = true; // Marcar que está volviendo al taller
                    // Volver al taller según el destino actual
                    if (destino.equals("Niquia")) {
                        Rutas.volverAlTallerDesdeNiquia(this);
                    } else if (destino.equals("Estrella")) {
                        Rutas.volverAlTallerDesdeEstrella(this);
                    } else if (destino.equals("SanJavier")) {
                        Rutas.volverAlTallerDesdeSanJavier(this);
                    }
                    break;
                }

                // Realizar el recorrido normal según el destino
                if (destino.equals("Niquia")) {
                    Rutas.rutaNiquia(this);
                } else if (destino.equals("Estrella")) {
                    Rutas.rutaEstrella(this);
                } else if (destino.equals("SanJavier")) {
                    Rutas.rutaSanJavier(this);
                }
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
            while (posCalle != 32 || posAvenida != 16) {
                // Intentar moverse hacia adelante primero
                if (frontIsClear()) {
                    moveSafe();
                    continue;
                }
                
                // Si no puede ir adelante, intentar izquierda
                turnLeft();
                if (frontIsClear()) {
                    moveSafe();
                    continue;
                }
                
                // Si no puede ir a la izquierda, volver a la dirección original e intentar derecha
                turnRight();
                turnRight();
                if (frontIsClear()) {
                    moveSafe();
                    continue;
                }
                
                // Si no puede ir a ningún lado, volver a la dirección original y esperar
                turnLeft();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        

        public int getTrenId() {
            return trenId;
        }

        public int getPosCalle() {
            return posCalle;
        }

        public int getPosAvenida() {
            return posAvenida;
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

        public void moveSafe() {
            int nextCalle = posCalle;
            int nextAvenida = posAvenida;

            // Calcula la siguiente posición
            if (facingNorth()) nextCalle++;
            else if (facingSouth()) nextCalle--;
            else if (facingEast()) nextAvenida++;
            else if (facingWest()) nextAvenida--;

            // Caso especial para San Antonio B
            // Si estamos en (13,12) y queremos ir a (13,13)
            if (posCalle == 13 && posAvenida == 12 && nextCalle == 13 && nextAvenida == 13) {
                synchronized (sanAntonioBLock) {
                    while (sanAntonioBOcupada) {
                        try {
                            System.out.println("Tren " + trenId + " esperando en (13,12) porque San Antonio B está ocupada");
                            sanAntonioBLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sanAntonioBOcupada = true;
                }
            }

            // Si estamos en San Antonio B y vamos a salir
            if (posCalle == 14 && posAvenida == 15) {
                synchronized (sanAntonioBLock) {
                    sanAntonioBOcupada = false;
                    sanAntonioBLock.notifyAll();
                }
            }

            // Espera hasta que la posición esté libre y la reserva
            while (!Tren.reservarPosicion(this.trenId, nextCalle, nextAvenida)) {
                try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
            }

            // Si estamos en una estación y el recorrido ha iniciado y NO estamos volviendo al taller, esperamos aquí
            if (esEstacion(posCalle, posAvenida) && MetroMedellin.inicioRecorridos && !volviendoAlTaller) {
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
