package cashback.supermercado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Luigi Guido Gontijo Barreto - 201900963 e Maria Heloísa de Paula Souza - 202003599
 */
public class Main {

    public static void main(String[] args) throws ValorInvalido{
        final int maxVendedores = 5;
        final int maxGerentes = 2;

        Scanner read = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<Gerente> gerentes = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        Rank r = new Rank();

        int idCliente = 0;

        int menu;
        while (true) {
            try {

                System.out.println("\n---------------- Menu ----------------"
                        + "\nDigite 1 para adicionar um funcionário: "
                        + "\nDigite 2 para adicionar um cliente: "
                        + "\nDigite 3 para abrir o menu de funcionário: "
                        + "\nDigite 4 para abrir o menu de gerente: "
                        + "\nDigite 5 para abrir o menu do cliente: "
                        + "\nDigite 6 para abrir a folha de pagamento: "
                        + "\nDigite 7 para abrir ranking de clientes: "
                        + "\nDigite 0 para sair "
                );
                menu = read.nextInt();

                if (menu == 0) {
                    break;
                }

                switch (menu) {
                    case 1:
                        int submenu1;
                        System.out.println("\n---------------- Menu ----------------"
                                + "\nDigite 1 para adicionar um vendedor: "
                                + "\nDigite 2 para adicionar um gerente: "
                        );
                        submenu1 = read.nextInt();
                        read.nextLine();
                        if (submenu1 == 1) {
                            if (vendedores.size() < maxVendedores) {
                                System.out.println("\nDigite o nome do vendedor: ");
                                String nome = read.nextLine();
                                System.out.println("\nDigite o cpf do vendedor utilizando apenas números");
                                String cpf = read.nextLine();
                                while (ValidaCPF.isCPF(cpf) ==false){
                                    System.out.println("\nCPF INVÁLIDO!");
                                    System.out.println("\nDigite o cpf do vendedor utilizando apenas números");
                                    cpf = read.nextLine();
                                }                         
                                System.out.println("\nDigite o telefone do vendedor");
                                String tel = read.nextLine();
                                System.out.println("\nDigite o salario do vendedor");
                                double salario = read.nextDouble();
                                if(salario<=0.0){
                                        
                                    throw new ValorInvalido();
                                }

                                Vendedor v = new Vendedor(nome, cpf, tel, salario);
                                vendedores.add(v);
                                funcionarios.add(v);
                            } else {
                                System.out.println("\nNumero maximo de Vendedores atingido"
                                );
                            }
                        } else if (submenu1 == 2) {

                            if (gerentes.size() < maxGerentes) {
                                System.out.println("\nDigite o nome do gerente");
                                String nome = read.nextLine();
                                System.out.println("\nDigite o cpf do gerente utilizando apenas números");
                                String cpf = read.nextLine();
                                while (ValidaCPF.isCPF(cpf) ==false){
                                    System.out.println("\nCPF INVÁLIDO!");
                                    System.out.println("\nDigite o cpf do gerente utilizando apenas números");
                                    cpf = read.nextLine();
                                }        
                                System.out.println("\nDigite o telefone do gerente");
                                String tel = read.nextLine();
                                System.out.println("\nDigite o salario do gerente");
                                double salario = read.nextDouble();
                                if(salario<=0.0){   
                                    throw new ValorInvalido();
                                }
                                System.out.println("\nDigite o acréscimo do gerente");
                                double acrescimo = read.nextDouble();

                                Gerente g = new Gerente(acrescimo, nome, cpf, tel, salario);
                                gerentes.add(g);
                                funcionarios.add(g);
                            } else {
                                System.out.println("\nNumero máximo de Gerentes atingido"
                                );
                            }

                        }
                        break;

                    case 2:
                        read.nextLine();
                        System.out.println("\nDigite o nome do Cliente");
                        String nome = read.nextLine();
                        System.out.println("\nDigite o cpf do cliente utilizando apenas números");
                        String cpf = read.nextLine();
                        while (ValidaCPF.isCPF(cpf) ==false){
                            System.out.println("\nCPF INVÁLIDO!");
                            System.out.println("\nDigite o cpf do cliente utilizando apenas números");
                            cpf = read.nextLine();
                        }        
                        System.out.println("\nDigite o telefone do Cliente");
                        String tel = read.nextLine();
                        System.out.println("\nId do cliente:" + idCliente);
                        clientes.add(new Cliente(nome, cpf, tel, idCliente, new Cartao(idCliente)));
                        r.adicionaCliente(clientes.get(idCliente));
                        idCliente++;

                        break;
                    case 3:
                        read.nextLine();
                        System.out.println("\n Bem vindo ao menu do vendedor digite o nome do vendedor para prosseguir ");
                        String nomev = read.nextLine();
                        int indice = 0;
                        boolean verificacao = false;
                        
                        for (int i = 0; i < vendedores.size(); i++) {
                            if (nomev.equals(vendedores.get(i).getNome())) {
                                verificacao = true;
                                indice = i;
                                break;
                            }
                        }

                        if (verificacao) {

                            while (true) {
                                int submenu3;
                                System.out.println("\n---------------- Menu Vendedor----------------"
                                        + "\nDigite 1 para adicionar um produto estoque: "
                                        + "\nDigite 2 para alterar um produto: "
                                        + "\nDigite 3 para excluir um produto: "
                                        + "\nDigite 4 para mostrar estoque: "
                                        + "\nDigite 0 para sair "
                                );
                                submenu3 = read.nextInt();
                                read.nextLine();
                                if (submenu3 == 0) {
                                    break;
                                } else if (submenu3 == 1) {

                                    System.out.println("\nDigite o nome do produto: ");
                                    String nomep = read.nextLine();
                                    System.out.println("\nDigite o codigo de barras: ");
                                    String cod = read.nextLine();
                                    System.out.println("\nDigite o valor do produto: ");
                                    double valorp = read.nextDouble();
                                    if(valorp<=0.0){
                                        
                                        throw new ValorInvalido();
                                    }
                                    vendedores.get(indice).incluiProduto(new Produto(nomep, cod, valorp));

                                } else if (submenu3 == 2) {
                                    System.out.println("\nDigite o nome, codigo de barras e valor do produto a ser alterado em sequencia: ");
                                    String nomea = read.nextLine();
                                    String coda = read.nextLine();
                                    double valora = read.nextDouble();
                                    read.nextLine();

                                    System.out.println("\nDigite o novos dados: nome, codigo de barras e valor do produto em sequencia: ");
                                    String nomeb = read.nextLine();
                                    String codb = read.nextLine();
                                    double valorb = read.nextDouble();
                                    read.nextLine();

                                    vendedores.get(indice).alteraProduto(new Produto(nomea, coda, valora), new Produto(nomeb, codb, valorb));

                                } else if (submenu3 == 3) {

                                    System.out.println("\nDigite o nome, codigo de barras e valor do produto a ser excluido em sequencia: ");
                                    String nomep = read.nextLine();
                                    String codp = read.nextLine();
                                    double valorp = read.nextDouble();
                                    read.nextLine();

                                    vendedores.get(indice).excluiProduto(new Produto(nomep, codp, valorp));
                                } else if (submenu3 == 4) {
                                    System.out.println("\nEstoque: ");
                                    ArrayList<Produto> e = vendedores.get(indice).getEstoque();

                                    for (int i = 0; i < e.size(); i++) {
                                        System.out.println("\nNome produto: " + e.get(i).getNome() + "\nCodigo de barras: " + e.get(i).getCodigoBarras() + "\nValor: " + e.get(i).getValor());
                                    }

                                }
                            }

                        } else {
                            System.out.println("\n Vendedor não encontrado tente novemente");
                        }
                        break;
                    case 4:

                    read.nextLine();
                    System.out.println("\n Bem vindo ao menu do gerente digite o nome do gerente para prosseguir ");
                    String nomeg = read.nextLine();
                    int indiceg = 0;
                    boolean verificacaog = false;
                    for (int i = 0; i < gerentes.size(); i++) {
                        if (nomeg.equals(gerentes.get(i).getNome())) {
                            verificacaog = true;
                            indiceg = i;
                            break;
                        }
                    }

                        if (verificacaog) {

                            while (true) {
                                int submenu3;
                                System.out.println("\n---------------- Menu Gerente----------------"
                                        + "\nDigite 1 para definir bonus: "
                                        + "\nDigite 2 para autorizar cashback: "
                                        + "\nDigite 0 para sair "
                                );
                                submenu3 = read.nextInt();
                                read.nextLine();
                                if (submenu3 == 0) {
                                    break;
                                } else if (submenu3 == 1) {
                                    System.out.println("\nDigite o percentual de cashback, valor de 0 a 100: ");
                                    double percetagem = read.nextDouble();

                                    gerentes.get(indiceg).defineBonus(percetagem / 100, r);
                                } else if (submenu3 == 2) {
                                    System.out.println("\nCashback autorizado");
                                    gerentes.get(indiceg).autorizaCashbackCartao(r);
                                }
                            }

                        } else {
                            System.out.println("\n Gerente não encontrado tente novamente");
                        }
                        break;
                    case 5:

                        System.out.println("\n Bem vindo ao menu do cliente digite o id do cliente para prosseguir ");
                        int idc = read.nextInt();

                        if (idc < clientes.size() && idc >= 0) {

                            while (true) {
                                int submenu3;
                                System.out.println("\n---------------- Menu Cliente----------------"
                                        + "\nDigite 1 para realizar compras: "
                                        + "\nDigite 2 para consultar cashback: "
                                        + "\nDigite 3 para consultar o histórico de compra: "
                                        + "\nDigite 0 para sair "
                                );
                                submenu3 = read.nextInt();
                                read.nextLine();
                                if (submenu3 == 0) {
                                    break;
                                } else if (submenu3 == 1) {
                                    if (vendedores.size() == 0) {
                                        System.out.println("Não foi possivel realizar compra pois não há vendedores disponíveis!");
                                        break;
                                    } else if (vendedores.get(0).getEstoque().size() == 0) {
                                        System.out.println("Não foi possivel realizar compra pois não há estoque!");
                                        break;
                                    } else {

                                        System.out.println("\nEstoque: ");
                                        ArrayList<Produto> e = vendedores.get(0).getEstoque();

                                        for (int i = 0; i < e.size(); i++) {
                                            System.out.println("\nNome do produto: " + e.get(i).getNome() + "Código de barras: " + e.get(i).getCodigoBarras() + "Valor: " + e.get(i).getValor() + "índice" + i);
                                        }
                                        System.out.println("\nDigite quantos produtos deseja comprar: ");
                                        int compras = read.nextInt();
                                        for (int i = 0; i < compras; i++) {
                                            System.out.println("\nDigite o índice do produto que deseja:");
                                            int j = read.nextInt();

                                            if (j >= 0 && j < e.size()) {
                                                clientes.get(idc).Compra(e.get(j));
                                            } else {
                                                System.out.println("\nProduto fora de estoque:");
                                            }

                                        }

                                    }

                                } else if (submenu3 == 2) {

                                    clientes.get(idc).getRegistroDeCompras().ConsultaCashback();

                                } else if (submenu3 == 3) {


                                    ArrayList<Produto> e = clientes.get(idc).getRegistroDeCompras().getHistoricoDeCompras();
                                    for (int i = 0; i < e.size(); i++) {
                                        System.out.println("\nNome produto: " 
                                        + e.get(i).getNome() 
                                        + "\nCodigo de barras: " 
                                        + e.get(i).getCodigoBarras()
                                        + "\nValor: " 
                                        + e.get(i).getValor());
                                    }
                                }

                            }
                        } else {
                            System.out.println("\n Id do cliente não encontrado");
                        }

                        break;
                    case 6:
                        System.out.println("\nFolha de pagamento");

                        double totalpagamento = 0.0;
                        for (int i = 0; i < funcionarios.size(); i++) {
                            System.out.println("\n\nNome: " + funcionarios.get(i).getNome()
                                    + "\nCPF: " + funcionarios.get(i).getCpf()
                                    + "\nTelefone: " + funcionarios.get(i).getTeleforne()
                                    + "\nSalario: " + funcionarios.get(i).calculaSalario()
                            );
                            totalpagamento += funcionarios.get(i).calculaSalario();
                        }
                        System.out.println("\nTotal a pagar: " + totalpagamento);

                        break;

                    case 7:

                        System.out.println("\nRanking de clientes");

                        for (int i = 0; i < r.getLista().size(); i++) {
                            System.out.println("\n\nNome: " + r.getLista().get(i).getNome()
                                    + "\nCPF: " + r.getLista().get(i).getCpf()
                                    + "\nTelefone: " + r.getLista().get(i).getTeleforne()
                                    + "\nId: " + r.getLista().get(i).getId()
                                    + "\nValor total de compras no mes: " + r.getLista().get(i).getRegistroDeCompras().getValorTotal()
                            );

                        }
                        break;

                }
            } catch (InputMismatchException erro1) {
                System.err.println("Não é permitido inserir letras no menu, informe apenas números inteiros, reais para valores monetários !");
                read.nextLine();
            }catch(ValorInvalido erro2){
                System.err.println("Valor inválido, digite um valor maior que 0!");
            }
        }

    }

}
