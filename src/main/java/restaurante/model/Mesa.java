package main.java.restaurante.model;

public class Mesa {

    //Atributos
    private final int id;
    private final int capacidade;
    private StatusMesa status;

    //Construtores
    public Mesa(int id, int capacidade) {
        this(id, capacidade, StatusMesa.LIVRE);
    }
    
    public Mesa(int id, int capacidade, StatusMesa status) {
        this.id = id;
        this.capacidade = capacidade;
        this.status = status;
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