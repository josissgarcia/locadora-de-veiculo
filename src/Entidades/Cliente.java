package Entidades;

import Exceptions.BusinessExceptions;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 5176848790726675261L;
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
        while(this.nome.isEmpty()){
            this.nome = JOptionPane.showInputDialog("Nome do cliente: ").toUpperCase();
        }

        this.cpf = JOptionPane.showInputDialog("Cpf do cliente: ");
        while(this.cpf.isEmpty()){
            this.cpf = JOptionPane.showInputDialog("Cpf do cliente: ");
        }

        this.telefone = JOptionPane.showInputDialog("Telefone do cliente: ");
        while(this.cpf.isEmpty()){
            this.telefone = JOptionPane.showInputDialog("Telefone do cliente: ");
        }
        return this;

    }
    /*
    private void validarCliente(String nome) throws BusinessExceptions {
        if(nome != cadastroCliente().getNome(){
            throw new BusinessExceptions ("Erro: Cliente não cadastrado, realize antes o cadastro do cliente");
        }
    }*/

    @Override
    public String toString() {
        return "Cliente{" +
                "\nnome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public boolean isCliente(String nome, ArrayList<Cliente> lista){
        var listaClientes = lista;
        String nomeConsulta = nome;
        boolean result = false;

        for (int i=0; i<listaClientes.size(); i++){
            if (listaClientes.get(i).getNome().equals(nomeConsulta)) {
                result = true;
            }
        }
        return result;
    }
}
