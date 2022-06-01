package Entidades;

import javax.swing.*;
import java.io.Serializable;


public class Nave extends Veiculo implements Serializable {

    private static final long serialVersionUID = 910951269045719090L;
    private String motor;

    public Nave() {}

    public Nave(String tipo, double vlDiaria, String descricao, String identificacaoVeiculo,boolean veiculoDisponivel, String motor) {
        super(tipo, vlDiaria, descricao, identificacaoVeiculo, veiculoDisponivel);
        this.motor = motor;
    }

    public String getMotor() {
        return this.motor;
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
        this.setMotor(JOptionPane.showInputDialog("Qual o motor desejado?\n1 = Atômico \n2 = Combustivel:").equals("1") ? "ATOMICO" : "COMBUSTIVEL");
        return this;

    }
}
