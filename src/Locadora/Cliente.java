package Locadora;

import javax.swing.*;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;

    //Construtor Vazio
    public Cliente ( ) { }

    // Construtor com campos
    public Cliente (String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente cadastroCliente(){
        this.nome = JOptionPane.showInputDialog("Nome do cliente: ").toUpperCase();
        this.cpf = JOptionPane.showInputDialog("Cpf do cliente: ");
        this.telefone = JOptionPane.showInputDialog("Telefone do cliente: ");
        return this;

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "\nnome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
