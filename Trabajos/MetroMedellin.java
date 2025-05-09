import kareltherobot.*;
import java.awt.Color;

public class MetroMedellin implements Directions {

    static class Tren extends Robot implements Runnable {
        private String destino;

        public Tren(int street, int avenue, Direction direction, int beeps, Color color, String destino) {
            super(street, avenue, direction, beeps, color);
            this.destino = destino;
            World.setupThread(this);
        }

        @Override
        public void run() {
            // Primera etapa: salir del taller hasta (32,16)
            navegarHastaSalida();

            // Lógica específica por destino
            if (destino.equals("Niquia")) {
                IrANiquia();
                // rutaNiquia();
            } else if (destino.equals("Estrella")) {
                IrAEstrella();
                // rutaEstrella();
            } else if (destino.equals("SanJavier")) {
                IrASanJavier();
                // rutaSanJavier();
            }
        }


        public void IrANiquia() {
            move(); 
            turnLeft();
            move(); move();
            turnRight();
            move(); move(); move();
            turnLeft();
            move();
            turnLeft();
            move();
        }
        
        public void rutaNiquia() {
            move(); move(); move();
            turnLeft();
            move(); move(); move(); move(); move(); move();                
            turnRight(); 
            move(); 
            turnLeft(); 
            move(); move(); move(); 
            turnRight(); 
            move(); move(); 
            turnLeft(); 
            move(); move(); move();
            turnRight(); 
            move(); move(); 
            turnLeft(); 
            move(); move(); move(); move(); move(); 
            turnLeft();                           
            move(); move(); move(); move(); move(); 
            turnRight();                          
            move(); move(); move(); move(); move(); move(); move(); 
            turnRight();                          
            move(); move(); move();               
            turnLeft();                           
            move(); move(); move(); move(); move(); move(); 
            turnRight();                          
            move();                               
            turnLeft();                           
            move(); move(); move();               
            turnRight();                          
            move(); move();                       
            turnLeft();                           
            move();                               
            turnLeft();                           
            move();                            
            move(); move();                        
            turnLeft();                            
            move(); move(); move();               
            turnRight();                           
            move();                                
            turnLeft();                            
            move(); move(); move(); move(); move(); move();  
            turnRight();                           
            move(); move(); move();                
            turnLeft();                            
            move(); move(); move(); move(); move(); move(); move(); move(); move(); 
            turnLeft();                            
            move(); move(); move(); move(); move(); 
            turnRight();                           
            move(); move(); move();                
            turnRight();                           
            move(); move();                        
            turnLeft();                            
            move(); move(); move();                
            turnRight();                           
            move(); move();                        
            turnLeft();                            
            move(); move(); move();                
            turnRight();                           
            move();                                
            turnLeft();                            
            move(); move(); move(); move();        
                
            move(); move();
            turnRight();
            move(); move(); move();
            turnLeft();
            move();
            turnLeft();
            move();
        }
        
        public void IrAEstrella() {
            move(); move();
            turnRight();
            move(); move(); move();
            turnRight();
            move();
            turnLeft();
            move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move(); 
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move(); move(); move(); 
            turnLeft();                           
            move(); move(); move(); move(); move(); 
            turnRight();                          
            move(); move(); move(); move(); move(); move(); move(); 
            turnRight();                          
            move(); move(); move();               
            turnLeft();                           
            move(); move(); move(); move(); move(); move(); 
            turnRight();                          
            move();                               
            turnLeft();                           
            move(); move(); move();               
            turnRight();                          
            move(); move();                       
            turnLeft();                           
            move();                               
            turnLeft();                           
            move();                               
        }
        
        public void rutaEstrella() {
            move(); move();                        
            turnLeft();                            
            move(); move(); move();               
            turnRight();                           
            move();                                
            turnLeft();                            
            move(); move(); move(); move(); move(); move();  
            turnRight();                           
            move(); move(); move();                
            turnLeft();                            
            move(); move(); move(); move(); move(); move(); move(); move(); move(); 
            turnLeft();                            
            move(); move(); move(); move(); move(); 
            turnRight();                           
            move(); move(); move();                
            turnRight();                           
            move(); move();                        
            turnLeft();                            
            move(); move(); move();                
            turnRight();                           
            move(); move();                        
            turnLeft();                            
            move(); move(); move();                
            turnRight();                           
            move();                                
            turnLeft();                            
            move(); move(); move(); move();        
                
            move(); move();
            turnRight();
            move(); move(); move();
            turnLeft();
            move();
            turnLeft();
            move();
            move(); move(); move();               
            turnLeft();                           
            move(); move(); move();
            move(); move(); move (); 
            turnRight();
            move();
            turnLeft();
            move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move(); 
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move(); move(); move(); 
            turnLeft();                           
            move(); move(); move(); move(); move(); 
            turnRight();                          
            move(); move(); move(); move(); move(); move(); move(); 
            turnRight();                          
            move(); move(); move();               
            turnLeft();                           
            move(); move(); move(); move(); move(); move(); 
            turnRight();                          
            move();                               
            turnLeft();                           
            move(); move(); move();               
            turnRight();                          
            move(); move();                       
            turnLeft();                           
            move();                               
            turnLeft();                           
            move();   
        }
        
        public void IrASanJavier() {
            turnRight();
            move(); move(); move();
            turnRight();
            move();
            turnLeft();
            move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move(); 
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move(); move(); move(); 
            move(); move(); move(); move();
            turnRight();
            move(); move(); move(); move();
            turnRight();
            move();
            turnLeft();
            move(); move(); move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move();
            turnLeft();
            move();
        }

        public void rutaSanJavier() {
            move(); move();
            turnLeft();
            move(); move(); move(); move(); move();
            turnRight();
            move();
            turnLeft();
            move(); move(); move(); move(); move(); move(); move(); move();
            turnLeft();
            move();
            turnRight();
            move();
            turnLeft(); turnLeft();
            move(); move(); move(); move();
            turnRight();
            move(); move(); move(); move();
            turnRight();
            move();
            turnLeft();
            move(); move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move();
            turnRight();
            move();
            turnLeft();
            move(); move(); move(); move();
            move(); move();
            turnRight();
            move(); move(); move();
            turnLeft();
            move();
            turnLeft();
            move();
            move(); move(); move();
            turnLeft();
            move(); move(); move();
            move(); move(); move();
            turnRight();
            move();
            turnLeft();
            move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move(); move(); move(); move(); move();
            move(); move(); move(); move();
            turnRight();
            move(); move(); move(); move();
            turnRight();
            move();
            turnLeft();
            move(); move(); move(); move(); move();
            turnRight();
            move(); move();
            turnLeft();
            move();
            turnLeft();
            move();
        }
        
        

        // Métodos auxiliares
        public void turnRight() {
            turnLeft(); turnLeft(); turnLeft();
        }

        public boolean leftIsClear() {
            turnLeft(); // Gira a la izquierda
            boolean isClear = frontIsClear(); // Verifica si el frente está libre
            turnRight(); // Gira a la derecha para volver a la posición original
            return isClear; // Devuelve el resultado de si el frente está libre
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
