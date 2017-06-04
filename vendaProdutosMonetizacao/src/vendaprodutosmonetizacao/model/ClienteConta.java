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
import vendaprodutosmonetizacao.ContaCliente;

/**
 *
 * @author Maicon Moretto
 */
public class ClienteConta {

    public List<ContaCliente> listarContas() throws ClassNotFoundException, SQLException {

        Connection connection = Conexao.Conexao();

        String sql = "SELECT * FROM  cliente_conta  ORDER BY id_conta";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);

        while (resultado.next()) {
            System.out.println("\nId: " + resultado.getInt("idcliente"));
            System.out.println("saldo: " + resultado.getInt("saldo"));
            System.out.println("numero: " + resultado.getInt("numero"));
            System.out.println("data cadastro: " + resultado.getDate("data_cadastro"));
        }
        List<ContaCliente> contas = new ArrayList<ContaCliente>();
        while (resultado.next()) {
            ContaCliente conta = new ContaCliente();
            conta.setConta(resultado.getString("numero"));
            conta.setSaldo(resultado.getInt("saldo"));
            contas.add(conta);
        }
        resultado.close();
        return contas;
    }

    public void cadastrarConta(int idcliente, int saldo, int numero) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();

        String sql = "INSERT INTO  cliente_conta (idcliente,saldo,numero) VALUES (" + idcliente + ", " + saldo + "," + numero + ")";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }

    public void deposito(int valor, int numero) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();

        String sql = "SELECT saldo FROM cliente_conta  WHERE numero  = '" + numero + "' ";
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        if (resultado.next()) {
            int saldoAtual = resultado.getInt("saldo");
            int total = saldoAtual + valor;
            sql = "UPDATE cliente_conta SET saldo = " + total + " WHERE numero  = '" + numero + "' ";
            statement.executeUpdate(sql);
            System.out.println("deposito  realizado com sucesso");
        }

    }

    public void saque(int valor, int numero) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();

        String sql = "SELECT saldo FROM cliente_conta  WHERE numero  = '" + numero + "' ";
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery(sql);

        if (resultado.next()) {
            int saldoAtual = resultado.getInt("saldo");

            if (saldoAtual >= valor) {
                int diferenca = saldoAtual - valor;
                sql = "UPDATE cliente_conta SET saldo = " + diferenca + " WHERE numero  = '" + numero + "' ";
                statement.executeUpdate(sql);
                System.out.println("saque  realizado com sucesso");
            } else {
                System.out.println("saque  nao foi realizado, saldo insuficiente");
            }
        }

    }

    public void saldo(int numero) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();
        String sql = "SELECT saldo FROM cliente_conta  WHERE numero  = '" + numero + "' ";
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        if (resultado.next()) {
            System.out.println("saldo: " + resultado.getInt("saldo"));
        }
    }

    public void tranferencia(int valor, int numeroCreditado, int numeroDebitado) throws ClassNotFoundException, SQLException {

        Connection conn = Conexao.Conexao();

        String sql = "SELECT saldo FROM cliente_conta  WHERE numero  = '" + numeroDebitado + "' ";
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery(sql);

        if (resultado.next()) {
            int saldoAtual = resultado.getInt("saldo");

            if (saldoAtual >= valor) {
                int diferenca = saldoAtual - valor;
                sql = "UPDATE cliente_conta SET saldo = " + diferenca + " WHERE numero  = '" + numeroCreditado + "' ";
                statement.executeUpdate(sql);
                System.out.println("debitado valor com sucesso");
                sql = "UPDATE cliente_conta SET saldo = " + valor + " WHERE numero  = '" + numeroDebitado + "' ";
                statement.executeUpdate(sql);
                System.out.println("creditado valor com sucesso");
            } else {
                System.out.println("transferencia  nao foi realizada, saldo insuficiente");
            }
        }

    }

}
