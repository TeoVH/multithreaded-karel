import kareltherobot.*;
import java.awt.Color;

public class KarelFunc extends Robot {

    // Constructor básico
    public KarelFunc(int street, int avenue, Direction direction, int beeps) {
        super(street, avenue, direction, beeps);
    }

    // Constructor con color adicional
    public KarelFunc(int street, int avenue, Direction direction, int beeps, Color color) {
        super(street, avenue, direction, beeps, color);
    }

    // Gira a la izquierda
    public void turnLeft() {
        super.turnLeft();
    }

    // Gira a la derecha (tres giros a la izquierda)
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    // Gira 180 grados (dos giros a la izquierda)
    public void turnAround() {
        turnLeft();
        turnLeft();
    }

    // Mueve varios pasos
    public void moveMultiple(int steps) {
        for (int i = 0; i < steps; i++) {
            if (!checkForRobotNearby()) { // Verifica si hay otro robot cerca
                move();
            } else {
                System.out.println("Otro robot está cerca. Deteniéndose.");
                break; // Detiene el movimiento si hay un robot cerca
            }
        }
    }

    // Coloca un beeper
    public void placeBeeper() {
        putBeeper();
    }

    // Recoge un beeper
    public void pickBeeper() {
        pickBeeper();
    }

    // Verifica si hay otro robot cerca
    public boolean checkForRobotNearby() {
        // Obtiene la posición actual del robot
        int currentStreet = this.street();
        int currentAvenue = this.avenue();

        // Recorre todos los robots en el mundo
        for (Robot robot : World.getRobots()) {
            if (robot != this) { // Ignora al propio robot
                int robotStreet = robot.street();
                int robotAvenue = robot.avenue();

                // Verifica si el otro robot está en la misma posición o cerca (1 unidad de distancia)
                if (Math.abs(currentStreet - robotStreet) <= 1 && Math.abs(currentAvenue - robotAvenue) <= 1) {
                    return true; // Hay un robot cerca
                }
            }
        }
        return false; // No hay robots cerca
    }
}