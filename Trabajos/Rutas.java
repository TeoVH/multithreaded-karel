public class Rutas {
    // Coordenadas de los cruces importantes
    private static final int[][] CRUCES = {
        {33, 16}, // Cruce taller
        {18, 11}, // Entrada línea C
        {14, 11}   // Entrada línea C
    };

    private static boolean esCruce(int calle, int avenida) {
        for (int[] cruce : CRUCES) {
            if (cruce[0] == calle && cruce[1] == avenida) {
                return true;
            }
        }
        return false;
    }

    private static void esperarEnCruce(MetroMedellin.Tren t) {
        if (esCruce(t.getPosCalle(), t.getPosAvenida())) {
            System.out.println("Tren " + t.getTrenId() + " esperando en cruce (" + t.getPosCalle() + ", " + t.getPosAvenida() + ")");
            try {
                Thread.sleep(1000); // Espera 1 segundo en el cruce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void IrANiquia(MetroMedellin.Tren t) {
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
    }

    public static void rutaNiquia(MetroMedellin.Tren t) {
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        esperarEnCruce(t);
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
    }

    public static void IrAEstrella(MetroMedellin.Tren t) {

        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
    }

    public static void rutaEstrella(MetroMedellin.Tren t) {
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        esperarEnCruce(t);
        t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
    }

    public static void IrASanJavier(MetroMedellin.Tren t) {
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
    }

    public static void rutaSanJavier(MetroMedellin.Tren t) {
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnRight();
        t.moveSafe();
        esperarEnCruce(t);
        // San Antonio B
        t.turnLeft(); t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
    }

    public static void volverAlTallerDesdeNiquia(MetroMedellin.Tren t) {
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.navegarHastaSalida();
        t.turnLeft();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.turnLeft();
    }

    public static void volverAlTallerDesdeEstrella(MetroMedellin.Tren t) {
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.navegarHastaSalida();
        t.turnLeft();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.turnLeft();
    }

    public static void volverAlTallerDesdeSanJavier(MetroMedellin.Tren t) {
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe();
        t.navegarHastaSalida();
        t.turnLeft();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.turnLeft();
    }
}
