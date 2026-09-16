package main.java.restaurante.model;

public class Mesa {

    //Atributos
    private final int id;
    private final int capacidade;
    private StatusMesa status;

    //Construtor
    public Mesa(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public String toString() {
        return "Mesa " + id + " (" + capacidade + " lugares)";
    }
}