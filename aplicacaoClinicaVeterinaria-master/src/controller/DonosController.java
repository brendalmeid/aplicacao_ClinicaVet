/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.DonosModel;
import util.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Gamer
 */
public class DonosController {
    public boolean inserir (DonosModel dono){
        boolean retorno = false;
        
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO donos (nome, cpf, email, telefone, data_nascimento, created_at)VALUES (?,?,?,?,?,?)";
        
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            
            sentenca.setString(1, dono.getNome());
            sentenca.setString(2, dono.getCpf());
            sentenca.setString(3, dono.getEmail());
            sentenca.setString(4, dono.getNumero());
            sentenca.setDate(5, converterUtilDateParaSqlDate(converterStringParaDate(dono.getDataNascimento())));
            sentenca.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
            
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch(SQLException e){
            System.err.println("Erro ao inserir dono: " + e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    public boolean editar(DonosModel dono){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE donos set nome = ?, "
                + " cpf = ?, email = ?, telefone = ?, data_nascimento = ?WHERE id = ?";
        
        try{
           PreparedStatement sentenca =  c.con.prepareStatement(sql);
           
           sentenca.setString(1, dono.getNome());
           sentenca.setString(2, dono.getCpf());
           sentenca.setString(3, dono.getEmail());
           sentenca.setString(4, dono.getNumero());
           sentenca.setDate(5, converterUtilDateParaSqlDate(converterStringParaDate(dono.getDataNascimento())));
           sentenca.setInt(6, dono.getDonoId());
           
           if(!sentenca.execute()){
               retorno = true;
           }
        }catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public boolean excluir(DonosModel dono){
        boolean retorno = false;
        
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM donos WHERE id = ?";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1, dono.getDonoId());
            if(!sentenca.execute()){
                retorno = true;
            }
        }catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    
    public DonosModel selecionar(DonosModel dono){
        DonosModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT * FROM donos where id = ?";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1, dono.getDonoId());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
                retorno = new DonosModel();
                retorno.setDonoId(result.getInt("id"));
                retorno.setNome(result.getString("nome"));
                retorno.setCpf(result.getString("cpf"));
                retorno.setEmail(result.getString("email"));
                retorno.setNumero(result.getString("telefone"));
                retorno.setDataNascimento(converterDateParaString(result.getDate("data_nascimento"))); 
            }
        }catch(SQLException e){
          System.out.println("Erro na seleção: "+ e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    public ArrayList<DonosModel> selecionarTodos(){
        ArrayList<DonosModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT * FROM donos";
        
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                DonosModel d = new DonosModel();
                d.setDonoId(result.getInt("id"));
                d.setNome(result.getString("nome"));
                d.setCpf(result.getString("cpf"));
                d.setEmail(result.getString("email"));
                d.setNumero(result.getString("telefone"));
                d.setDataNascimento(converterDateParaString(result.getDate("data_nascimento"))); 
                
                retorno.add(d);
            }
        }catch(SQLException e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    
    
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
    
    public java.sql.Date converterUtilDateParaSqlDate(Date utilDate) {
        if (utilDate == null) {
            return null;
        }
        return new java.sql.Date(utilDate.getTime());
    }
    
    public String converterDateParaString(Date date) {
        if (date == null) {
            return null;
        }
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(date);
    }
}
