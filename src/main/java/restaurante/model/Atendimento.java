package main.java.restaurante.model;

public class Atendimento {

    //Atributos
    private final Grupo grupo;
    private final Mesa mesa;

    //Construtor
    public Atendimento(Grupo grupo, Mesa mesa) {
        this.grupo = grupo;
        this.mesa = mesa;
    }

    //Getters
    public Grupo getGrupo() {
        return grupo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    @Override
    public String toString() {
        return grupo.getNome() + " -> " + mesa;
    }
}