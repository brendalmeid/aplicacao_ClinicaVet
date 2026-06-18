/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ServicosModel;
import util.Conexao;

/**
 *
 * @author italo
 */
public class ServicosController {
    public boolean inserir(ServicosModel servico){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO servicos (atendimento_id, procedimento_id, valor_cobrado, created_at) VALUES (?,?,?,?)";
        
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            
            sentenca.setInt(1, servico.getId_atendimento());
            sentenca.setInt(2, servico.getId_procedimento());
            sentenca.setFloat(3, servico.getValor_cobrado());
            sentenca.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
            
            if(!sentenca.execute()){
                retorno = true;
            }
        }catch(SQLException e){
            System.err.println("Erro ao criar servico: " + e.getMessage());

        }
        
        c.desconectar();
        return retorno;
    }
    
    public boolean editar(ServicosModel servico){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE servicos SET valor_cobrado = ? WHERE id = ?";
        
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            
            sentenca.setFloat(1, servico.getValor_cobrado());
            sentenca.setInt(2, servico.getId());
            
            if(!sentenca.execute()){
                retorno = true;
            }
        }catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }   
    
    public boolean excluir(ServicosModel servico){
        boolean retorno = false;
        
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM servicos WHERE id = ?";
        
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            
            sentenca.setInt(1, servico.getId());
            if(!sentenca.execute()){
                retorno = true;
            }
        }catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public ServicosModel selecionar (ServicosModel servico){
        ServicosModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM servicos WHERE id = ?";
        
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, servico.getId());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
                retorno = new ServicosModel();
                
                retorno.setId(result.getInt("id"));
                retorno.setId_atendimento(result.getInt("id_atendimento"));
                retorno.setId_procedimento(result.getInt("id_procedimento"));
                retorno.setValor_cobrado(result.getFloat("valor_cobrado"));
            }
        } catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public ArrayList<ServicosModel> selecionarTodos(){
       ArrayList<ServicosModel> retorno = new ArrayList<>();
       
       Conexao c = new Conexao();
       c.conectar();
       
       String sql = "SELECT * FROM servicos";
       
       try{
           PreparedStatement sentenca = c.conector.prepareStatement(sql);
           ResultSet result = sentenca.executeQuery();
           while(result.next()){
               ServicosModel s = new ServicosModel();
               s.setId(result.getInt("id"));
               s.setId_atendimento(result.getInt("id_atendimento"));
               s.setId_procedimento(result.getInt("id_procedimento"));
               s.setValor_cobrado(result.getFloat("valor_cobrado"));
               
               retorno.add(s);
           }
           
        } catch(SQLException e){
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
       
       c.desconectar();
       return retorno;
    }

    public ArrayList<ServicosModel> selecionarServicosPorAtendimentoId(int idAtendimento) {
        ArrayList<ServicosModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "SELECT id, atendimento_id, procedimento_id, valor_cobrado FROM servicos WHERE atendimento_id = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, idAtendimento);
            ResultSet result = sentenca.executeQuery();

            while (result.next()) {
                ServicosModel s = new ServicosModel();
                s.setId(result.getInt("id"));
                s.setId_atendimento(result.getInt("atendimento_id"));
                s.setId_procedimento(result.getInt("procedimento_id"));
                s.setValor_cobrado(result.getFloat("valor_cobrado"));
                retorno.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar serviços por atendimento: " + e.getMessage());
        } finally {
            c.desconectar();
        }
        return retorno;
    }

}


