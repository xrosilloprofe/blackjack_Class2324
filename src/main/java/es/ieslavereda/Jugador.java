package es.ieslavereda;

import java.util.Arrays;

public class Jugador {

    private String nombre;
    private Carta[] mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new Carta[0];
    }

    public String getNombre() {
        return nombre;
    }

//    public int getPuntuacion(){
//        int puntos = 0;
//        for(Carta carta:mano){
//            puntos = puntos + carta.getNumero().getPuntuacion()[0];
//        }
//        return (puntos>21?-1:puntos);
//        //if(puntos>21) return -1 else return puntos
//    }

    public int getPuntuacion() {
        return getPuntuacionRecursiva(0, 0);
    }

    private int getPuntuacionRecursiva(int index, int suma) {
        if (suma > 21) return -1;
        if (index >= mano.length) return suma;

        if (mano[index].getNumero().getPuntuacion().length == 1)
            return getPuntuacionRecursiva(index + 1, suma + mano[index].getNumero().getPuntuacion()[0]);

        return Math.max(
                getPuntuacionRecursiva(index + 1, suma + mano[index].getNumero().getPuntuacion()[0]),
                getPuntuacionRecursiva(index + 1, suma + mano[index].getNumero().getPuntuacion()[1])
        );
    }

    public void addCarta(Carta carta) {
        mano = Arrays.copyOf(mano, mano.length + 1);
        mano[mano.length - 1] = carta;
    }

    @Override
    public String toString() {
        return nombre + " mano: " + Arrays.toString(mano) + " puntuación: " + getPuntuacion();
    }

}
