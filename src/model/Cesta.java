package model;

import utils.ValorNegativoException;

import java.util.*;

public class Cesta {
    private final List<Produto> itens = new ArrayList<>();

    public void adicionarItem(Produto p) throws ValorNegativoException {
        itens.add(p);
        p.setQuantidade(p.getQuantidade() - 1);
    }


    public void exibirLista() {
        if(itens.size() == 0) {
            System.out.println("O carrinho está vazio!");
        } else {
            Set<Produto> produtosUnicos = new HashSet<>(itens);
            System.out.println("Código | Descrição                                | Qtde | Valor");
            for(Produto p : produtosUnicos) {
                System.out.printf("%6d | %-40s | %4d | R$ %.2f\n", p.getCodigo(), p.getDescricao(), Collections.frequency(itens, p), p.getPreco());
            }
            System.out.printf("Valor total no carrinho: R$ %.2f.\n", calcularTotal());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for(Produto p : itens) {
            total += p.getPreco();
        }
        return total;
    }
}
