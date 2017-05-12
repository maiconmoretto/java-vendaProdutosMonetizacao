/*
 * - Venda de produtos com monetização: na venda registra-se o código, a data e
 * hora que foi realizada, o codigoCliente e os produtos e quantidade desses que foi
 * vendida. O sistema deverá calcular o total e ao finalizar a venda, deverá ser
 * debitado da conta do codigoCliente, caso este tenha crédito.
 *
 */
package vendaprodutosmonetizacao;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author 631410161
 */
public class Venda {

    private String data;
    private String codigo;
    private String codigoCliente;

    public Venda(String codigoCliente, String codigoProduto) {

        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        return ft.format(dNow);

    }



    public String getCliente() {
        return codigoCliente;
    }

    public void setCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public boolean operacaoVenda(int valorProduto, int saldoCliente) {
//        System.out.println("valor do produto " + valorProduto + " , " + "saldoCliente " + saldoCliente);
        if (saldoCliente >= valorProduto) {
            return true;
        } else {
            return false;
        }

//        contaCliente contacodigoCliente = new ContaCliente("01411425022")
    }

}
