package utils;

public class ValorNegativoException extends Exception {
    @Override
    public String toString() {
        return "O valor não pode ser negativo.";
    }
}
