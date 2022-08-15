package br.dio.desafiojava.bancodigital.enums;

public enum TipoConta {
    CC("Conta Corrente"), CP("Conta Poupança");

    private final String valor;

    TipoConta(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
}
