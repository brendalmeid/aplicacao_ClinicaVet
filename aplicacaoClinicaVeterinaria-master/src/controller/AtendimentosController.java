/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.AtendimentosModel;
import util.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author italo
 */
public class AtendimentosController {
    public boolean inserir(AtendimentosModel atendimento){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO atendimentos (pet_id, medico_id, data_hora, status, motivo_visita, diagnostico_final, created_at)VALUES (?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            
            sentenca.setInt(1, atendimento.getPet_id());
            sentenca.setInt(2, atendimento.getMedico_id());
            sentenca.setDate(3, converterUtilDateParaSqlDate(converterStringParaDate(atendimento.getData())));
            sentenca.setString(4, atendimento.getStatus());
            sentenca.setString(5, atendimento.getMotivo_visita());
            sentenca.setString(6, atendimento.getDiagnostico_final());
            sentenca.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
            
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch(SQLException e){
            System.err.println("Erro ao cadastrar atendimento: " + e.getMessage());
        }
        
        
        
        c.desconectar();
        return retorno;
    }
    
    public boolean editar(AtendimentosModel atendimento){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE atendimentos SET pet_id = ?, "
                + "medico_id = ?, data_hora = ?, status = ?, motivo_visita = ?, diagnostico_final = ?"
                + " WHERE id = ?";
        
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            
            sentenca.setInt(1, atendimento.getPet_id());
            sentenca.setInt(2, atendimento.getMedico_id());
            sentenca.setDate(3, converterUtilDateParaSqlDate(converterStringParaDate(atendimento.getData())));
            sentenca.setString(4, atendimento.getStatus());
            sentenca.setString(5, atendimento.getMotivo_visita());
            sentenca.setString(6, atendimento.getDiagnostico_final());
            sentenca.setInt(7,atendimento.getId());
            
            if(!sentenca.execute()){
                retorno = true;
            }
                 
        } catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    
    public boolean excluir(AtendimentosModel atendimento){
        boolean retorno = false;
        
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM atendimentos WHERE id = ?";
        
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, atendimento.getId());
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    public AtendimentosModel selecionar(AtendimentosModel atendimento){
        AtendimentosModel retorno = null;
        
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM atendimentos WHERE id = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, atendimento.getId());
            
            ResultSet result = sentenca.executeQuery();
            
            if(result.next()){
                retorno = new AtendimentosModel();
                retorno.setId(result.getInt("id"));
                retorno.setPet_id(result.getInt("pet_id"));
                retorno.setMedico_id(result.getInt("medico_id"));
                retorno.setData(converterDateParaString(result.getDate("data_hora")));
                retorno.setStatus(result.getString("status"));
                retorno.setMotivo_visita(result.getString("motivo_visita"));
                retorno.setDiagnostico_final(result.getString("diagnostico_final"));

            }
        }catch (SQLException e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    
    public ArrayList<AtendimentosModel> selecionarTodos(){
        ArrayList<AtendimentosModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM atendimentos";
        
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            
            while(result.next()){
                AtendimentosModel a = new AtendimentosModel();
                a.setId(result.getInt("id"));
                a.setPet_id(result.getInt("pet_id"));
                a.setMedico_id(result.getInt("medico_id"));
                a.setData(converterDateParaString(result.getDate("data_hora")));
                a.setStatus(result.getString("status"));
                a.setMotivo_visita(result.getString("motivo_visita"));
                a.setDiagnostico_final(result.getString("diagnostico_final"));
                
                retorno.add(a);
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    
    /**
     * Converte uma string no formato dd/MM/yyyy para java.util.Date
     * @param dataString String no formato dd/MM/yyyy (ex: "11/05/2023")
     * @return java.util.Date ou null se houver erro na conversão
     */
    public Date converterStringParaDate(String dataString) {
        if (dataString == null || dataString.trim().isEmpty()) {
            return null;
        }
        
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false); // Não aceita datas inválidas
            return formato.parse(dataString);
        } catch (ParseException e) {
            System.err.println("Erro ao converter string para date: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Converte java.util.Date para java.sql.Date (apenas data, sem horário)
     * @param utilDate java.util.Date
     * @return java.sql.Date
     */
    public java.sql.Date converterUtilDateParaSqlDate(Date utilDate) {
        if (utilDate == null) {
            return null;
        }
        return new java.sql.Date(utilDate.getTime());
    }
    
    /**
     * Converte java.util.Date para String no formato dd/MM/yyyy
     * @param date java.util.Date
     * @return String no formato dd/MM/yyyy ou null se date for null
     */
    public String converterDateParaString(Date date) {
        if (date == null) {
            return null;
        }
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(date);
    }
}
