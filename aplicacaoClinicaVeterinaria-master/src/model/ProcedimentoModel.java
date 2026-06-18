package model;

/**
 *
 * @author Cris
 */
public class ProcedimentoModel {
    private int idProcedimento;
    private float valorPadrao;
    private String nome, descricao;

    public ProcedimentoModel(int idProcedimeto, float valorPadrao, String nome, String descricao) {
        this.idProcedimento = idProcedimeto;
        this.nome = nome;
        this.valorPadrao = valorPadrao;
        this.descricao = descricao;
    }

    public ProcedimentoModel(){
        idProcedimento = 0;
        nome = "";
        valorPadrao = 0;
        descricao = "";
    }

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public float getValorPadrao() {
        return valorPadrao;
    }

    public void setValorPadrao(float valorPadrao) {
        this.valorPadrao = valorPadrao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
  
}
