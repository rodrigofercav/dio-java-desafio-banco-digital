package br.dio.desafiojava.bancodigital.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import br.dio.desafiojava.bancodigital.enums.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banco {
    private String nome;
    private String cnpj;

    private static Set<Cliente> listaClientes = new HashSet<Cliente>();
    private static ArrayList<Conta> listaContas = new ArrayList<Conta>();

    public Conta criarConta(String cpf, TipoConta tipoConta) {
        // busca cliente pelo cpf
        Cliente cliente = null;

        for (Cliente clienteIterator : listaClientes) {
            if (clienteIterator.getCpf().equals(cpf))
                cliente = clienteIterator;
        }

        if (cliente != null) {
            // criação da conta para o cliente recuperado;
            Conta conta = null;

            if (tipoConta == TipoConta.CC)
                conta = new ContaCorrente(cliente);
            else
                conta = new ContaPoupanca(cliente);

            listaContas.add(conta);

            System.out.println("\n" + tipoConta.getValor() + " " + conta.getAgencia() + "/" + conta.getNumero()
                    + " do cliente " + conta.getCliente().getNome() + " criada com sucesso.\n");

            return conta;
        }

        System.out.println("\nCPF " + cpf + " não encontrado na base de clientes, favor verificar.\n");
        return null;
    }

    public Cliente criarCliente(String cpf, String nome, String email, char sexo) {
        System.out.println("\n*** CRIAÇÃO DE CLIENTE:");

        Cliente cliente = new Cliente(cpf, nome, email, sexo, this);
        listaClientes.add(cliente);
        System.out.println(cliente.toString());

        return cliente;
    }

    public void listarClientes() {
        System.out.println("\n*** LISTA DE CLIENTES ***");
        for (Cliente cliente : listaClientes)
            System.out.println("Nome: "+ cliente.getNome()+ " - CPF: "+ cliente.getCpf());
        System.out.println("\n");
    }
}
