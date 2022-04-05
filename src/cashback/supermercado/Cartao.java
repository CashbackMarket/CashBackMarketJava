
package cashback.supermercado;

import java.util.*;

/**
 *Luigi Guido Gontijo Barreto - 201900963
 *Maria Heloísa de Paula Souza - 202003599
 */
public class Cartao {
    
    private int idCartao ;
    private double valorTotal;
    private double cashback;
    private ArrayList<Produto> historicoDeCompras = new ArrayList<Produto>();

    public Cartao(int idCartao) {
        this.idCartao = idCartao;
        valorTotal=0.0;
        cashback=0.0;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public double getValorTotal() {
        calculaTotal();
        return valorTotal;
    }
    
    public double getCashback() {
        return cashback;
    }

    public ArrayList<Produto> getHistoricoDeCompras() {
        return historicoDeCompras;
    }

    public void setCashback(Double cashback) {
        this.cashback = cashback;
    }

    public void setHistoricoDeCompras(ArrayList<Produto> historicoDeCompras) {
        this.historicoDeCompras = historicoDeCompras;
    }

    public void adicionaProduto(Produto a){
        historicoDeCompras.add(a);
        calculaTotal();
    }
    
    public void ConsultaCashback(){
        System.out.println("Cliente possui um desconto de R$ "+cashback);
       // cashback=0.0;
    }
    
    private void calculaTotal(){
        valorTotal=0.0;
        
        for (int i = 0; i < historicoDeCompras.size(); i++) {
            valorTotal+= historicoDeCompras.get(i).getValor();  
        }
    }
    
}
