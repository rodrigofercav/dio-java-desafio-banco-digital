package br.dio.desafiojava.bancodigital.entidades;

import br.dio.desafiojava.bancodigital.interfaces.IConta;
import lombok.Getter;

@Getter
public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    protected void imprimirExtrato(String tipoConta) {
        System.out.println("*** Extrato da "+ tipoConta +" ***");
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número.: " + this.numero);
        System.out.println("Saldo..: " + this.saldo);
    }
    
    protected String getTipoConta(Object conta) {
    	String classeConta = conta.toString();
    	
    	if (classeConta.contains("Poupanca"))
    		return "Conta Poupança";
    	else if (classeConta.contains("Corrente")) {
    		return "Conta Corrente";
    	}
    	
    	return "<Tipo de Conta Não Identificada>";
    }

    public void sacar(double valor) {
        if (this.saldo >= valor)
            this.saldo -= valor;
        else
            System.out.println("Saque não realizado, saldo indisponível. \nSaldo atual: " + this.saldo);
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(Conta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
}
