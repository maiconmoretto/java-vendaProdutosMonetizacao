/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaprodutosmonetizacao.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField;
import trash.Conexao;

/**
 *
 * @author Maicon Moretto
 */
public class Clientes {

    public void listarClientes() throws ClassNotFoundException, SQLException {

        Connection connection = Conexao.Conexao();

        String sql = "SELECT * FROM  clientes  ORDER BY idcliente";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);

        while (resultado.next()) {
            System.out.println("\nId: " + resultado.getInt("idcliente"));
            System.out.println("Nome: " + resultado.getString("nome"));
            System.out.println("email: " + resultado.getString("email"));
            System.out.println("cpf: " + resultado.getString("cpf"));
            System.out.println("data cadastro: " + resultado.getDate("data_cadastro"));
        }

    }

    public void cadastrarCliente(String nome, String email, String cpf) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "INSERT INTO  clientes (nome,email,cpf) VALUES ('" + nome + "', '" + email + "','" + cpf + "')";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }

    public boolean deletarCliente(int id) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "DELETE FROM  clientes WHERE idcliente= " + id;
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        return true;
    }

    public boolean editarCliente(String nome, String email, String cpf, int id) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "UPDATE  clientes SET nome = '" + nome + "' , email = '" + email + "' , cpf = '" + cpf + "' WHERE  idcliente = " + id;
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        return true;
    }


    public boolean deletarClientePorNome(String nome) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "DELETE FROM  clientes WHERE nome= '" + nome + "' ";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        return true;
    }

}
