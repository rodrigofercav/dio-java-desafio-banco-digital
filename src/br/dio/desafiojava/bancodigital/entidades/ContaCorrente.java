package br.dio.desafiojava.bancodigital.entidades;

import br.dio.desafiojava.bancodigital.enums.TipoConta;

public class ContaCorrente extends Conta {
	
    public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
    public void imprimirExtrato() {
        super.imprimirExtrato(TipoConta.CC.getValor());
    }
}
