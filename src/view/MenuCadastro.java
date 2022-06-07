package view;

import utils.Cadastro;

import java.util.Scanner;

public abstract class MenuCadastro {
    public static void abrirMenu() {
        Scanner input = new Scanner(System.in);
        int opcaoMenu = 0;
        while(opcaoMenu != 9) {
            imprimirMenu();
            try {
                opcaoMenu = Integer.parseInt(input.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }
            switch(opcaoMenu) {
                case 1:
                    Cadastro.cadastrarProduto();
                    break;
                case 2:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void imprimirMenu() {
        System.out.println("O que deseja cadastrar?");
        System.out.println("1) Fornecedor");
        System.out.println("2) Produto");
        System.out.println("9) Voltar ao menu anterior");
        System.out.println("Opção: ");
    }
    /*
    @Override
    public String toString() {
        return "O que deseja cadastrar?\n" +
                "1) Fornecedor\n" +
                "2) Produto\n" +
                "9) Voltar ao menu anterior\n" +
                "Opção: ";
    }
    */
}
