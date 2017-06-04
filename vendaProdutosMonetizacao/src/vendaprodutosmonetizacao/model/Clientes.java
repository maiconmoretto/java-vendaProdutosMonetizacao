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
import vendaprodutosmonetizacao.Cliente;
import vendaprodutosmonetizacao.Conexao;

/**
 *
 * @author Maicon Moretto
 */
public class Clientes {

    public List<Cliente> listarClientes() throws ClassNotFoundException, SQLException {

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
        List<Cliente> clientes = new ArrayList<Cliente>();
        while (resultado.next()) {
            Cliente cliente = new Cliente();
            cliente.setNome(resultado.getString("nome_do_cliente"));
            clientes.add(cliente);
        }
        resultado.close();
        return clientes;
    }

    public void cadastrarCliente(String nome, String email, String cpf) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
//        Statement stmt = null;
        String sql = "INSERT INTO  clientes (nome,email,cpf) VALUES ('" + nome + "', '" + email + "','" + cpf + "')";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }

    public boolean deletarCliente(int id) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "DELETE FROM  clientes WHERE idcliente= " + id;
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        //        if (resultado) {
//            return true;
//        } else {
//            return false;
//        }
        return true;
    }

    public boolean editarCliente(String nome, String email, String cpf, int id) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "UPDATE  clientes SET nome = '" + nome + "' , email = '" + email + "' , cpf = '" + cpf + "' WHERE  idcliente = " + id;
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);

        return true;
    }

}
