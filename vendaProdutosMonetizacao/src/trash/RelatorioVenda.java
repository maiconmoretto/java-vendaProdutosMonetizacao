/*
 *
 * - Relatórios de vendas: produtos vendidos, compras feito pelo cliente,
 * clientes que mais compram, clientes que mais realizam operações de
 * monetização
 */
package trash;

import java.util.ArrayList;

/**
 *
 * @author 631410161
 */
public class RelatorioVenda {

    private String codProduto;
    private String codigoCliente;
    private String data;

    public RelatorioVenda(String codProduto, String codigoCliente, String data) {
        this.codProduto = codProduto;
        this.codigoCliente = codigoCliente;
        this.data = data;
    }

    public String getProduto() {
        return codProduto;
    }

    public void setProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getCliente() {
        return codigoCliente;
    }

    public void setCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



}
