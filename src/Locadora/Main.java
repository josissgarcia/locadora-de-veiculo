package Locadora;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> listaCliente = new ArrayList<>();
        ArrayList<Veiculo> listaVeiculoCadastrado = new ArrayList<>();
        ArrayList<Locacao> listaLocacao = new ArrayList<>();
        ArrayList<Veiculo> listaVeiculoDisponivel = new ArrayList<>();

        int opcoes;
        String firstOpcoes;

        while (true) {
            firstOpcoes = JOptionPane.showInputDialog(
                    "Selecione uma opção: \n\n" +
                            "1  --  Cadastrar Cliente\n" +
                            "2  --  Cadastrar Veiculo\n" +
                            "3  --  Locar Veiculo\n" +
                            "4  --  Sair\n");

            opcoes = Integer.parseInt(firstOpcoes);

            switch (opcoes) {
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastroCliente();
                    listaCliente.add(cliente);
                    break;
                case 2:
                    /*Veiculo veiculo = new Veiculo();
                    veiculo.cadastroVeiculo();
                    listaVeiculoCadastrado.add(veiculo);*/
                    String tipoVeiculo = JOptionPane.showInputDialog("Tipo de veículo (Nave, Carro ou Moto): ").toUpperCase();

                    if (tipoVeiculo.equals("NAVE")){
                        Nave nave = new Nave();
                        nave.cadastroNave(tipoVeiculo);
                        listaVeiculoCadastrado.add(nave);

                    }else if (tipoVeiculo.equals("CARRO")){
                        Carro carro = new Carro();
                        carro.cadastroCarro(tipoVeiculo);
                        listaVeiculoCadastrado.add(carro);

                    }else if (tipoVeiculo.equals("MOTO")){
                        Moto moto = new Moto();
                        moto.cadastroMoto(tipoVeiculo);
                        listaVeiculoCadastrado.add(moto);
                    };
                    break;
                case 3:
                    Locacao locacao = new Locacao();
                    locacao.locarVeiculo();
                    listaLocacao.add(locacao);
                    break;
                case 4:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null,
                            opcoes + " é uma opção Invalida!", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog (null, listaCliente);
            JOptionPane.showMessageDialog (null, listaVeiculoCadastrado);
            //JOptionPane.showMessageDialog (null, listaLocacao);
            //JOptionPane.showMessageDialog (null, listaVeiculoDisponivel);
        }
    }
}
