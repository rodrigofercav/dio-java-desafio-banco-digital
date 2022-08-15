package br.dio.desafiojava.bancodigital.entidades;

import java.util.ArrayList;

import br.dio.desafiojava.bancodigital.enums.TipoConta;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cliente {
    @Setter(AccessLevel.NONE)
    private String cpf;
    private String nome;
    private String email;
    private char sexo;
    private Banco banco;

    @Override
    public String toString() {
        String str = "";
        str += "\n- Dados do Cliente:";
        str += "\nNome: " + this.nome;
        str += "\nE-mail: " + this.email;
        str += "\nSexo: " + this.sexo;

        return str;
    }

    public Conta getConta(TipoConta tipoConta) {
        ArrayList<Conta> contas = this.banco.getAllContas();

        for (Conta contaIterator : contas) {
            if (contaIterator.getCliente().getCpf().equals(this.getCpf())
                    && contaIterator.getTipoConta(contaIterator.getClass()).equals(tipoConta.getValor()))
                return contaIterator;
        }

        return null;
    }
}
