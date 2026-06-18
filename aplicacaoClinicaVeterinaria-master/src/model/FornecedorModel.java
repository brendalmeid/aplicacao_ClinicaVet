
package model;

/**
 *
 * @author Cris
 */
public class FornecedorModel {
    private int idFornecedor;
    private String cnpj,razaoSocial,endereco;

    public FornecedorModel(int idFornecedor, String cnpj, String razaoSocial, String endereco) {
        this.idFornecedor = idFornecedor;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    public FornecedorModel(){
        idFornecedor = 0;
        cnpj = "";
        razaoSocial = "";
        endereco = "";
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
