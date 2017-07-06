/*
- Cadastro de produtos: produto possui código, nome e preço.
 */
package trash;

/**
 *
 * @author 631410161
 */
public class Produto {
    
    private String codigo; 
    private String  nome;
    private int  preço;
    private int  id;
   private int  valor;
    
    
    
    
    public Produto(String codigo,String  nome,int preço) {
        this.codigo = codigo;
        this.nome = nome;
        this.preço = preço;
    }

    public Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void add(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
