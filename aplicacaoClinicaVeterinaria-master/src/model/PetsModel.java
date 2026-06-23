/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ferreiro
 */
public class PetsModel {
    private int idPet, dono_id;
    private String nome, especie, sexo, raca, observacoes, dataNascimento;
    private Float peso;
    
    public PetsModel(int idPet, int dono_id, String nome, String especie, String sexo, String raca, String observacoes, String dataNascimento, Float peso){
        this.idPet = idPet;
        this.dono_id = dono_id;
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
        this.raca = raca;
        this.observacoes = observacoes;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
    }
    
    public PetsModel(){
        idPet = 0;
        dono_id = 0;
        nome = "";
        especie = "";
        sexo = "";
        raca = "";
        observacoes = "";
        peso = 0.0f;
        dataNascimento = "";
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }
    

    public void setDono_id(int dono_id) {
        this.dono_id = dono_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    
    
    
    
    public int getPetId(){
        return idPet;
    } 
    
    public int getDonoId(){
        return dono_id;
    } 

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getSexo() {
        return sexo;
    }

    public String getRaca() {
        return raca;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Float getPeso() {
        return peso;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    
    
     
}
