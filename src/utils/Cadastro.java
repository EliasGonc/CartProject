package utils;

import data.Dados;
import model.Fornecedor;
import model.Produto;
import view.Menu;

import java.util.Scanner;

public abstract class Cadastro {
    public static Fornecedor cadastrarFornecedor() {
        Fornecedor f = new Fornecedor();
        cadastrarCodigoFornecedor(f);
        cadastrarRazaoSocialFornecedor(f);
        cadastrarEnderecoFornecedor(f);
        cadastrarCidadeFornecedor(f);
        if(f.getCidade().equals("")) {
            f.setCidade("Mogi Mirim");
            try {
                f.setEstado("SP");
            } catch(EstadoInvalidoException ignored) {}
        } else {
            cadastrarEstadoFornecedor(f);
        }
        cadastrarContatoFornecedor(f);
        System.out.println();
        System.out.println("Fornecedor cadastrado com sucesso!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void cadastrarCodigoFornecedor(Fornecedor f) {
        Scanner input = new Scanner(System.in);
        int codigo;
        while(true) {
            System.out.print("Digite o código do fornecedor: ");
            try {
                codigo = Integer.parseInt(input.nextLine());
                if(Dados.buscarFornecedor(codigo) == null) {
                    f.setCodigo(codigo);
                    break;
                } else {
                    System.out.println("Já existe um fornecedor cadastrado com este código!");
                }
            } catch(NumberFormatException e) {
                System.out.println("O código precisa ser um número inteiro");
            } catch(ValorNegativoException e) {
                System.out.println(e.toString());
            }
        }
    }

    public static void cadastrarRazaoSocialFornecedor(Fornecedor f) {
        Scanner input = new Scanner(System.in);
        String razaoSocial = "";
        do {
            System.out.print("Digite a razão social do fornecedor: ");
            razaoSocial = input.nextLine();
        } while(razaoSocial.equals(""));
        f.setRazaoSocial(razaoSocial);
    }

    public static void cadastrarEnderecoFornecedor(Fornecedor f) {
        Scanner input = new Scanner(System.in);
        String endereco = "";
        do {
            System.out.print("Digite o endereço do fornecedor: ");
            endereco = input.nextLine();
        } while(endereco.equals(""));
        f.setEndereco(endereco);
    }

    public static void cadastrarCidadeFornecedor(Fornecedor f) {
        Scanner input = new Scanner(System.in);
        String cidade;
        System.out.print("Digite a cidade do fornecedor (ou deixa em branco para considerar Mogi Mirim): ");
        cidade = input.nextLine();
        f.setCidade(cidade);
    }

    public static void cadastrarEstadoFornecedor(Fornecedor f) {
        Scanner input = new Scanner(System.in);
        String estado;
        while(true) {
            try {
                System.out.print("Digite o estado do fornecedor: ");
                estado = input.nextLine();
                f.setEstado(estado);
                break;
            } catch(EstadoInvalidoException e) {
                System.out.println(e);
            }
        }
    }

    public static void cadastrarContatoFornecedor(Fornecedor f) {
        Scanner input = new Scanner(System.in);
        String dado;
        do {
            System.out.print("Digite o nome do contato do fornecedor: ");
            dado = input.nextLine();
        } while(dado.equals(""));
        f.getContato().setNome(dado);
        do {
            System.out.print("Digite o telefone do contato do fornecedor: ");
            dado = input.nextLine();
        } while(dado.equals(""));
        f.getContato().setTelefone(dado);
        do {
            System.out.print("Digite o email do contato do fornecedor: ");
            dado = input.nextLine();
        } while(dado.equals(""));
        f.getContato().setEmail(dado);
    }

    public static Produto cadastrarProduto() {
        Produto p = new Produto();
        cadastrarCodigoProduto(p);
        cadastrarDescricaoProduto(p);
        cadastrarPrecoProduto(p);
        cadastrarEstoqueProduto(p);
        cadastrarFornecedorNoProduto(p);
        System.out.println("Produto cadastrado com sucesso!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return p;
    }

    public static void cadastrarCodigoProduto(Produto p) {
        Scanner input = new Scanner(System.in);
        int codigo;
        while(true) {
            try {
                System.out.print("Digite o código do produto: ");
                codigo = Integer.parseInt(input.nextLine());
                if(Dados.buscarProduto(codigo) == null) {
                    p.setCodigo(codigo);
                    break;
                } else {
                    System.out.println("Já existe um produto com este código!");
                }
            } catch(NumberFormatException e) {
                System.out.println("O código precisa ser um número inteiro.");
            } catch(ValorNegativoException e) {
                System.out.println(e);
            }
        }
    }

    public static void cadastrarDescricaoProduto(Produto p) {
        Scanner input = new Scanner(System.in);
        String descricao;
        do {
            System.out.print("Digite a descrição do produto: ");
            descricao = input.nextLine();
        } while(descricao.equals(""));
        p.setDescricao(descricao);
    }

    public static void cadastrarPrecoProduto(Produto p) {
        Scanner input = new Scanner(System.in);
        double preco;
        while(true) {
            try {
                System.out.print("Digite o preço do produto: ");
                preco = Double.parseDouble(input.nextLine());
                p.setPreco(preco);
                break;
            } catch(NumberFormatException e) {
                System.out.println("O preço precisa ser um valor numérico.");
            } catch(ValorNegativoException e) {
                System.out.println(e);
            }
        }
    }

    public static void cadastrarEstoqueProduto(Produto p) {
        Scanner input = new Scanner(System.in);
        int quantidade;
        while(true) {
            try {
                System.out.print("Digite a quantidade em estoque do produto: ");
                quantidade = Integer.parseInt(input.nextLine());
                p.setQuantidade(quantidade);
                break;
            } catch(NumberFormatException e) {
                System.out.println("A quantidade em estoque precisa ser um número inteiro.");
            } catch(ValorNegativoException e) {
                System.out.println(e);
            }
        }
    }

    public static void cadastrarFornecedorNoProduto(Produto p) {
        Scanner input = new Scanner(System.in);
        int codigo;
        while(true) {
            Menu.imprimirLinhaDivisoria('-', 60);
            System.out.println("Fornecedores cadastrados:");
            Dados.listarFornecedores(false);
            System.out.print("Digite o código do fornecedor deste produto: ");
            try {
                codigo = Integer.parseInt(input.nextLine());
                Fornecedor f = Dados.buscarFornecedor(codigo);
                if(f == null) {
                    System.out.println("Fornecedor não encontrado.");
                } else {
                    p.setFornecedor(f);
                    break;
                }
            } catch(NumberFormatException e) {
                System.out.println("O código precisa ser um valor maior que zero.");
            }
        }
    }
}
