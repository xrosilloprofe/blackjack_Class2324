package es.ieslavereda;

public class Main {
    public static void main(String[] args) {
        //pedir numero jugadores entre 1 y 5
        int numJugadores = 0;
        while(numJugadores<1 || numJugadores>5){
            numJugadores = Input.getInteger("Por favor, introduzca el número de jugadores: ");
        }

        //crear un array de n jugadores
        Jugador[] jugadores = new Jugador[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            jugadores[i] = new Jugador(Input.getString("Nombre jugador " + i + ": "));
        }

        //crear un juego
        Juego juego = new Juego(jugadores);

        //iniciar el juego
        juego.start();
    }
}