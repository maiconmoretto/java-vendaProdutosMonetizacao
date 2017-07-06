/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaprodutosmonetizacao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trash.Conexao;
import trash.Produto;

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

    public List<Produto> list() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            connection = Conexao.Conexao();
            statement = connection.prepareStatement("SELECT * FROM  produtos  ORDER BY idproduto");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setValor(resultSet.getInt("valor"));
                produto.add(produto);
            }
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
            }
        }

        return produtos;
    }

    public void cadastrarProduto(String nome, int valor, int quantidade) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "INSERT INTO  produtos (nome,valor,quantidade) VALUES ('" + nome + "', '" + valor + "' , '" + quantidade + "') ";
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
    
    public boolean deletarProdutoPorNome(String nome) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "DELETE FROM  produtos WHERE nome= '" + nome +"' ";
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
