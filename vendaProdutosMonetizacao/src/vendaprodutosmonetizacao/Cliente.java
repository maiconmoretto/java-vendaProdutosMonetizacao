/*
 Cadastro de clientes: para cada cliente anota-se o CPF, nome e email. 

 */
package vendaprodutosmonetizacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 631410161
 */
public class Cliente {

    private String cpf;
    private String nome;
    private String email;
    private String conta;

//    public Cliente(String cpf, String nome, String email, String conta) {
//        this.cpf = cpf;
//        this.nome = nome;
//        this.email = email;
//        this.conta = conta;
//    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String listaClientes() throws SQLException, ClassNotFoundException {

        Connection connection = Conexao.Conexao();

        String sql = "SELECT * FROM  usuarios ";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);

        while (resultado.next()) {
            System.out.println("Id: " + resultado.getInt("idusuario"));
            System.out.println("Nome: " + resultado.getString("nome"));
        }
        return null;
    }

}
