/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 631410161
 */
public class Conexao {

    public static Connection Conexao() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "123456";
        Connection connection = DriverManager.getConnection(url, usuario, senha);

//        if (connection == null) {
//            System.out.println("Fala na conexao!");
//        } else {
//            System.out.println("Conectado com sucesso!");
//        }
        return connection;
    }

}
