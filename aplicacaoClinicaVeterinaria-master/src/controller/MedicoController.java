/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MedicoModel;
import util.Conexao;

/**
 *
 * @author Cris
 */
public class MedicoController {

    public boolean inserir(MedicoModel medico) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "INSERT INTO medicos (nome, crmv, email, data_nascimento, telefone, ativo) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setString(1, medico.getNome());
            sentenca.setInt(2, medico.getCrmv());
            sentenca.setString(3, medico.getEmail());
            sentenca.setDate(4, java.sql.Date.valueOf(medico.getDataNascimento()));
            sentenca.setString(5, medico.getTelefone());
            sentenca.setBoolean(6, medico.getSituacao().equalsIgnoreCase("Ativo"));

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public boolean editar(MedicoModel medico) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "UPDATE medicos SET nome = ?, crmv = ?, email = ?, data_nascimento = ?, telefone = ?, ativo = ? WHERE id = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setString(1, medico.getNome());
            sentenca.setInt(2, medico.getCrmv());
            sentenca.setString(3, medico.getEmail());
            sentenca.setDate(4, java.sql.Date.valueOf(medico.getDataNascimento()));
            sentenca.setString(5, medico.getTelefone());
            sentenca.setBoolean(6, medico.getSituacao().equalsIgnoreCase("Ativo"));
            sentenca.setInt(7, medico.getIdMedico());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar médico: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public boolean excluir(MedicoModel medico) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "DELETE FROM medicos WHERE id = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, medico.getIdMedico());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir médico: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public MedicoModel selecionar(MedicoModel medico) {
        MedicoModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT * FROM medicos WHERE id = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, medico.getIdMedico());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new MedicoModel();
                retorno.setIdMedico(result.getInt("id"));
                retorno.setNome(result.getString("nome"));
                retorno.setCrmv(result.getInt("crmv"));
                retorno.setEmail(result.getString("email"));
                retorno.setDataNascimento(result.getString("data_nascimento"));
                retorno.setTelefone(result.getString("telefone"));
                retorno.setSituacao(result.getBoolean("ativo") ? "Ativo" : "Inativo");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar médico: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public ArrayList<MedicoModel> selecionarTodos() {
        ArrayList<MedicoModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT * FROM medicos";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();

            while (result.next()) {
                MedicoModel m = new MedicoModel();
                m.setIdMedico(result.getInt("id"));
                m.setNome(result.getString("nome"));
                m.setCrmv(result.getInt("crmv"));
                m.setEmail(result.getString("email"));
                m.setDataNascimento(result.getString("data_nascimento"));
                m.setTelefone(result.getString("telefone"));
                m.setSituacao(result.getBoolean("ativo") ? "Ativo" : "Inativo");
                retorno.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar médicos: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }
    
}

