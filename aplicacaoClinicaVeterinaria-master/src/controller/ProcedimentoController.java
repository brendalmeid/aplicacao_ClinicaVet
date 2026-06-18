/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.ProcedimentoModel;
import util.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProcedimentoController {

    public boolean inserir(ProcedimentoModel procedimento) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "INSERT INTO procedimentos (nome, valor_padrao, descricao) VALUES (?, ?, ?)";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setString(1, procedimento.getNome());
            sentenca.setFloat(2, procedimento.getValorPadrao());
            sentenca.setString(3, procedimento.getDescricao());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir procedimento: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public boolean editar(ProcedimentoModel procedimento) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "UPDATE procedimentos SET nome = ?, valor_padrao = ?, descricao = ? WHERE id = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setString(1, procedimento.getNome());
            sentenca.setFloat(2, procedimento.getValorPadrao());
            sentenca.setString(3, procedimento.getDescricao());
            sentenca.setInt(4, procedimento.getIdProcedimento());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar procedimento: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public boolean excluir(ProcedimentoModel procedimento) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "DELETE FROM procedimentos WHERE id = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, procedimento.getIdProcedimento());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir procedimento: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public ProcedimentoModel selecionar(ProcedimentoModel procedimento) {
        ProcedimentoModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT * FROM procedimentos WHERE id = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, procedimento.getIdProcedimento());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new ProcedimentoModel();
                retorno.setIdProcedimento(result.getInt("id"));
                retorno.setNome(result.getString("nome"));
                retorno.setValorPadrao(result.getFloat("valor_padrao"));
                retorno.setDescricao(result.getString("descricao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar procedimento: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public ArrayList<ProcedimentoModel> selecionarTodos() {
        ArrayList<ProcedimentoModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT * FROM procedimentos";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();

            while (result.next()) {
                ProcedimentoModel p = new ProcedimentoModel();
                p.setIdProcedimento(result.getInt("id"));
                p.setNome(result.getString("nome"));
                p.setValorPadrao(result.getFloat("valor_padrao"));
                p.setDescricao(result.getString("descricao"));
                retorno.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar procedimentos: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }
}