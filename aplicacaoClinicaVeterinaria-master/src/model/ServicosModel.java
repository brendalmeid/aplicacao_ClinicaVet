/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author italo
 */
public class ServicosModel {
    private int id, id_atendimento, id_procedimento;
    private float valor_cobrado;
    
    public ServicosModel(int id, int id_atendimento, int id_procedimento, float valor_cobrado){
        this.id = id;
        this.id_atendimento = id_atendimento;
        this.id_procedimento = id_procedimento;
        this.valor_cobrado = valor_cobrado;
    }   
    
    public ServicosModel(){
        id = 0;
        id_procedimento = 0;
        id_atendimento = 0;
        valor_cobrado = 0.0f;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public void setId_procedimento(int id_procedimento) {
        this.id_procedimento = id_procedimento;
    }

    public void setValor_cobrado(float valor_cobrado) {
        this.valor_cobrado = valor_cobrado;
    }

    public int getId() {
        return id;
    }

    public int getId_atendimento() {
        return id_atendimento;
    }

    public int getId_procedimento() {
        return id_procedimento;
    }

    public float getValor_cobrado() {
        return valor_cobrado;
    }
    
    
    
}
