package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

public enum Color {
    ROJO(Attribute.RED_TEXT()),
    NEGRO(Attribute.BLACK_TEXT());

    private Attribute atributoColor;

    Color(Attribute atributoColor){
        this.atributoColor = atributoColor;
    }

    public Attribute getAtributoColor(){
        return atributoColor;
    }

}
