package Entidades;

import javax.swing.*;
import java.util.ArrayList;

public class Locacao {

    int diasLocacao;
    String dataLocacao;
    boolean seguro;
    double vlDesconto;
    String nomeCliente;
    String tipoVeiculo;

    ArrayList<Cliente> veiculosDisponiveis = new ArrayList<>();
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

    public void locarVeiculo(ArrayList<Veiculo> listaVeiculos) {
        var lista = listaVeiculos;
        var locacaoOk = false;
        var vlrBrutoLocacao = 0.0;
        var vlrLiqLocacao = 0.0;

        tipoVeiculo = JOptionPane.showInputDialog("Qual veículo deseja locar (Nave, Carro, Moto) ? ").toUpperCase();

        for (int i=0; i<lista.size(); i++){
            if (lista.get(i).getTipo().equals(tipoVeiculo)){
                if (lista.get(i).isVeiculoDisponivel()){
                    diasLocacao = Integer.parseInt(JOptionPane.showInputDialog("Quantos dias necessitará do veículo? "));
                    dataLocacao = JOptionPane.showInputDialog("Qual a data da locação? ",java.time.LocalDate.now());
                    seguro = (JOptionPane.showInputDialog("Deseja incluir seguro (Sim / Não)").toUpperCase().equals("SIM") ? true : false);
                    vlDesconto = Double.parseDouble(JOptionPane.showInputDialog("Percentual de desconto?"));
                    if (vlDesconto > 12){
                        JOptionPane.showMessageDialog(null, "O desconto não pode ultrapassar 12%");
                        break;
                    }
                    vlrBrutoLocacao = calcularCusto(lista.get(i));
                    vlrLiqLocacao = vlrBrutoLocacao - vlrBrutoLocacao*vlDesconto/100;
                    lista.get(i).setVeiculoDisponivel(false);
                    locacaoOk = true;
                    break;
                }
            }
        }
        if (locacaoOk){
            JOptionPane.showMessageDialog(null, "Locação efetuada com sucesso!\n" +
                    "Valor da Locação: "+vlrLiqLocacao);
        } else{
            JOptionPane.showMessageDialog(null, "Locação não efetuada ou veiculo indisponivel");
        }
    }

    public Double calcularCusto(Veiculo veiculo){
        var veiculoLocado = veiculo;
        double result=0.0;

        if (tipoVeiculo.equals("CARRO")){

            if (seguro = true)
                result = (veiculoLocado.getVlDiaria() + veiculoLocado.getVlDiaria()*0.05)*diasLocacao*(1 + ((Carro)veiculoLocado).getNumeroPassageiro()/20);
            else
                result = veiculoLocado.getVlDiaria() * diasLocacao;

        }else if (tipoVeiculo.equals("MOTO")){
            if (seguro = true)
                result = (veiculoLocado.getVlDiaria() + veiculoLocado.getVlDiaria()*0.09)*diasLocacao;
            else
                result = veiculoLocado.getVlDiaria() * diasLocacao;

        }else if (tipoVeiculo.equals("NAVE")) {
            int mult = (((Nave) veiculoLocado).getMotor().equals("ATOMICO") ? 2 : 1);

            if(seguro){
                result = veiculoLocado.getVlDiaria() + veiculoLocado.getVlDiaria() * mult * diasLocacao ;
            }
            else {
                result = veiculoLocado.getVlDiaria() * diasLocacao * mult;
            }
        }
        return result;
    }



    @Override
    public String toString() {
        return "\nLocacao{" +
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




