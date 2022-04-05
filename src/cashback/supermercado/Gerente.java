
package cashback.supermercado;

import java.util.*;

/**
 *Luigi Guido Gontijo Barreto - 201900963
 *Maria Heloísa de Paula Souza - 202003599
 */
public class Gerente extends Funcionario{
    //a classe gerente é responsalvel pelo rank de clientes que recebem o cashback o gerente define o bonus e autoriza  
    // os clientes a receber o cashback;
    private double acrescimo;

    public Gerente(double acrescimo, String nome, String cpf, String teleforne, double salario) {
        super(nome, cpf, teleforne, salario);
        this.acrescimo = acrescimo;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(double acrescimo) {
        this.acrescimo = acrescimo;
    }
  
    @Override
    public double calculaSalario() {
        return super.getSalario()+acrescimo;
    }
    
    public void defineBonus(double b, Rank a) {
        a.setPorcentagensBonus(b);
        
    }
    public void autorizaCashbackCartao(Rank r) {
       r.adicionaCashBackCartao();
    }
    
}
