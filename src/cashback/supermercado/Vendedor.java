package cashback.supermercado;

import java.util.*;

/**
 * Luigi Guido Gontijo Barreto - 201900963
 * Maria Heloísa de Paula Souza - 202003599
 */
public class Vendedor extends Funcionario {
    //A classe vendedor permite o gerenciamento do estoque do supermecado por meio de uma lista de produtos
    private static ArrayList<Produto> estoque = new ArrayList<Produto>();
    
    public Vendedor(String nome, String cpf, String teleforne, double salario) {
        super(nome, cpf, teleforne, salario);
    }
    
    @Override
    public double calculaSalario() {
        return super.getSalario();
    }
    
    public ArrayList<Produto> getEstoque() {
        return estoque;
    }
    
    public void setEstoque(ArrayList<Produto> estoque) {
        this.estoque = estoque;
    }
    
    public void incluiProduto(Produto p) {
        estoque.add(p);
    }
    
    public void alteraProduto(Produto a, Produto b) {
        if(estoque.size()==0){
            System.out.println("Estoque vazio");
            return; 
        }
        for (int i = 0; i < estoque.size(); i++) {
            if (a.getNome().equals(estoque.get(i).getNome()) && a.getCodigoBarras().equals(estoque.get(i).getCodigoBarras()) && a.getValor()==estoque.get(i).getValor()) {
                estoque.set(i, b);
                System.out.println("Produto alterado com sucesso");
                return;
            }
        }
        System.out.println("Produto não encontrado");
        
    }
    
    public void excluiProduto(Produto p) {
        
        if(estoque.size()==0){
            System.out.println("Estoque vazio");
            return; 
        }
        for (int i = 0; i < estoque.size(); i++) {
            if (p.getNome().equals(estoque.get(i).getNome()) && p.getCodigoBarras().equals(estoque.get(i).getCodigoBarras()) && p.getValor()==estoque.get(i).getValor()) {
                estoque.remove(i);
                System.out.println("Produto removido com sucesso");
                return;
            }
            
        }
        System.out.println("Produto não encontrado");
    }
    
}
