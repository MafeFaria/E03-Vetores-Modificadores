import java.text.SimpleDateFormat;

public class Conta {
    private double saldo;
    private Operacao[] operacoes;
    private int ultimaPosicao; 

    public Conta() {
        saldo = 0.0;
        operacoes = new Operacao[1000]; 
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

    public void imprimirExtrato() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        for (int i = 0; i < ultimaPosicao; i++) {
            Operacao operacao = operacoes[i];
            String tipo = operacao.getTipo() == 'd' ? "depósito" : "saque";
            System.out.println(dateFormat.format(operacao.getData()) + "\t" + tipo + "\t" + operacao.getValor());
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
