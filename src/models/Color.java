package models;

public enum Color {
    AMARILLO('A'), 
    VERDE('V'), 
    ROJO('R'), 
    BLANCO('B'), 
    GRIS('G');

    private char value;

    private Color(char value) {
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }
}
