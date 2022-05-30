package Locadora;

import javax.swing.*;

public class Carro extends Veiculo{
    private int numeroPassageiro;

    public Carro() {}

    public Carro(String tipo, double vlDiaria, String descricao, String identificacaoVeiculo, boolean veiculoDisponivel, int numeroPassageiro) {
        super(tipo, vlDiaria, descricao, identificacaoVeiculo, veiculoDisponivel);
        this.numeroPassageiro = numeroPassageiro;
    }

    public int getNumeroPassageiro() {
        return numeroPassageiro;
    }

    public void setNumeroPassageiro(int numeroPassageiro) {
        this.numeroPassageiro = numeroPassageiro;
    }

    public Carro cadastroCarro (String tipo){
        this.setTipo(tipo);
        this.setVlDiaria(Double.parseDouble (JOptionPane.showInputDialog("Valor da diária: ")));
        this.setDescricao(JOptionPane.showInputDialog("Descreva a marca ou modelo: ").toUpperCase());
        this.setIdentificacaoVeiculo(JOptionPane.showInputDialog("Digite a placa do veículo: "));
        this.setVeiculoDisponivel(true);
        this.setNumeroPassageiro(Integer.parseInt(JOptionPane.showInputDialog("Número de passageiros ?")));

        return this;

    }
}
