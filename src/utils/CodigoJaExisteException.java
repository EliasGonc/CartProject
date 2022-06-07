package utils;

public class CodigoJaExisteException extends Exception {
    @Override
    public String toString() {
        return "Já existe um registro com esse código.";
    }
}
