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

        String sql = "SELECT * FROM  clientes ";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);

        while (resultado.next()) {
            System.out.println("Id: " + resultado.getInt("idcliente"));
            System.out.println("Nome: " + resultado.getString("nome"));
        }
        List<Cliente> clientes = new ArrayList<Cliente>();
        while (resultado.next()) {
            Cliente cliente = new Cliente();
            cliente.setNome(resultado.getString("nome_do_cliente"));
            //Preenche o resto do objeto...

            clientes.add(cliente);
        }
        resultado.close();
        return clientes;
    }

    public void  cadastrarCliente() throws ClassNotFoundException, SQLException {

        Connection connection = Conexao.Conexao();
        Statement stmt = null;
        String query = "INSERT INTO  clientes (nome) VALUES ('maicon123')";

        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

//        String sql = "INSERT INTO  clientes (nome) VALUES ('maicon')";
//        Statement comando = connection.createStatement();
//        ResultSet resultado = comando.executeQuery(sql);
        rs.close();
//        if (resultado) {
//            return true;
//        } else {
//            return false;
//        }
   
    }

    public boolean deletarCliente() throws ClassNotFoundException, SQLException {

        Connection connection = Conexao.Conexao();

        String sql = "DELETE FROM  clientes WHERE id= ?";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
        //        if (resultado) {
//            return true;
//        } else {
//            return false;
//        }
        return true;
    }

    public boolean editarCliente() throws ClassNotFoundException, SQLException {

        Connection connection = Conexao.Conexao();

        String sql = "UPDATE  clientes SET ";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);
//        if (resultado) {
//            return true;
//        } else {
//            return false;
//        }
        return true;
    }

}
