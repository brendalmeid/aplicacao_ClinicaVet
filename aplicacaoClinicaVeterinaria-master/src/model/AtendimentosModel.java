/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author italo
 */
public class AtendimentosModel {
    private int id, pet_id, medico_id;
    private String status, motivo_visita, diagnostico_final, data;
    
    public AtendimentosModel(int id, int pet_id, int medico_id, String status, String motivo_visita, String diagnostico_final, String data){
        this.id = id;
        this.medico_id = medico_id;
        this.pet_id = pet_id;
        this.status = status;
        this.motivo_visita = motivo_visita;
        this.diagnostico_final = diagnostico_final;
        this.data = data;
    }
    
    public AtendimentosModel(){
        id = 0;
        medico_id = 0;
        pet_id = 0;
        status = "";
        motivo_visita = "";
        diagnostico_final = "";
        data = "";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMotivo_visita(String motivo_visita) {
        this.motivo_visita = motivo_visita;
    }

    public void setDiagnostico_final(String diagnostico_final) {
        this.diagnostico_final = diagnostico_final;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public int getMedico_id() {
        return medico_id;
    }

    public String getStatus() {
        return status;
    }

    public String getMotivo_visita() {
        return motivo_visita;
    }

    public String getDiagnostico_final() {
        return diagnostico_final;
    }

    public String getData() {
        return data;
    }
    
    
    
}
