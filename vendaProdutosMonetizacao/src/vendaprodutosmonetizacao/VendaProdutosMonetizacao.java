package vendaprodutosmonetizacao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Console;
import vendaprodutosmonetizacao.Conexao;
import vendaprodutosmonetizacao.model.ClienteConta;
import vendaprodutosmonetizacao.model.Clientes;

/**
 *
 * @author 631410161
 *
 * Tema 4: Venda de Produtos por Monetização
 *
 * Funcionalidades:
 *
 * - Cadastro de clientes: para cada cliente anota-se o CPF, nome e email. Além
 * disso, o cliente deve ter uma conta para realizar a compra de produtos. Para
 * a conta, anota-se o número e o saldo.
 *
 * - Cadastro de produtos: produto possui código, nome e preço.
 *
 * - Operações de monetização: o cliente poderá realizar operações de
 * monetização para creditar na sua conta e ver seu saldo. As operações são
 * depósito, transferência e visualizar o saldo. O depósito seria simulado.
 *
 * - Venda de produtos com monetização: na venda registra-se o código, a data e
 * hora que foi realizada, o cliente e os produtos e quantidade desses que foi
 * vendida. O sistema deverá calcular o total e ao finalizar a venda, deverá ser
 * debitado da conta do cliente, caso este tenha crédito.
 *
 * - Relatórios de vendas: produtos vendidos, compras feito pelo cliente,
 * clientes que mais compram, clientes que mais realizam operações de
 * monetização
 */
public class VendaProdutosMonetizacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        try {

        Clientes clientes = new Clientes();
        ClienteConta conta = new ClienteConta();

        ArrayList<RelatorioVenda> listarHistorico = new ArrayList<>();
        ArrayList<Cliente> listarClientes = new ArrayList<>();
        ArrayList<Produto> listarProdutos = new ArrayList<>();
        ArrayList<ContaCliente> listarContasClientes = new ArrayList<>();

        String nome, email, cpf;
        int id, saldo, numero, valor, numeroCreditado, numeroDebitado;
        //inicio loop menu
        int op = 0;
        do {

            System.out.println("\nMenu:");
            System.out.println("1- Novo Cliente");
            System.out.println("2- Todos Clientes");
            System.out.println("3- Editar Clientes");
            System.out.println("4- Excluir Clientes");
            System.out.println("5- Nova conta");
            System.out.println("6- Todas contas");
            System.out.println("7- Saldo ");
            System.out.println("8- Saque ");
            System.out.println("9- Tranferencia ");
            System.out.println("10- Deposito ");
            System.out.println("11- Sairs ");

            try {
                op = Console.scanInt("Opcao: ");

                switch (op) {
                    case 1:
                        System.out.println("Cadastro de Clientes");
                        nome = Console.scanString("nome: ");
                        email = Console.scanString("email: ");
                        cpf = Console.scanString("cpf: ");
                        clientes.cadastrarCliente(nome, email, cpf);
                        break;
                    case 2:
                        System.out.println("Lista de Clientes");
                        clientes.listarClientes();
                        break;
                    case 3:
                        System.out.println("Editar  Clientes");
                        clientes.listarClientes();
                        id = Console.scanInt("Id : ");
                        nome = Console.scanString("nome: ");
                        email = Console.scanString("email: ");
                        cpf = Console.scanString("cpf: ");
                        clientes.editarCliente(nome, email, cpf, id);
                        break;
                    case 4:
                        System.out.println("Excluir  Clientes");
                        clientes.listarClientes();
                        id = Console.scanInt("Id: ");
                        clientes.deletarCliente(id);
                        break;
                    case 5:
                        System.out.println("Nova conta");
                        clientes.listarClientes();
                        id = Console.scanInt("Id : ");
                        saldo = Console.scanInt("saldo: ");
                        numero = Console.scanInt("numero: ");
                        conta.cadastrarConta(id, saldo, numero);
                        break;
                    case 6:
                        System.out.println("Lista  Contas");
                        conta.listarContas();
                        break;
                    case 7:
                        System.out.println("Operação de Saldo");
                        numero = Console.scanInt("numero da conta: ");
                        conta.saldo(numero);
                        break;
                    case 8:
                        System.out.println("Operação de Saque");
                        numero = Console.scanInt("numero da conta: ");
                        valor = Console.scanInt("valor: ");
                        conta.saque(valor, numero);
                        break;
                    case 9:
                        System.out.println("Operação de Transferencia");
                        numeroDebitado = Console.scanInt("numero da conta do debitado: ");
                        numeroCreditado = Console.scanInt("numero da conta do creditado: ");
                        valor = Console.scanInt("valor: ");
                        conta.tranferencia(valor, numeroCreditado, numeroDebitado);
                        break;
                    case 10:
                        System.out.println("Operação de Deposito");
                        numero = Console.scanInt("numero da conta: ");
                        valor = Console.scanInt("valor: ");
                        conta.deposito(valor, numero);
                        break;

                    case 11:
                        System.out.println("Finalizando a aplicacao");
                        break;
                    default:
                        System.err.println("Opcao invalida!");
                }
            } catch (InputMismatchException exc) {
                System.err.println("Opcao invalida!");
            }
        } while (op != 13);
    }

}
