package controllers;

public enum Error {
    NOT_COLOR("Error - Los colores no tienen parámetros válidos. Debe contener estos caracteres: "), 
    NOT_DIMENSION("Error - La longitud de la clave es incorrecta.");

    private String message;

    private Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
