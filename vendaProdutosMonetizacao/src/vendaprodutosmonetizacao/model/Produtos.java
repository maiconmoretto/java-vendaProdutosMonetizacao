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
import vendaprodutosmonetizacao.Conexao;

/**
 *
 * @author Maicon Moretto
 */
public class Produtos {

    public void listarProdutos() throws ClassNotFoundException, SQLException {

        Connection connection = Conexao.Conexao();

        String sql = "SELECT * FROM  produtos  ORDER BY idproduto";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
      
            while (resultado.next()) {
                System.out.println("\nId: " + resultado.getInt("idproduto"));
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("valor: " + resultado.getInt("valor"));
                System.out.println("data cadastro: " + resultado.getDate("data_cadastro"));
            }
    
    }

    public void cadastrarProduto(String nome, int valor) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "INSERT INTO  produtos (nome,valor) VALUES ('" + nome + "', '" + valor + "')";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }

    public boolean deletarProduto(int id) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "DELETE FROM  produtos WHERE idproduto= " + id;
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        return true;
    }

    public boolean editarProduto(String nome, int valor, int id) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "UPDATE  produtos SET nome = '" + nome + "' , valor = '" + valor + "' WHERE  idproduto = " + id;
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        return true;
    }

}
