package br.dio.desafiojava.bancodigital;

import br.dio.desafiojava.bancodigital.entidades.Banco;
import br.dio.desafiojava.bancodigital.entidades.Cliente;
import br.dio.desafiojava.bancodigital.entidades.Conta;
import br.dio.desafiojava.bancodigital.entidades.ContaCorrente;
import br.dio.desafiojava.bancodigital.entidades.ContaPoupanca;
import br.dio.desafiojava.bancodigital.enums.Sexo;
import br.dio.desafiojava.bancodigital.enums.TipoConta;

public class App {
    public static void main(String[] args) throws Exception {
        // Criação do Banco;
        Banco banco = new Banco();

        // Criação dos clientes;
        Cliente rodrigo = banco.criarCliente("123.123.123-12", "Rodrigo Ferreira Cavalcante", "rodrigo@email.com",
                Sexo.MASCULINO.getValor());
        Cliente vinicius = banco.criarCliente("456.456.456-45", "Vinícius Cavalcante", "vinicius@email.com",
                Sexo.MASCULINO.getValor());
        Cliente karina = banco.criarCliente("789.789.789-78", "Karina Cavalcante", "karina@email.com",
                Sexo.FEMININO.getValor());

        // Criação de contas e armanazenamento na lista de contas do banco.
        banco.criarConta(rodrigo.getCpf(), TipoConta.CC);
        banco.criarConta(rodrigo.getCpf(), TipoConta.CP);

        banco.criarConta(vinicius.getCpf(), TipoConta.CP);

        banco.criarConta(karina.getCpf(), TipoConta.CC);

        banco.listarClientes();

        //operacoes bancárias
        ContaCorrente contaRodrigoCC = (ContaCorrente) rodrigo.getConta(TipoConta.CC);
        contaRodrigoCC.depositar(1000);

        ContaPoupanca contaRodrigoCP = (ContaPoupanca) rodrigo.getConta(TipoConta.CP);
        contaRodrigoCP.depositar(2500);
        
        Conta contaVinicius = vinicius.getConta(TipoConta.CP);
        contaRodrigoCC.transferir(contaVinicius, (contaRodrigoCC.getSaldo() / 2));

        Conta contaKarina = karina.getConta(TipoConta.CC);
        contaRodrigoCP.transferir(contaKarina, (contaRodrigoCP.getSaldo() / 3));

        System.out.println("\n*** SALDOS APÓS OPERAÇÕES INICIAIS ***");
        contaRodrigoCC.imprimirExtrato();
        contaRodrigoCP.imprimirExtrato();
        contaVinicius.imprimirExtrato();
        contaKarina.imprimirExtrato();

        //grandes depositos
        contaRodrigoCC.depositar(5000);
        contaVinicius.depositar(10000);
        contaKarina.depositar(10000);

        System.out.println("\n\n*** SALDOS APÓS OPERAÇÕES DEPOSITOS ***");
        contaRodrigoCC.imprimirExtrato();
        contaRodrigoCP.imprimirExtrato();
        contaVinicius.imprimirExtrato();
        contaKarina.imprimirExtrato();
    }
}
