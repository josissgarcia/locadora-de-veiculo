package Locadora;

import javax.swing.*;

public class Locacao {

    int diasLocacao;
    String dataLocacao;
    String seguro;
    double vlDesconto;
    String nomeCliente;
    String tipoVeiculo;

    Veiculo veiculo = new Veiculo();
    Carro carro = new Carro();
    Moto moto = new Moto();
    Nave nave = new Nave();

    public double calcularLocacao() {

        String tipo = veiculo.getTipo();
        double result = 0;

        switch (tipo) {
            case "NAVE":
                result = diasLocacao * nave.getVlDiaria();

            case "CARRO":
                result = diasLocacao * carro.getVlDiaria();

            case "MOTO":
                result = diasLocacao * moto.getVlDiaria();

        }
        return result;
    }

    public Locacao locarVeiculo() {
        this.nomeCliente = JOptionPane.showInputDialog("Qual cliente deseja locar o veículo? ").toUpperCase();
        this.tipoVeiculo = JOptionPane.showInputDialog("Qual veículo deseja locar (Nave, Carro, Moto) ? ").toUpperCase();
        this.diasLocacao = Integer.parseInt(JOptionPane.showInputDialog("Quantos dias necessitará do veículo? "));
        this.dataLocacao = JOptionPane.showInputDialog("Qual a data da locação? ");
        this.seguro = JOptionPane.showInputDialog("Deseja incluir seguro (Sim / Não)").toUpperCase();
        this.vlDesconto = Double.parseDouble(JOptionPane.showInputDialog("Percentual de desconto?"));
        return this;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "diasLocacao=" + diasLocacao +
                ", dataLocacao='" + dataLocacao + '\'' +
                ", seguro='" + seguro + '\'' +
                ", vlDesconto=" + vlDesconto +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", tipoVeiculo='" + tipoVeiculo + '\'' +
                ", veiculo=" + veiculo +
                ", carro=" + carro +
                ", moto=" + moto +
                ", nave=" + nave +
                '}';
    }
}

    //JOptionPane.showMessageDialog("Cliente locatário: " + cliente.getNome());


    /*O valor do seguro referente a um dia é calculado da seguinte forma:
    Carro: 0.05 * valor da diária * ( 1 + número de passageiro/20)
    Moto: 0.09 * valor da diária
    Nave: 2.00 * valor da diária * (2 (Motor atômico) | 1 – (Motor Elétrico))

    Sobre o valor da locação é possível dar um desconto de no máximo 12%.

    Dentre os veículos cadastrados deve ser possível saber quais estão locados.*/



