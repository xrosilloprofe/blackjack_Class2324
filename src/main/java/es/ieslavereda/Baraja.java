package es.ieslavereda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private Carta[] baraja;

    public Baraja(){
        baraja = new Carta[Palo.values().length*Numero.values().length];
        int posicion=0;
        for(Palo palo:Palo.values())
            for(Numero tipoCarta:Numero.values()){
                baraja[posicion] = new Carta(palo,tipoCarta);
                posicion++;
            }
        barajar();
    }

    private void barajar(){
        List<Carta> listaCartas = Arrays.asList(baraja);
        Collections.shuffle(listaCartas);
        listaCartas.toArray(baraja);
    }

    public Carta repartirEncima(){
        Carta carta = null;
        if (baraja.length>0){
            carta = baraja[0];
            baraja = Arrays.copyOfRange(baraja, 1, baraja.length);
        }
        return carta;
    }

    public Carta repartirDebajo(){
        Carta carta = null;
        if (baraja.length>0){
            carta = baraja[baraja.length-1];
            baraja=Arrays.copyOfRange(baraja,0,baraja.length-1);
        }
        return carta;
    }

    @Override
    public String toString(){
        return Arrays.toString(baraja);
    }

}
