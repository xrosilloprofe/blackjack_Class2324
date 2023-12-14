package es.ieslavereda;

public class Carta {
    private Palo palo;
    private Numero numero;

    public Carta(Palo palo, Numero numero){
        this.palo = palo;
        this.numero = numero;
    }

    public Palo getPalo(){ return palo;}
    public Numero getNumero(){return numero;}

    @Override
    public String toString(){
        return numero.toString()+palo;
    }

}
