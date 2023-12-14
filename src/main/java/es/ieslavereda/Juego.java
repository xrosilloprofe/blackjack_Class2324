package es.ieslavereda;

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

        //jugará cada jugador
        for(Jugador jugador:jugadores)
            juegaJugador(jugador);

        juegaPC(jugadorPC);

        mostrarGanador();

    }

    public void juegaJugador(Jugador jugador){

    }

    private int maxPuntuacionJugadores(){
        return 0;
    }

    public void juegaPC(Jugador jugador){

    }

    public void mostrarGanador(){

    }


}
