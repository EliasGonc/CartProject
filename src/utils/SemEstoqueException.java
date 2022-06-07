package utils;

public class SemEstoqueException extends Exception {
    @Override
    public String toString() {
        return "Limite atingido! Não há mais estoque disponível desse produto.";
    }
}
