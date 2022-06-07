package view;

import java.util.Scanner;

public abstract class MenuCarrinho {
    public static void abrirMenu() {
        Scanner input = new Scanner(System.in);
        int opcaoMenu = 0;
        while(opcaoMenu != 9) {
            try {
                opcaoMenu = Integer.parseInt(input.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Opção inválida.");
            }
            switch(opcaoMenu) {
                case 1:
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
        System.out.println("O que deseja fazer?");
        System.out.println("1) Adicionar produto no carrinho");
        System.out.println("2) Ver produto no carrinho");
        System.out.println("9) Voltar ao menu anterior");
        System.out.println("Opção: ");
    }

    /*
    @Override
    public String toString() {
        return "O que deseja fazer?\n" +
                "1) Adicionar produto no carrinho\n" +
                "2) Ver produto no carrinho\n" +
                "9) Voltar ao menu anterior\n" +
                "Opção: ";
    }
    */
}
