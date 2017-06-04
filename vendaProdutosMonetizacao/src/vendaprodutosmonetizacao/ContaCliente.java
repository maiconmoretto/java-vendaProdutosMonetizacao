/*
para a conta anota-se o  número e o saldo.
 */
package vendaprodutosmonetizacao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 631410161
 */
public class ContaCliente {

    private int valor;
    private int saldo;
    private String conta;

//    public ContaCliente(String conta, int valor) {
//
//        this.conta = conta;
//        this.valor = valor;
//
//
//    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean Saque(int valor,int saldo) {
        if (valor <= saldo) {
            this.setSaldo(saldo - valor);
            return true;
        } else {
            return false;
        }

    }

    public boolean Deposito(int valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        } else {
            return false;
        }
    }

}
