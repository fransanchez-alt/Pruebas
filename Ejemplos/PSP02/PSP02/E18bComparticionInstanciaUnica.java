package PSP02;

public class E18bComparticionInstanciaUnica extends Thread { 
    private E18aObjetoComun oc; 
    
    public E18bComparticionInstanciaUnica (E18aObjetoComun oc) {
        this.oc = oc;
    }

    @Override 
    public void run() {
        this.oc.variableComun++; 
        //for (int i = 0; i < 1_000_000; i++) this.oc.variableComun++;
        System.out.println("Variable común:" + this.oc.variableComun) ;
    }

    public static void main(String[] args) throws InterruptedException {
        E18aObjetoComun oc = new E18aObjetoComun () ; 
        E18bComparticionInstanciaUnica ciul = new E18bComparticionInstanciaUnica (oc); 
        E18bComparticionInstanciaUnica ciu2 = new E18bComparticionInstanciaUnica (oc); 
        ciul. start () ; 
        Thread.sleep (100) ; 
        ciu2. start ();
    } 
}
