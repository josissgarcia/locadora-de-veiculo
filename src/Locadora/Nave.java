package Locadora;

import javax.swing.*;

public class Nave extends Veiculo{
    private String motor;

    public Nave() { }

    public Nave(String tipo, double vlDiaria, String descricao, String identificacaoVeiculo,boolean veiculoDisponivel, String motor) {
        super(tipo, vlDiaria, descricao, identificacaoVeiculo, veiculoDisponivel);
        this.motor = motor;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
    public Nave cadastroNave(String tipo){
        this.setTipo(tipo);
        this.setVlDiaria(Double.parseDouble (JOptionPane.showInputDialog("Valor da diária: ")));
        this.setDescricao(JOptionPane.showInputDialog("Descreva a marca ou modelo: ").toUpperCase());
        this.setIdentificacaoVeiculo(JOptionPane.showInputDialog("Digite a placa do veículo: "));
        this.setVeiculoDisponivel(true);
        this.setMotor(JOptionPane.showInputDialog("Qual o motor (Atômico ou combustível) ?").toUpperCase());

        return this;

    }
}
