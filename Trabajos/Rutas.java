public class Rutas {

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
        // Estación Estrella
        // Verificar si llegamos a una estación extrema y son las 11 PM
        if ((t.getPosCalle() == 35 && t.getPosAvenida() == 19) || (t.getPosCalle() == 1 && t.getPosAvenida() == 11)) {
            synchronized (MetroMedellin.oncePMLock) {
                if (MetroMedellin.esOncePM) {
                    // System.out.println("Tren " + t.getTrenId() + " llegó a estación extrema y son las 11 PM. Volviendo al taller.");
                    t.volviendoAlTaller = true;
                    return;
                }
            }
        }
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
        t.moveSafe(); t.moveSafe();
        t.turnRight();
        t.moveSafe(); t.moveSafe(); t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        t.turnLeft();
        t.moveSafe();
        // Estación Niquia
        
        // Verificar si llegamos a una estación extrema y son las 11 PM
        if ((t.getPosCalle() == 35 && t.getPosAvenida() == 19) || (t.getPosCalle() == 1 && t.getPosAvenida() == 11)) {
            synchronized (MetroMedellin.oncePMLock) {
                if (MetroMedellin.esOncePM) {
                    // System.out.println("Tren " + t.getTrenId() + " llegó a estación extrema y son las 11 PM. Volviendo al taller.");
                    t.volviendoAlTaller = true;
                    return;
                }
            }
        }
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
