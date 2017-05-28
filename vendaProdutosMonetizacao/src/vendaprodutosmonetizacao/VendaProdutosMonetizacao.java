package vendaprodutosmonetizacao;

import com.sun.security.ntlm.Client;
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
import sun.applet.Main;
import util.Console;
import vendaprodutosmonetizacao.Conexao;
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

//        clientes.cadastrarCliente();
//       clientes.deletarCliente(1);  
         clientes.editarCliente("aquiles",2);  
        clientes.listarClientes();

//        System.out.println("lista de clietes :" + clientes.listarClientes());
//        Cliente cliente = new Cliente();
//        
//        System.out.println("lista de clietes :"+ cliente.listaClientes());
//        // cria um preparedStatement
//        String insert = "INSERT INTO  usuarios (nome) values (?)";
//        PreparedStatement stmt = connection.prepareStatement(insert);
//
//        // preenche os valores
//        stmt.setString(1, "Joao");
//        stmt.execute();
//
////        String update = "UPDATE   usuarios SET nome = ? WHERE idusuario = ?";
////         connection.executeQuery(update);
//        // preenche os valores
//        stmt.setString(1, "Joao");
//        stmt.execute();
//
//        String sql = "SELECT * FROM  usuarios ";
//        Statement comando = connection.createStatement();
//        ResultSet resultado = comando.executeQuery(sql);
//
//        while (resultado.next()) {
//            System.out.println("Id: " + resultado.getInt("idusuario"));
//            System.out.println("Nome: " + resultado.getString("nome"));
//        }
        System.exit(1);

        ArrayList<RelatorioVenda> listarHistorico = new ArrayList<>();
        ArrayList<Cliente> listarClientes = new ArrayList<>();
        ArrayList<Produto> listarProdutos = new ArrayList<>();
        ArrayList<ContaCliente> listarContasClientes = new ArrayList<>();

        //inicio loop menu
        int op = 0;
        do {

            System.out.println("\nMenu:");
            System.out.println("1- Novo Cliente");
            System.out.println("2- Todos Clientes");
            System.out.println("3- Novo conta");
            System.out.println("4- Todos contas");
            System.out.println("5- Novo Produto");
            System.out.println("6- Todos Produtos");
            System.out.println("7- Saque");
            System.out.println("8- Deposito");
            System.out.println("9- Tranferencia");
            System.out.println("10- Relatório vendas");
            System.out.println("11- Compra");
            System.out.println("12- Sair");
            try {
                op = Console.scanInt("Opcao: ");

                switch (op) {
                    case 1:
                        System.out.println("Cadastro de Clientes");
//                        Cliente cliente = cadastrarCliente();
//                        listarClientes.add(cliente);
                        break;
                    case 2:
                        System.out.println("Lista de clientes");
                        listarClientes(listarClientes);
                        System.out.println("-------------------\n");
                        break;
                    case 3:
                        System.out.println("Cadastro de conta");
                        ContaCliente contaCliente = cadastrarContaCliente();
                        listarContasClientes.add(contaCliente);
                        break;
                    case 4:
                        System.out.println("Lista de contas");
                        listarContasClientes(listarContasClientes);
                        System.out.println("-------------------\n");
                        break;
                    case 5:
                        System.out.println("Cadastro de Produtos");
                        Produto produto = cadastrarProduto();
                        listarProdutos.add(produto);
                        break;
                    case 6:
                        System.out.println("Lista de produtos");
                        listarProdutos(listarProdutos);
                        System.out.println("-------------------\n");
                        break;
                    case 7:
                        System.out.println("Operação de Saque");
//                        Cliente cliente = new Cliente("01411425022", "maicon moretto dos santos", "maiconmorettos@gmail.com", "01");
                        listarClientes(listarClientes);
                        listarContasClientes(listarContasClientes);
                        saque(listarClientes, listarContasClientes);

                        break;
                    case 8:
                        System.out.println("Operação de Deposito");
                        listarClientes(listarClientes);
                        listarContasClientes(listarContasClientes);
                        deposito(listarClientes, listarContasClientes);

                        break;
                    case 9:
                        System.out.println("Operação das transferencias");
                        listarClientes(listarClientes);
                        listarContasClientes(listarContasClientes);
                        tranferencia(listarClientes, listarContasClientes);
                        System.out.println("-------------------\n");
                        break;
                    case 10:
                        System.out.println("Relatório das vendas");
                        listarClientes(listarClientes);
                        listarProdutos(listarProdutos);
                        listarHistorico(listarHistorico, listarClientes, listarProdutos);
                        System.out.println("-------------------\n");
                        break;
                    case 11:
                        System.out.println("Operação de compra");
                        listarClientes(listarClientes);
                        listarProdutos(listarProdutos);
                        listarContasClientes(listarContasClientes);
                        listarHistorico(listarHistorico, listarClientes, listarProdutos);
                        compra(listarProdutos, listarContasClientes, listarHistorico);
                        break;
                    case 12:
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

    private static RelatorioVenda cadastrarHistorico(String codigoProduto, String conta) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String data = ft.format(dNow);
        return new RelatorioVenda(codigoProduto, conta, data);

    }

    private static void listarHistorico(ArrayList<RelatorioVenda> listarHistorico, ArrayList<Cliente> listarClientes, ArrayList<Produto> listarProdutos) {
        if (listarHistorico.isEmpty()) {
            System.out.println("Nenhuma compra realizada!");
        } else {
            System.out.println("\n -------------------------\nHistórico da  venda");
            for (RelatorioVenda r : listarHistorico) {

                for (Cliente c : listarClientes) {
                    String contac = r.getCliente();
                    String conta = c.getConta();
                    if (contac.equals(conta)) {
                        System.out.println("cliente = " + c.getNome() + " , data = " + r.getData());

//                        for (Produto p : listarProdutos) {
//                            System.out.println("cliente = " + c.getNome() + " ,produto = " + p.getNome() + ", preco = " + p.getPreço() + ", data =" + r.getData());
//                        }
                    }

                }
            }
        }

    }

//    private static Cliente cadastrarCliente() {
//        String cpf = Console.scanString("cpf: ");
//        String nome = Console.scanString("nome: ");
//        String email = Console.scanString("email: ");
//        String conta = Console.scanString("conta: ");
////        return new Cliente(cpf, nome, email, conta);
//    }
    private static void listarClientes(ArrayList<Cliente> listarClientes) {
        if (listarClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        } else {
            for (Cliente c : listarClientes) {
                System.out.println("\ncliente = " + c.getNome() + ", cpf = " + c.getCpf() + ", email = " + c.getEmail() + ", conta = " + c.getConta());
            }
        }
    }

    private static ContaCliente cadastrarContaCliente() {
        String conta = Console.scanString("conta: ");
        int valor = Console.scanInt("valor :");
        return new ContaCliente(conta, valor);
    }

    private static void listarContasClientes(ArrayList<ContaCliente> listarContas) {
        if (listarContas.isEmpty()) {
            System.out.println("Nenhum conta cadastrada!");
        } else {
            for (ContaCliente contaClinte : listarContas) {
                System.out.println("\n numero da conta = " + contaClinte.getConta() + " , saldo " + contaClinte.getSaldo() + " , valor " + contaClinte.getValor());
            }
        }
    }

    private static Produto cadastrarProduto() {
        String codigo = Console.scanString("codigo: ");
        String nome = Console.scanString("nome: ");
        int preço = Console.scanInt("preço: ");
        return new Produto(codigo, nome, preço);
    }

    private static void listarProdutos(ArrayList<Produto> listarProdutos) {
        if (listarProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
        } else {
            for (Produto p : listarProdutos) {
                System.out.println("\nproduto = " + p.getNome() + ", codigo = " + p.getCodigo() + ", preço = " + p.getPreço());
            }
        }
    }

    private static void saque(ArrayList<Cliente> listarClientes, ArrayList<ContaCliente> listarContas) {
        int saldoAnterior = 0;
        int cont = 0;
        String conta = Console.scanString("conta: ");
        if (listarClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        } else {
            for (Cliente c : listarClientes) {
                String contac = c.getConta();
                if (contac.equals(conta)) {
                    int valorSaque = Console.scanInt("valor saque: ");
                    for (ContaCliente contaClinte : listarContas) {
                        System.out.println("\n numero da conta = " + contaClinte.getConta() + " , saldo " + contaClinte.getSaldo());
                        saldoAnterior = contaClinte.getValor();
                        System.out.println("\nsaldo anterior " + saldoAnterior);
                    }
                    int saque = saldoAnterior - valorSaque;
                    System.out.println("saldo subtraido  ao valor " + saque);
                    ContaCliente contaCliente = new ContaCliente(contac, saque);
                    System.out.println("\n -------------------------\nresultado do saque:\n");
                    if (contaCliente.Saque(saque, saldoAnterior) == true) {
                        ContaCliente contaClienteAtualizada = new ContaCliente(contac, saque);
                        listarContas.set(cont, contaClienteAtualizada);
                        System.out.println("suesso ao executar o saque de " + valorSaque + " na conta " + conta + "\n saldo atual = " + saque);
                    } else {
                        System.out.println("ocorreu um erro  ao realizar o saque, valor nao pode ser " + valorSaque);
                    }
                }
                cont++;
            }
        }

    }

    private static void deposito(ArrayList<Cliente> listarClientes, ArrayList<ContaCliente> listarContas) {
        int saldoAnterior = 0;
        int cont = 0;
        String conta = Console.scanString("conta: ");
        if (listarClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        } else {
            for (Cliente c : listarClientes) {
                String contac = c.getConta();
                if (contac.equals(conta)) {
                    int valorDeposito = Console.scanInt("valor deposito: ");
                    for (ContaCliente contaClinte : listarContas) {
                        System.out.println("\n numero da conta = " + contaClinte.getConta() + " , saldo " + contaClinte.getSaldo());
                        saldoAnterior = contaClinte.getValor();
                        System.out.println("\nsaldo anterior " + saldoAnterior);
                    }
                    int saldo = valorDeposito + saldoAnterior;
                    System.out.println("saldo somado ao valor " + saldo);
                    ContaCliente contaCliente = new ContaCliente(contac, saldo);
                    System.out.println("\n -------------------------\nresultado do desposito:\n");
                    if (contaCliente.Deposito(saldo) == true) {
                        ContaCliente contaClienteAtualizada = new ContaCliente(contac, saldo);
                        listarContas.set(cont, contaClienteAtualizada);
                        System.out.println("suesso ao executar o deposito de " + valorDeposito + " na conta " + conta + "\n saldo atual = " + saldo);
                    } else {
                        System.out.println("ocorreu um erro  ao realizar o deposito, valor nao pode ser " + valorDeposito);
                    }
                }
                cont++;
            }
        }

    }

    private static void tranferencia(ArrayList<Cliente> listarClientes, ArrayList<ContaCliente> listarContas) {
        int saldoAnterior = 0;
        int cont = 0;
        String contaSol = Console.scanString("conta  solicitante: ");
        String contaDest = Console.scanString("conta  destinatario: ");
        int valor = Console.scanInt("valor: ");
        if (listarClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        } else {
            for (Cliente c : listarClientes) {
                String contac = c.getConta();
                if (contac.equals(contaSol)) {

                    for (ContaCliente contaClinte : listarContas) {
                        System.out.println("\n numero da conta  sol = " + contaClinte.getConta() + " , saldo " + contaClinte.getSaldo());
                        saldoAnterior = contaClinte.getValor();
                        System.out.println("\nsaldo anterior " + saldoAnterior);
                    }
                    int saldo = saldoAnterior - valor;
                    System.out.println("saldo diminuido ao valor " + saldo);
                    ContaCliente contaCliente = new ContaCliente(contac, saldo);
                    if (saldo >= 0) {
                        ContaCliente contaClienteAtualizada = new ContaCliente(contac, saldo);
                        listarContas.set(cont, contaClienteAtualizada);
                        System.out.println("suesso ao executar a tranfereincia de " + valor + " na conta " + contaSol + " para a conta  = " + contaDest);
                    } else {
                        System.out.println("ocorreu um erro  atranfereincia");
                    }
                }

                String contacs = c.getConta();
                if (contacs.equals(contaDest)) {
                    for (ContaCliente contaClinte : listarContas) {
                        System.out.println("\n numero da conta dest = " + contaClinte.getConta() + " , saldo " + contaClinte.getSaldo());
                        saldoAnterior = contaClinte.getValor();
                        System.out.println("\nsaldo anterior " + saldoAnterior);
                    }
                    int saldo = saldoAnterior + valor;
                    System.out.println("saldo somado ao valor " + saldo);
                    ContaCliente contaCliente = new ContaCliente(contacs, saldo);
                    ContaCliente contaClienteAtualizada = new ContaCliente(contacs, saldo);
                    listarContas.set(cont, contaClienteAtualizada);

                }
                cont++;
            }
        }

    }

    private static void compra(ArrayList<Produto> listarProdutos, ArrayList<ContaCliente> listarContas, ArrayList<RelatorioVenda> listarHistorico) {
        int saldoAnterior = 0;
        int cont = 0;
        if (listarProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
        } else if (listarContas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada!");
        } else {
            String conta = Console.scanString("\nconta: ");
            String codigoProduto = Console.scanString("\ncodigo do Produto: ");
            int contaProd = 0;
            for (Produto p : listarProdutos) {
                if (p.getCodigo().equals(codigoProduto)) {
                    if (p.getCodigo().equals(codigoProduto)) {
                        for (ContaCliente c : listarContas) {
                            String contac = c.getConta();
                            int saldo = c.getValor();
                            if (contac.equals(conta)) {
                                int preco = p.getPreço();
                                Venda venda = new Venda(conta, codigoProduto);
                                System.out.println("\n -------------------------\n resultado da venda:\n");
                                if (venda.operacaoVenda(preco, saldo) == true) {
                                    System.out.println("suesso ao executar o venda");
                                    RelatorioVenda relatorioVenda = cadastrarHistorico(codigoProduto, conta);
                                    listarHistorico.add(relatorioVenda);
                                    int restante = saldo - preco;
                                    ContaCliente contaCliente = new ContaCliente(conta, restante);
                                    if (contaCliente.Saque(preco, restante) == true) {
                                        ContaCliente contaClienteAtualizada = new ContaCliente(contac, restante);
                                        listarContas.set(cont, contaClienteAtualizada);
                                        System.out.println("sucesso ao debitar da conta do cliente");
                                    }
                                } else {
                                    System.out.println("ocorreu um erro  a venda");
                                }
                            }
                        }
                    }
                }
                contaProd++;
            }
            listarProdutos.remove(contaProd - 1);
            System.out.println("sucesso ao remover o produto ");
        }
    }
}
