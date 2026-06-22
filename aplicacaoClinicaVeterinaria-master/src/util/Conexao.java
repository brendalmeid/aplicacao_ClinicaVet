package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Italo
 */
public class Conexao {
    public Connection con;

    public void conectar() {
        //DRIVER
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //URL
            String url = "jdbc:mysql://localhost:/AplicacaoClinicaVet";
            //USUARIO
            String usuario = "root";
            //SENHA
            String senha = "root";
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com banco: " + e.getMessage());
        }
    }

    public void desconectar()
    {
        try
        {
            con.close();
        }catch(SQLException e)
        {
            System.out.println("Erro ao fechar conexao: "+ e.getMessage());
        }
    }
}

