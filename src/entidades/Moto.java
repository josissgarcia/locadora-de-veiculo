package Entidades;

import javax.swing.*;
import java.io.Serializable;

public class Moto extends Veiculo implements Serializable {

    private static final long serialVersionUID = 6728311590034119026L;
    private boolean partidaEletrica;

    public Moto() { }

    public Moto(String tipo, double vlDiaria, String descricao, String identificacaoVeiculo,boolean veiculoDisponivel, boolean partidaEletrica) {
        super(tipo, vlDiaria, descricao, identificacaoVeiculo,veiculoDisponivel);
        this.partidaEletrica = partidaEletrica;
    }

    public boolean isPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    public Moto cadastroMoto(String tipo){
        this.setTipo(tipo);
        this.setVlDiaria(Double.parseDouble (JOptionPane.showInputDialog("Valor da diária: ")));
        this.setDescricao(JOptionPane.showInputDialog("Descreva a marca ou modelo: ").toUpperCase());
        this.setIdentificacaoVeiculo(JOptionPane.showInputDialog("Digite a placa do veículo: "));
        this.setVeiculoDisponivel(true);
        String partida = JOptionPane.showInputDialog("O motor tem partida elétrica( Sim ou Não) ?").toUpperCase();
        Boolean pBool = false;
        while(! partida.equals("SIM") && ! partida.equals("NAO") && ! partida.equals("NÃO")){
            partida = JOptionPane.showInputDialog("O motor tem partida elétrica( Sim ou Não) ?").toUpperCase();
        }
        if(partida.equals("SIM")){
            pBool = true;
        } else{
            pBool = false;
        }
        this.setPartidaEletrica(pBool);

        return this;

    }
}
