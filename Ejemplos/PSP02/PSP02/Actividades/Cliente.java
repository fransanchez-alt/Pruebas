package PSP02.Actividades;

public class Cliente extends Thread {

private int idCliente; private int tiempoAtencion; // en segundos

public Cliente(int idCliente, int tiempoAtencion) { 
    
    this.idCliente = idCliente; 
    this.tiempoAtencion = tiempoAtencion; }


@Override public void run() {

System.out.println("Cliente " + idCliente + " ha comenzado a ser atendido"); 

try {

    Thread.sleep(tiempoAtencion * 1000L); } 

catch (InterruptedException e) {

    System.out.println("Cliente " + idCliente + " ha sido interrumpido");

return; } 

System.out.println("Cliente " + idCliente + " ha terminado de ser atendido");

}

}
