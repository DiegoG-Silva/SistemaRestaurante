package main.java.restaurante.service;

import main.java.restaurante.model.Atendimento;
import main.java.restaurante.model.Grupo;
import main.java.restaurante.model.Mesa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurante {

    //Atributos
    private final List<Grupo> filaEspera;
    private final List<Mesa> mesasLivres;
    private final List<Atendimento> atendimentos;

    //Construtor
    public Restaurante() {
        filaEspera = new ArrayList<>();
        mesasLivres = new ArrayList<>();
        atendimentos = new ArrayList<>();
    }

    //Métodos
    public void adicionarFila(Grupo grupo) {
        if(grupo.getQuantidadePessoas()>0 && grupo.getNome() != null){
        filaEspera.add(grupo);
        }
    }

    public void adicionarMesaLivre(Mesa mesa) {
        if(mesa.getCapacidade()>0) {
            mesasLivres.add(mesa);
        }
    }

    public void distribuirMesas() {

        // Primeiro as maiores mesas
        mesasLivres.sort(
                Comparator.comparingInt(Mesa::getCapacidade).reversed()
        );

        // Cria a cópia pra percorrer
        List<Mesa> mesasParaDistribuir = new ArrayList<>(mesasLivres);

        for (Mesa mesa : mesasParaDistribuir) {

            Grupo melhorGrupo = null;

            // Procurar o maior grupo que cabe na mesa
            for (Grupo grupo : filaEspera) {

                if (grupo.getQuantidadePessoas() <= mesa.getCapacidade()) {

                    if (melhorGrupo == null || grupo.getQuantidadePessoas() > melhorGrupo.getQuantidadePessoas()) {
                        melhorGrupo = grupo;
                    }
                }
            }

            // Se encontrou alguém para a mesa
            if (melhorGrupo != null) {

                Atendimento atendimento =
                        new Atendimento(melhorGrupo, mesa);

                atendimentos.add(atendimento);

                filaEspera.remove(melhorGrupo);
                mesasLivres.remove(mesa);
            }
        }
    }

    public void mostrarFila() {

        System.out.println("\n--- FILA DE ESPERA ---");

        if (filaEspera.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }

        for (Grupo grupo : filaEspera) {
            System.out.println(grupo);
        }
    }

    public void mostrarAtendimentos() {

        System.out.println("\n--- ATENDIMENTOS ---");

        if (atendimentos.isEmpty()) {
            System.out.println("Nenhum atendimento.");
            return;
        }

        for (Atendimento atendimento : atendimentos) {
            System.out.println(atendimento);
        }
    }

    public void mostrarMesasLivres() {

        System.out.println("\n--- MESAS LIVRES ---");

        if (mesasLivres.isEmpty()) {
            System.out.println("Nenhuma mesa livre.");
            return;
        }

        for (Mesa mesa : mesasLivres) {
            System.out.println(mesa);
        }
    }
}