package es.ieslavereda;

import static com.diogonunes.jcolor.Ansi.colorize;

public enum Palo {
    SPADE("\u2660",Color.NEGRO),
    HEART("\u2665",Color.ROJO),
    DIAMOND("\u2666",Color.ROJO),
    CLUB("\u2663",Color.NEGRO);

    private String typeOf;
    private Color color;

    Palo(String typeOf, Color color){
        this.color= color;
        this.typeOf = typeOf;
    }

    @Override
    public String toString(){
        return colorize(typeOf,color.getAtributoColor());
    }

}
