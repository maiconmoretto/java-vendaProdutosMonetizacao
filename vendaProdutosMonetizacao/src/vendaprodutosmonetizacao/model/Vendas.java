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
import trash.Conexao;

/**
 *
 * @author Maicon Moretto
 */
public class Vendas {

    public void venda(int numero, int idproduto) throws ClassNotFoundException, SQLException {
        int valor = 0;
        Connection conn = Conexao.Conexao();

        String sql = "SELECT nome FROM produtos  WHERE idproduto  = '" + idproduto + "' ";
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery(sql);

        if (resultado.next()) {

            sql = "SELECT * FROM "
                    + " cliente_conta  cc INNER JOIN clientes c ON c.idcliente = cc.idcliente WHERE numero  = '" + numero + "' ";
            statement = conn.createStatement();
            resultado = statement.executeQuery(sql);

            if (resultado.next()) {
                int saldoAtual = resultado.getInt("saldo");
                String nome_cliente = resultado.getString("nome");

                sql = "SELECT valor FROM produtos WHERE  idproduto =  " + idproduto;
                statement = conn.createStatement();
                resultado = statement.executeQuery(sql);;

                if (resultado.next()) {
                    valor = resultado.getInt("valor");
                }

                if (saldoAtual >= valor) {
                    int diferenca = saldoAtual - valor;
                    //debita da conta do debitado tem saldo
                    sql = "UPDATE cliente_conta SET saldo = " + diferenca + " WHERE numero  = '" + numero + "' ";
                    statement.executeUpdate(sql);
                    System.out.println("debitado valor com sucesso");

                    sql = "SELECT nome FROM produtos  WHERE idproduto  = '" + idproduto + "' ";
                    statement = conn.createStatement();
                    resultado = statement.executeQuery(sql);

                    if (resultado.next()) {
                        String produto = resultado.getString("nome");
                        sql = "DELETE  FROM produtos   WHERE idproduto  = '" + idproduto + "' ";
                        statement = conn.createStatement();
                        statement.executeUpdate(sql);

                        System.out.println("produto retirado da  venda");

                        sql = "INSERT INTO historico_venda (nome_cliente,produto)   VALUES ('" + nome_cliente + "', '" + produto + "' )";
                        statement = conn.createStatement();
                        statement.executeUpdate(sql);
                        System.out.println("historico salvo");

                    } else {
                        System.out.println("nao existe este produto : " + idproduto);
                    }

                } else {
                    System.out.println("venda  nao foi realizada, saldo insuficiente");
                }
            } else {
                System.out.println("nao existe este numero de  conta  : " + numero);
            }
        } else {
            System.out.println("nao existe este produto : " + idproduto);
        }

    }

    public void listarVendas() throws ClassNotFoundException, SQLException {

        Connection connection = Conexao.Conexao();

        String sql = "SELECT * FROM  historico_venda  ORDER BY id_venda";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);

        while (resultado.next()) {
            System.out.println("\nId: " + resultado.getInt("id_venda"));
            System.out.println("nome cliente: " + resultado.getString("nome_cliente"));
            System.out.println(" produto: " + resultado.getString("produto"));
            System.out.println("data cadastro: " + resultado.getDate("data_cadastro"));
        }

    }

}
