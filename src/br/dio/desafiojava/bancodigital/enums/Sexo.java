package br.dio.desafiojava.bancodigital.enums;
public enum Sexo {
    FEMININO('F'), MASCULINO('M');

    private final char valor;

    Sexo(char valor){
        this.valor = valor;
    }

    public char getValor() {
        return this.valor;
    }
}
