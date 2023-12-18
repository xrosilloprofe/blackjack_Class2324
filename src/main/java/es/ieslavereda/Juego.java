package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Juego {

    private Baraja baraja;
    private Jugador[] jugadores;
    private Jugador jugadorPC;

    public Juego(Jugador[] jugadores){
        this.jugadores = jugadores;
        this.baraja = new Baraja();
        this.jugadorPC = new Jugador("BANCA");
    }

    public void start(){
        //repartir las 2 cartas
        for(Jugador jugador:jugadores){
            repartoInicial(jugador);
        }

        //jugará cada jugador
        for(Jugador jugador:jugadores)
            juegaJugador(jugador);

        juegaPC(jugadorPC);

        mostrarGanador();

    }

    private void repartoInicial(Jugador jugador) {
        jugador.addCarta(baraja.repartirEncima());
        jugador.addCarta(baraja.repartirEncima());
    }

    public void juegaJugador(Jugador jugador){
        System.out.println(colorize("Le toca al jugador " + jugador.getNombre(), Attribute.BLUE_TEXT()));
        System.out.println(jugador);
        String opcion = Input.getOption("Otra carta? (Y/N) ");

        while (opcion.equals("Y") && jugador.getPuntuacion()>=0){
            jugador.addCarta(baraja.repartirEncima());
            System.out.println(jugador);
            if(jugador.getPuntuacion()>=0)
                opcion = Input.getOption("Otra carta? (Y/N) ");
            else
                System.out.println(colorize("Te has pasado !!",Attribute.MAGENTA_TEXT()));
        }
    }

    private int maxPuntuacionJugadores(){
        return 0;
    }

    public void juegaPC(Jugador jugador){

    }

    public void mostrarGanador(){

    }


}
