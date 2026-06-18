package model;

/**
 *
 * @author Cris
 */
public class MedicoModel {
    private int idMedico, crmv;
    private String nome,email, dataNascimento, telefone, situacao;

    public MedicoModel(int idMedico, String nome, int crmv, String email, String dataNascimento, String telefone, String situacao) {
        this.idMedico = idMedico;
        this.nome = nome;
        this.crmv = crmv;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.situacao = situacao;
    }

    public MedicoModel(){
        idMedico = 0;
        nome = "";
        crmv = 0;
        email = "";
        dataNascimento = "";
        telefone = "";
        situacao = "";
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCrmv() {
        return crmv;
    }

    public void setCrmv(int crmv) {
        this.crmv = crmv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
  
}
