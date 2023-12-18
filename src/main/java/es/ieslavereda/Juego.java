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
        repartoInicial(jugadorPC);

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
        int maxPuntuacion = Integer.MIN_VALUE;
        for(Jugador jugador:jugadores){
            if(jugador.getPuntuacion()>maxPuntuacion)
                maxPuntuacion=jugador.getPuntuacion();
        }
        return maxPuntuacion;
    }

    public void juegaPC(Jugador jugador){
        System.out.println(colorize("Le toca al jugador " + jugadorPC.getNombre(), Attribute.GREEN_TEXT()));
        System.out.println(jugadorPC);
        int maxPuntuacion = maxPuntuacionJugadores();

        while(jugadorPC.getPuntuacion()>=0 && jugadorPC.getPuntuacion()<maxPuntuacion){
            esperar(2000);
            jugadorPC.addCarta(baraja.repartirEncima());
            System.out.println(jugadorPC);
            if(jugadorPC.getPuntuacion()<0)
                System.out.println(colorize("Se ha pasado la BANCA",Attribute.MAGENTA_TEXT()));
        }

    }

    private void esperar(int tiempoMili){
        try{
            Thread.sleep(tiempoMili);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void mostrarGanador(){
        int maxPuntuacion = maxPuntuacionJugadores();
        if(maxPuntuacion<=jugadorPC.getPuntuacion())
            System.out.println("GANA LA BANCA PRINGAOS !!");
        else{
            int numGanadores=0;
            String[] ganadores = new String[jugadores.length];
            for(Jugador jugador:jugadores){
                if(jugador.getPuntuacion()==maxPuntuacion){
                    ganadores[numGanadores++] = jugador.getNombre();
                }
            }
            for(String ganador:ganadores){
                if(ganador!=null)
                    System.out.println("GANADOR: " + ganador);
            }

        }



    }


}
