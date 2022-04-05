
package cashback.supermercado;

/**
 *Luigi Guido Gontijo Barreto - 201900963
 *Maria Heloísa de Paula Souza - 202003599
 */
public abstract class Funcionario implements Pagamento{
    
    private String nome;
    private String cpf;
    private String teleforne;
    private double salario;

    public Funcionario(String nome, String cpf, String teleforne, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.teleforne = teleforne;
        this.salario = salario;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public abstract double calculaSalario();
    
}
