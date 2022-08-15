package br.dio.desafiojava.bancodigital;

import br.dio.desafiojava.bancodigital.entidades.Banco;
import br.dio.desafiojava.bancodigital.entidades.Cliente;
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
    }
}
