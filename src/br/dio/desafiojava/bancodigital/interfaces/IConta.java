package br.dio.desafiojava.bancodigital.interfaces;

import br.dio.desafiojava.bancodigital.entidades.Conta;

public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

    void transferir(Conta contaDestino, double valor);

    void imprimirExtrato();
}
