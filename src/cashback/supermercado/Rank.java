
package cashback.supermercado;

import java.util.*;

/**
 *Luigi Guido Gontijo Barreto - 201900963
 *Maria Heloísa de Paula Souza - 202003599
 */
public class Rank {
    
    private ArrayList<Cliente> lista = new ArrayList<Cliente>();
    private double porcentagensBonus;

    public Rank() {
    }

    public ArrayList<Cliente> getLista() {
        ordenaLista();
        return lista;
    }
    
    public double getPorcentagensBonus() {
        return porcentagensBonus;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.lista = lista;
        ordenaLista();
    }

    public void setPorcentagensBonus(double porcentagensBonus) {
        this.porcentagensBonus = porcentagensBonus;
    }
    
    public void ordenaLista() {
       int i,j;
       Cliente aux;

     for(i=0;i<lista.size();i++)
       for(j=i+1;j<lista.size();j++)
         if(lista.get(i).getRegistroDeCompras().getValorTotal()>lista.get(j).getRegistroDeCompras().getValorTotal())
         {
            aux=lista.get(i);
            lista.set(i, lista.get(j));
            lista.set(j, aux);
         }
        
    }
    public void adicionaCliente(Cliente a) {
        lista.add(a);
        ordenaLista();
    }
    public void adicionaCashBackCartao() {
        int i=0;
        ordenaLista();
        while(i<10 && i<lista.size()){
            lista.get(i).getRegistroDeCompras().setCashback(lista.get(i).getRegistroDeCompras().getValorTotal()*porcentagensBonus);
        }
        
    }
      
    
    
    
    
    
}
