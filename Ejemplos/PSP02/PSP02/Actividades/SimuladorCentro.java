package PSP02.Actividades;

public class SimuladorCentro {

public static void main(String[] args) { Cliente c1 = new Cliente(1, 2); Cliente c2 = new Cliente(2, 3); Cliente c3 = new Cliente(3, 1); Cliente c4 = new Cliente(4, 4);

// Primera ejecución: sin join() 
c1.start(); c2.start(); c3.start(); c4.start();

System.out.println("Simulación lanzada (sin join). El main puede terminar antes que los hilos.");

// Versión con join() (recomendado: comentar el bloque anterior y usar este) 
/* c1.start(); c2.start(); c3.start(); c4.start();

try { 
c1.join(); c2.join(); c3.join(); c4.join(); } catch (InterruptedException e) { e.printStackTrace(); }

System.out.println("Centro cerrado. Todos los clientes han sido atendidos."); */

System.out.println("Simulación lanzada (sin join). El main ya va a salir.");
System.out.println("Hilo main finalizado"); 

}

}
