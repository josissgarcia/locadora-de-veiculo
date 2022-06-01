package Entidades;

public class Veiculo {
    private String tipo;
    private double vlDiaria;
    private String descricao;
    private String identificacaoVeiculo;
    private boolean veiculoDisponivel;

    public Veiculo (){}

    public Veiculo(String tipo, double vlDiaria, String descricao, String identificacaoVeiculo, boolean veiculoDisponivel) {
        this.tipo = tipo;
        this.vlDiaria = vlDiaria;
        this.descricao = descricao;
        this.identificacaoVeiculo = identificacaoVeiculo;
        this.veiculoDisponivel = veiculoDisponivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getVlDiaria() {
        return vlDiaria;
    }

    public void setVlDiaria(double vlDiaria) {
        this.vlDiaria = vlDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentificacaoVeiculo() {
        return identificacaoVeiculo;
    }

    public boolean isVeiculoDisponivel() { return veiculoDisponivel; }

    public void setVeiculoDisponivel(boolean veiculoDisponivel) {
        this.veiculoDisponivel = veiculoDisponivel;
    }

    public void setIdentificacaoVeiculo(String identificacaoVeiculo) {
        this.identificacaoVeiculo = identificacaoVeiculo;

    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "\ntipo='" + tipo + '\'' +
                ", vlDiaria=" + vlDiaria +
                ", descricao='" + descricao + '\'' +
                ", identificacaoVeiculo='" + identificacaoVeiculo + '\'' +
                ", veiculoDisponivel=" + veiculoDisponivel +
                '}';
    }
}
