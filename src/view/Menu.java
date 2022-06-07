package view;

public abstract class Menu {
    public static void imprimirLinhaDivisoria(char simbolo, int quantidade) {
        for(int i = 0; i < quantidade; i++) {
            System.out.print(simbolo);
        }
        System.out.println();
    }

    public static void imprimirTitulo() {
        System.out.println("PROJETO CARRINHO DE COMPRAS");
    }

    public static void imprimirMenuPrincipal() {
        imprimirLinhaDivisoria('=', 60);
        imprimirTitulo();
        System.out.println("--Menu principal--");
        System.out.println("1) Cadastros");
        System.out.println("2) Carrinho");
        System.out.println("9) Sair");
        System.out.print("Opção: ");
    }

    public static void imprimirMenuCadastro() {
        imprimirLinhaDivisoria('=', 60);
        imprimirTitulo();
        System.out.println("--Cadastros--");
        System.out.println("Selecione uma opção abaixo:");
        System.out.println("1) Fornecedores");
        System.out.println("2) Produtos");
        System.out.println("9) Retornar ao menu anterior");
        System.out.print("Opção: ");
    }

    public static void imprimirSubmenuCadastro(String tipo) {
        imprimirLinhaDivisoria('=', 60);
        imprimirTitulo();
        System.out.println("--Cadastro de " + tipo + "--");
        System.out.println("O que deseja fazer?");
        System.out.println("1) Cadastrar novo");
        System.out.println("2) Listar cadastrados");
        System.out.println("9) Retornar ao menu anterior");
        System.out.print("Opção: ");
    }

    public static void imprimirMenuCarrinho() {
        imprimirLinhaDivisoria('=', 60);
        imprimirTitulo();
        System.out.println("--Carrinho--");
        System.out.println("O que deseja fazer?");
        System.out.println("1) Adicionar produto no carrinho");
        System.out.println("2) Ver produtos no carrinho");
        System.out.println("9) Voltar ao menu anterior");
        System.out.print("Opção: ");
    }
}
