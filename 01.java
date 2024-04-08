import java.util.Date;

public class Conta {
    private double saldo;
    private Operacao[] operacoes;
    private int ultimaPosicao; // Atributo auxiliar para controlar a última posição disponível em operacoes

    public Conta() {
        saldo = 0.0;
        operacoes = new Operacao[1000]; // Inicializando o array de operações com tamanho 1000
        ultimaPosicao = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
        Operacao novaOperacao = new Operacao('d', valor, new Date());
        adicionarOperacao(novaOperacao);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            Operacao novaOperacao = new Operacao('s', valor, new Date());
            adicionarOperacao(novaOperacao);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    private void adicionarOperacao(Operacao operacao) {
        if (ultimaPosicao < 1000) {
            operacoes[ultimaPosicao] = operacao;
            ultimaPosicao++;
        } else {
            System.out.println("Limite máximo de operações atingido.");
        }
    }
}
