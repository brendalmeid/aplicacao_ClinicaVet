package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Italo
 */
public class Conexao {
    public Connection conector;

    private static final String HOST = "134.199.222.200";
    private static final String PORT = "5432";
    private static final String DATABASE_NAME = "vet_clinic";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin123";

    private static final String URL = String.format(
        "jdbc:postgresql://%s:%s/%s?sslmode=disable",
        HOST, PORT, DATABASE_NAME
    );

    public void conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            
            conector = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Aplicação conectada com Banco PostgreSQL!");
        }catch(ClassNotFoundException e){
            System.err.println("Driver não encontrado! Verifique se o JAR do PostgreSQL JDBC está nas bibliotecas do projeto. " + e.getMessage());
        }catch(SQLException e){
            System.err.println("Erro na conexão com banco PostgreSQL! " + e.getMessage());
        }
    }

    public void desconectar(){
        try{
            if (conector != null && !conector.isClosed()) { 
                conector.close();
                System.out.println("Conexão com Banco PostgreSQL encerrada!");
            }
        }catch(SQLException e){
            System.err.println("Erro ao fechar conexão! " + e.getMessage());
        }
    }
}