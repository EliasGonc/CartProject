import data.Dados;
import model.Fornecedor;
import model.Produto;
import utils.Cadastro;
import utils.SemEstoqueException;
import utils.ValorNegativoException;
import view.Menu;

import java.util.Scanner;

public class GerenciarProdutos {
    public static void main(String[] args) {
        abrirMenuPrincipal();
    }

    public static void abrirMenuPrincipal() {
        Scanner input = new Scanner(System.in);
        int opcaoMenu = 0;
        while(opcaoMenu != 9) {
            Menu.imprimirMenuPrincipal();
            try {
                opcaoMenu = Integer.parseInt(input.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }
            System.out.println();
            switch(opcaoMenu) {
                case 1:
                    abrirMenuCadastro();
                    break;
                case 2:
                    abrirMenuCarrinho();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void abrirMenuCadastro() {
        Scanner input = new Scanner(System.in);
        int opcaoMenu = 0;
        while(opcaoMenu != 9) {
            Menu.imprimirMenuCadastro();
            try {
                opcaoMenu = Integer.parseInt(input.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }
            System.out.println();
            switch(opcaoMenu) {
                case 1:
                    abrirSubmenuCadastro("fornecedores");
                    break;
                case 2:
                    abrirSubmenuCadastro("produtos");
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void abrirSubmenuCadastro(String tipo) {
        Scanner input = new Scanner(System.in);
        int opcaoMenu = 0;
        while(opcaoMenu != 9) {
            Menu.imprimirSubmenuCadastro(tipo);
            try {
                opcaoMenu = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }
            System.out.println();
            switch(opcaoMenu) {
                case 1:
                    if(tipo.equals("fornecedores")) {
                        Dados.getFornecedores().add(Cadastro.cadastrarFornecedor());
                    } else if(tipo.equals("produtos")) {
                        if(Dados.getFornecedores().size() == 0) {
                            System.out.println("Não há fornecedores cadastrados. " +
                                    "Cadastre pelo menos um fornecedor primeiro.");
                        } else {
                            Dados.getProdutos().add(Cadastro.cadastrarProduto());
                        }
                    }
                    break;
                case 2:
                    if(tipo.equals("fornecedores")) {
                        Dados.listarFornecedores(true);
                    } else if(tipo.equals("produtos")) {
                        Dados.listarProdutos(true);
                    }
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void abrirMenuCarrinho() {
        Scanner input = new Scanner(System.in);
        int opcaoMenu = 0;
        while(opcaoMenu != 9) {
            Menu.imprimirMenuCarrinho();
            try {
                opcaoMenu = Integer.parseInt(input.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }
            System.out.println();
            switch(opcaoMenu) {
                case 1:
                    if(Dados.getProdutos().size() == 0) {
                        System.out.println("Não há produtos cadastrados!");
                    } else {
                        incluirProdutoNoCarrinho();
                    }
                    break;
                case 2:
                    Dados.getCesta().exibirLista();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void incluirProdutoNoCarrinho() {
        Scanner input = new Scanner(System.in);
        int codigo, qtde;
        Produto p;
        Dados.listarProdutos(false);
        System.out.println();
        System.out.print("Digite o código do produto que deseja adicionar no carrinho: ");
        while(true) {
            try {
                codigo = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("O código do produto deve ser um valor inteiro.");
            }
        }
        p = Dados.buscarProduto(codigo);
        if (p != null) {
            System.out.print("Digite a quantidade a ser adicionada no carrinho: ");
            while(true) {
                try {
                    qtde = Integer.parseInt(input.nextLine());
                    if(qtde < 0) {
                        System.out.println("A quantidade deve ser maior que zero.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("A quantidade deve ser um valor inteiro.");
                }
            }
            if(qtde <= p.getQuantidade()) {
                for (int i = 0; i < qtde; i++) {
                    try {
                        Dados.getCesta().adicionarItem(p);
                    } catch (ValorNegativoException ignored) {}
                }
                System.out.println("Produto adicionado no carrinho!");
            } else {
                System.out.println("Não há estoque suficiente do produto.");
            }
        } else {
            System.out.println("Produto não encontrado. Retornando ao menu anterior…");
        }
        System.out.println();
    }
}
