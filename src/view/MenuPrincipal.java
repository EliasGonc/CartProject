package view;

import java.util.Scanner;

public abstract class MenuPrincipal {
    public void abrirMenu() {
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
                    MenuCadastro.abrirMenu();
                    break;
                case 2:
                    MenuCarrinho.abrirMenu();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void imprimirMenu() {
        System.out.println("PROJETO CARRINHO DE COMPRAS");
        System.out.println();
        System.out.println("1) Cadastros");
        System.out.println("2) Carrinho");
        System.out.println("9) Sair");
        System.out.print("Opção: ");
    }
/*
    @Override
    public String toString() {
        return "PROJETO CARRINHO DE COMPRAS\n" +
                "\n" +
                "1) Cadastros\n" +
                "2) Carrinho\n" +
                "9) Sair\n" +
                "Opção: ";
    }
 */
}
