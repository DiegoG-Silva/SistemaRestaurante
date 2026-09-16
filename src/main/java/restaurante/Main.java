package main.java.restaurante;

import main.java.restaurante.model.Grupo;
import main.java.restaurante.model.Mesa;
import main.java.restaurante.service.Restaurante;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();

        while (true) {

            System.out.println("\n=== RESTAURANTE ===");
            System.out.println("1 - Adicionar grupo");
            System.out.println("2 - Adicionar mesa");
            System.out.println("3 - Distribuir mesas");
            System.out.println("4 - Ver fila");
            System.out.println("5 - Ver atendimentos");
            System.out.println("6 - Ver mesas livres");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome do grupo: ");
                    String nome = scanner.nextLine();

                    System.out.print("Quantidade de pessoas: ");
                    int quantidadePessoas = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Contato (opcional): ");
                    String contato = scanner.nextLine();

                    Grupo grupo = new Grupo(
                            nome,
                            quantidadePessoas,
                            contato
                    );

                    restaurante.adicionarFila(grupo);

                    System.out.println("Grupo adicionado à fila!");

                    break;

                case 2:

                    System.out.print("ID da mesa: ");
                    int idMesa = scanner.nextInt();

                    System.out.print("Capacidade da mesa: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();

                    Mesa mesa = new Mesa(idMesa, capacidade);

                    restaurante.adicionarMesaLivre(mesa);

                    System.out.println("Mesa adicionada!");

                    break;

                case 3:

                    restaurante.distribuirMesas();

                    System.out.println("Mesas distribuídas!");

                    break;

                case 4:

                    restaurante.mostrarFila();

                    break;

                case 5:

                    restaurante.mostrarAtendimentos();

                    break;

                case 6:

                    restaurante.mostrarMesasLivres();

                    break;

                case 7:

                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    return;

                default:

                    System.out.println("Opção inválida!");
            }
        }
    }
}