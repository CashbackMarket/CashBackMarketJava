
package cashback.supermercado;

/**
 *Luigi Guido Gontijo Barreto - 201900963
 *Maria Heloísa de Paula Souza - 202003599
 */
public class Produto {
    
    private String nome;
    private String codigoBarras;
    private double valor;

    public Produto(String nome, String codigoBarras, double valor) {
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
