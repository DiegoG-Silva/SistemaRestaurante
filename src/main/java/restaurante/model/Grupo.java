package main.java.restaurante.model;

public class Grupo {

    //Atributos
    private final String nome;
    private final int quantidadePessoas;
    private final String contato;

    //Construtor
    public Grupo(String nome, int quantidadePessoas, String contato) {
        this.nome = nome;
        this.quantidadePessoas = quantidadePessoas;
        this.contato = contato;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public String getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return nome + " (" + quantidadePessoas + " pessoas)";
    }
}