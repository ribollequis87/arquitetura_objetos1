package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Cadastrar restaurante");
            System.out.println("2. Listar restaurantes");
            System.out.println("3. Cadastrar item no menu de um restaurante");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                System.out.println("Digite o nome do restaurante: ");
                String nome_restaurante = scanner.nextLine();

                System.out.println("Digite a avaliacao do restaurante: ");
                String avaliacao = scanner.nextLine();

                Restaurante restaurante = new Restaurante();
                restaurante.nome = nome_restaurante;
                restaurante.avaliacao = avaliacao;

                restaurantes.add(restaurante);

                System.out.println("Restaurante " + nome_restaurante + " cadastrado com sucesso!");

            } else if (opcao.equals("2")) {
                System.out.println("Restaurantes cadastrados:");
                for (int idx = 0; idx < restaurantes.size(); idx++){
                    Restaurante restaurante = restaurantes.get(idx);
                    System.out.println(idx + ": " + restaurante.nome);
                    restaurante.imprimirMenu();
                }
            } else if (opcao.equals("3")) {

                System.out.println("Escolha o número do restaurante para adicionar um item ao menu: ");
                int escolha = scanner.nextInt();

                Restaurante restaurante_escolhido = restaurantes.get(escolha);

                System.out.println("Digite o nome do item: ");
                String nome_item = scanner.next();

                System.out.println("Digite o preço do item: ");
                float preco_item = scanner.nextFloat();

                Item item = new Item();
                item.nome = nome_item;
                item.preco = preco_item;

                restaurante_escolhido.adicionarItem(item);
                System.out.println("Item " + nome_item + " adicionado ao menu do restaurante " + restaurante_escolhido.nome);

            } else if (opcao.equals("4")) {
                System.out.println("Obrigado por utilizar o sistema de cadastro de restaurantes!");
                break;

            } else {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}