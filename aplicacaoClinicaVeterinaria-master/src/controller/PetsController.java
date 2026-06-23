/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.PetsModel;
import util.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Ferreiro
 */
public class PetsController {
    public boolean inserir(PetsModel pet){
        boolean retorno = false;
        
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO pets (dono_id, nome, especie, raca, sexo, data_nascimento, peso, observacoes, created_at)values (?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            
            sentenca.setInt(1, pet.getDonoId());
            sentenca.setString(2, pet.getNome());
            sentenca.setString(3, pet.getEspecie());
            sentenca.setString(4, pet.getRaca());
            sentenca.setString(5, pet.getSexo());
            sentenca.setDate(6, converterUtilDateParaSqlDate(converterStringParaDate(pet.getDataNascimento())));
            sentenca.setFloat(7, pet.getPeso());
            sentenca.setString(8, pet.getObservacoes());
            sentenca.setTimestamp(9, new java.sql.Timestamp(System.currentTimeMillis()));
            
            if (!sentenca.execute()) {
                retorno = true;
            }
            
        }catch(SQLException e){
            System.err.println("Erro ao inserir pet: " + e.getMessage());
        } finally {
            c.desconectar();
        }
        
        return retorno;
    }
    
    public boolean editar(PetsModel pet){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE pets set dono_id = ?, "
                + "nome = ?, especie = ?, raca = ?, sexo = ?, data_nascimento = ?, "
                + "peso = ?, observacoes = ? WHERE id = ? ";
        
        try {
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            
            sentenca.setInt(1, pet.getDonoId());
            sentenca.setString(2, pet.getNome());
            sentenca.setString(3, pet.getEspecie());
            sentenca.setString(4, pet.getRaca());
            sentenca.setString(5, pet.getSexo());
            sentenca.setDate(6, converterUtilDateParaSqlDate(converterStringParaDate(pet.getDataNascimento())));
            sentenca.setFloat(7, pet.getPeso());
            sentenca.setString(8, pet.getObservacoes());
            sentenca.setInt(9, pet.getPetId());
            
            if(!sentenca.execute()){
                retorno = true;
            }
                    
        } catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    
    public boolean excluir(PetsModel pet){
        boolean retorno = false;
        
        Conexao c = new Conexao();
        c.conectar();

        String sql = "DELETE FROM pets WHERE id = ?";
        try {
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1, pet.getPetId());
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    
    public PetsModel selecionar (PetsModel pet){
        PetsModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT * FROM pets where id = ?";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1, pet.getPetId());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
                retorno = new PetsModel();
                retorno.setIdPet(result.getInt("id"));
                retorno.setDono_id(result.getInt("dono_id"));
                retorno.setNome(result.getString("nome"));
                retorno.setEspecie(result.getString("especie"));
                retorno.setRaca(result.getString("raca"));
                retorno.setSexo(result.getString("sexo"));
                retorno.setDataNascimento(converterDateParaString(result.getDate("data_nascimento")));
                retorno.setPeso(result.getFloat("peso"));
                retorno.setObservacoes(result.getString("observacoes"));
                
                
            }
        } catch (SQLException e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public ArrayList<PetsModel> selecionarTodos() {
        ArrayList<PetsModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT * FROM pets";
        
        try {
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                PetsModel p = new PetsModel();
                p.setIdPet(result.getInt("id"));
                p.setDono_id(result.getInt("dono_id"));
                p.setNome(result.getString("nome"));
                p.setEspecie(result.getString("especie"));
                p.setRaca(result.getString("raca"));
                p.setSexo(result.getString("sexo"));
                p.setDataNascimento(converterDateParaString(result.getDate("data_nascimento")));
                p.setPeso(result.getFloat("peso"));
                p.setObservacoes(result.getString("observacoes"));
                
                retorno.add(p);
            }       
        } catch(SQLException e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        
        c.desconectar();
        return retorno;
        
    }
    
    
    
    
    
    public static Date stringParaDate(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = null;
        
        try {
            dataFormatada = formato.parse(data);
        } catch (ParseException e) {
            System.err.println("Erro ao converter string para date: " + e.getMessage());
        }
        
        return dataFormatada;
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
