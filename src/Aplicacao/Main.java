package Aplicacao;

import Entidades.*;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Cliente> listaCliente = ManipuladorArquivo.lerClientes();
        ArrayList<Veiculo> listaVeiculos = ManipuladorArquivo.lerVeiculos();

        //Inicializar Dados
        /*
        Cliente cliente1 = new Cliente("TESTE", "999", "999");
        listaCliente.add(cliente1);
        Cliente cliente2 = new Cliente("DENNIS", "888", "888");
        listaCliente.add(cliente2);
        Carro carro1 = new Carro("CARRO", 15, "Ford Ka", "ABC 123456", true, 5);
        listaVeiculos.add(carro1);
        Moto moto1 = new Moto("MOTO", 10, "Honda", "ABC 123456", true, true);
        listaVeiculos.add(moto1);
        Nave nave1 = new Nave("NAVE", 10, "Honda", "ABC 123456", true, "ATOMICO");
        listaVeiculos.add(nave1);
        */

        int opcoes;
        String firstOpcoes;

        while (true) {
            firstOpcoes = JOptionPane.showInputDialog(
                    "Selecione uma opção: \n\n" +
                            "1  --  Cadastrar Cliente\n" +
                            "2  --  Cadastrar Veiculo\n" +
                            "3  --  Locar Veiculo\n" +
                            "4  --  Relatorios\n" +
                            "5  --  Sair\n");
            try {
                opcoes = Integer.parseInt(firstOpcoes);
            }catch (NumberFormatException e){
                opcoes = 6;
            }
                switch (opcoes) {
                    case 1:
                        Cliente cliente = new Cliente();
                        cliente.cadastroCliente();
                        listaCliente.add(cliente);
                        break;
                    case 2:
                        String tipoVeiculo = JOptionPane.showInputDialog("Tipo de veículo (Nave, Carro ou Moto): ").toUpperCase();

                        try {
                            if (tipoVeiculo.equals("NAVE")) {
                                Nave nave = new Nave();
                                nave.cadastroNave(tipoVeiculo);
                                listaVeiculos.add(nave);

                            } else if (tipoVeiculo.equals("CARRO")) {
                                Carro carro = new Carro();
                                carro.cadastroCarro(tipoVeiculo);
                                listaVeiculos.add(carro);

                            } else if (tipoVeiculo.equals("MOTO")) {
                                Moto moto = new Moto();
                                moto.cadastroMoto(tipoVeiculo);
                                listaVeiculos.add(moto);
                            }
                            break;
                        }catch (NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "Dado invalido! Tente novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    case 3:
                        Cliente clienteLocacao = new Cliente();
                        boolean clienteOK = clienteLocacao.isCliente(JOptionPane.showInputDialog("Qual cliente deseja locar o veículo? ").toUpperCase(), listaCliente);

                        if (clienteOK == true) {
                            try {
                                Locacao locacao = new Locacao();
                                locacao.locarVeiculo(listaVeiculos);
                            }catch (NumberFormatException e){
                                JOptionPane.showMessageDialog(null, "Dado invalido! Tente novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente não cadastrado, locação não autorizada!");
                        }
                        break;
                    case 4:
                        ArrayList<Veiculo> veiculosDisponiveis = new ArrayList<>();
                        ArrayList<Veiculo> veiculosLocados = new ArrayList<>();

                    for(int i = 0; i < listaVeiculos.size(); i++){
                        System.out.println( );
                        if(listaVeiculos.get(i).isVeiculoDisponivel()){
                            System.out.println(listaVeiculos.get(i));
                            veiculosDisponiveis.add(listaVeiculos.get(i));
                        } else{
                            veiculosLocados.add(listaVeiculos.get(i));
                        }
                    }
                    JOptionPane.showMessageDialog (null, "Lista de Clientes" + listaCliente);
                    JOptionPane.showMessageDialog (null, "Lista de Veiculos" + listaVeiculos);
                    JOptionPane.showMessageDialog (null, "Lista de veiculos Locados" + veiculosLocados);
                    JOptionPane.showMessageDialog (null, "Lista de veiculos Disponiveis" + veiculosDisponiveis);
                    break;
                case 5:
                    ManipuladorArquivo.gravarVeiculos(listaVeiculos);
                    ManipuladorArquivo.gravarClientes(listaCliente);
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Não é uma opção Invalida!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

