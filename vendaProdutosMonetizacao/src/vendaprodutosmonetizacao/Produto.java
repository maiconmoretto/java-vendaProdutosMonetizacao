/*
- Cadastro de produtos: produto possui código, nome e preço.
 */
package vendaprodutosmonetizacao;

/**
 *
 * @author 631410161
 */
public class Produto {
    
    private String codigo; 
    private String  nome;
    private int  preço;
    
    public Produto(String codigo,String  nome,int preço) {
        this.codigo = codigo;
        this.nome = nome;
        this.preço = preço;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreço() {
        return preço;
    }

    public void setPreço(int preço) {
        this.preço = preço;
    }
    
    
    
}
