
package cashback.supermercado;

/**
 *Luigi Guido Gontijo Barreto - 201900963
 *Maria Heloísa de Paula Souza - 202003599
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private String teleforne;
    private int id ;
    private Cartao registroDeCompras;

    public Cliente(String nome, String cpf, String teleforne, int id, Cartao registroDeCompras) {
        this.nome = nome;
        this.cpf = cpf;
        this.teleforne = teleforne;
        this.id = id;
        this.registroDeCompras = registroDeCompras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTeleforne() {
        return teleforne;
    }

    public void setTeleforne(String teleforne) {
        this.teleforne = teleforne;
    }

    public int getId() {
        return id;
    }

    public Cartao getRegistroDeCompras() {
        return registroDeCompras;
    }

    public void setRegistroDeCompras(Cartao registroDeCompras) {
        this.registroDeCompras = registroDeCompras;
    }
    
    public void Compra(Produto p) {
        registroDeCompras.adicionaProduto(p);
        System.out.println("Produto comprado com sucesso");
    }
    
}
