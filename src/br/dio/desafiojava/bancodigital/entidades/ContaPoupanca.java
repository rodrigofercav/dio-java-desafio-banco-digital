package br.dio.desafiojava.bancodigital.entidades;

import br.dio.desafiojava.bancodigital.enums.TipoConta;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		super.imprimirExtrato(TipoConta.CP.getValor());
	}
}
