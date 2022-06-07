package utils;

public class EstadoInvalidoException extends Exception {
    @Override
    public String toString() {
        return "O estado deve ser definido pela sua sigla e com letras maiúsculas (exemplo: \"SP\").";
    }
}
