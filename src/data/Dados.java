package data;

import model.Cesta;
import model.Fornecedor;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public abstract class Dados {
    private static List<Fornecedor> fornecedores = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static Cesta cesta = new Cesta();

    public static List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public static void setFornecedores(List<Fornecedor> fornecedores) {
        Dados.fornecedores = fornecedores;
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public static void setProdutos(List<Produto> produtos) {
        Dados.produtos = produtos;
    }

    public static Cesta getCesta() {
        return cesta;
    }

    public static void setCesta(Cesta cesta) {
        Dados.cesta = cesta;
    }

    public static Fornecedor buscarFornecedor(int codigo) {
        for (Fornecedor f : fornecedores) {
            if (f.getCodigo() == codigo) {
                return f;
            }
        }
        return null;
    }

    public static Produto buscarProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public static void listarFornecedores(boolean versaoCompleta) {
        if(Dados.getFornecedores().size() == 0) {
            System.out.println("Não há fornecedores cadastrados.");
        } else {
            if(!versaoCompleta) {
                System.out.println("Código  Razão social");
            } else {
                System.out.println("Fornecedores cadastrados:");
            }
            for (Fornecedor f : Dados.getFornecedores()) {
                if(versaoCompleta) {
                    System.out.println(f);
                } else {
                    System.out.printf("%6d  %s\n", f.getCodigo(), f.getRazaoSocial());
                }
            }
        }
    }

    public static void listarProdutos(boolean versaoCompleta) {
        if(Dados.getProdutos().size() == 0) {
            System.out.println("Não há produtos cadastrados.");
        } else {
                System.out.println("Produtos cadastrados:");
            for (Produto p : Dados.getProdutos()) {
                if(versaoCompleta) {
                    System.out.println(p);
                } else {
                    System.out.println(p.descricaoCurta());
                }
            }
        }
    }

}
