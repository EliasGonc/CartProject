package model;

import utils.ValorNegativoException;

import java.util.Objects;

public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int quantidade;
    private Fornecedor fornecedor;

    public Produto() {
    }

    public Produto(int codigo, String descricao, double preco, int quantidade, Fornecedor fornecedor) throws ValorNegativoException {
        setCodigo(codigo);
        this.descricao = descricao;
        setPreco(preco);
        setQuantidade(quantidade);
        this.fornecedor = fornecedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ValorNegativoException {
        if(codigo < 0) {
            throw new ValorNegativoException();
        } else {
            this.codigo = codigo;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws ValorNegativoException {
        if(preco < 0) {
            throw new ValorNegativoException();
        } else {
            this.preco = preco;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws ValorNegativoException {
        if(quantidade < 0) {
            throw new ValorNegativoException();
        } else {
            this.quantidade = quantidade;
        }
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor)  {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "(" + codigo + ") " + descricao + ", R$ "
                + String.format("%.2f", preco) + "; " + quantidade
                + " em estoque (fornecedor: " + fornecedor.getRazaoSocial()
                + ")";
/*
        return "- Código: " + codigo + '\n' +
                "- Descrição: " + descricao + '\n' +
                "- Preço: R$ " + String.format("%.2f\n", preco) +
                "- Quantidade em estoque: " + quantidade + '\n' +
                "- Fornecedor: (" + fornecedor.getCodigo() + ") " +
                fornecedor.getRazaoSocial() + '\n';
*/
    }

    public String descricaoCurta() {
        return "(" + codigo + ") " + descricao + ", R$ "
                + String.format("%.2f", preco) + "; " + quantidade
                + " em estoque";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return codigo == produto.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
