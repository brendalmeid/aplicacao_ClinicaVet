/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gamer
 */
public class DonosModel {
    int donoId;
    String nome, numero, cpf, dataNascimento, email;
    
    public DonosModel(int donoId, String nome, String numero, String cpf, String dataNascimento, String email){
        this.donoId = donoId;
        this.nome = nome;
        this.numero = numero;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }
    
    public DonosModel(){
        donoId = 0;
        nome = "";
        numero = "";
        cpf = "";
        dataNascimento = "";
        email = "";
    }

    public void setDonoId(int donoId) {
        this.donoId = donoId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDonoId() {
        return donoId;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }
    
    
    
    
}
