package trash;

import java.sql.SQLException;
import java.util.InputMismatchException;
import util.Console;
import vendaprodutosmonetizacao.model.ClienteConta;
import vendaprodutosmonetizacao.model.Clientes;
import vendaprodutosmonetizacao.model.Produtos;
import vendaprodutosmonetizacao.model.Vendas;

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
        Produtos produtos = new Produtos();
        Vendas vendas = new Vendas();
        String nome, email, cpf;
        int id, saldo, numero, valor, numeroCreditado, numeroDebitado;
        //inicio loop menu
        int op = 0;
        do {

            System.out.println("\nMenu:");
            System.out.println("1- Novo Cliente");
            System.out.println("2- Todos Clientes");
            System.out.println("3- Editar Cliente");
            System.out.println("4- Excluir Cliente");
            System.out.println("5- Nova conta");
            System.out.println("6- Todas contas");
            System.out.println("7- Saldo ");
            System.out.println("8- Saque ");
            System.out.println("9- Tranferencia ");
            System.out.println("10- Deposito ");
            System.out.println("11- Novo Produto");
            System.out.println("12- Todos Produtos");
            System.out.println("13- Editar Produto");
            System.out.println("14- Excluir Produto");
            System.out.println("15- Venda");
            System.out.println("16- Histórico vendas");
            System.out.println("17- Sair ");
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
                        System.out.println("Cadastro de Produto");
                        nome = Console.scanString("nome: ");
                        valor = Console.scanInt("valor: ");
                        produtos.cadastrarProduto(nome, valor);
                        break;
                    case 12:
                        System.out.println("Lista de Produtos");
                        produtos.listarProdutos();
                        break;
                    case 13:
                        System.out.println("Editar  Produto");
                        produtos.listarProdutos();
                        id = Console.scanInt("Id : ");
                        nome = Console.scanString("nome: ");
                        valor = Console.scanInt("valor: ");
                        produtos.editarProduto(nome, valor, id);
                        break;
                    case 14:
                        System.out.println("Excluir  Produto");
                        produtos.listarProdutos();
                        id = Console.scanInt("Id: ");
                        produtos.deletarProduto(id);
                        break;
                    case 15:
                        System.out.println("Venda");
                        System.out.println("\n ===========  \n Produtos ");
                        produtos.listarProdutos();
                        System.out.println("\n =========== \n Clientes ");
                        clientes.listarClientes();
                        id = Console.scanInt("Id do produto: ");
                        numero = Console.scanInt("numero da  conta: ");
                        vendas.venda( numero, id);
                        break;
                    case 16:
                        System.out.println("Histórico Vendas");
                        vendas.listarVendas();
                        break;

                    case 17:
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
