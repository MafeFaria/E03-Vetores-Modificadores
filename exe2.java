using System;

// Classe Operacao fornecida
public class Operacao
{
    public char TipoOperacao { get; set; }
    public double Valor { get; set; }
    public DateTime DataOperacao { get; set; }
}

public class Conta
{
    // Atributos existentes da classe Conta
    public int Numero { get; set; }
    public string Titular { get; set; }
    public double Saldo { get; private set; }

    // Novo atributo para armazenar operações
    private Operacao[] operacoes = new Operacao[1000];
    private int indiceOperacoes = 0; // Índice para controlar a última posição usada no vetor operacoes

    // Método para depositar
    public void Depositar(double valor)
    {
        if (valor <= 0)
        {
            Console.WriteLine("Valor inválido para depósito.");
            return;
        }

        // Realiza o depósito
        Saldo += valor;
        
        // Registra a operação de depósito
        operacoes[indiceOperacoes] = new Operacao
        {
            TipoOperacao = 'd',
            Valor = valor,
            DataOperacao = DateTime.Now
        };
        indiceOperacoes++; // Atualiza o índice para a próxima operação
    }

    // Método para sacar
    public void Sacar(double valor)
    {
        if (valor <= 0)
        {
            Console.WriteLine("Valor inválido para saque.");
            return;
        }

        if (valor > Saldo)
        {
            Console.WriteLine("Saldo insuficiente para saque.");
            return;
        }

        // Realiza o saque
        Saldo -= valor;

        // Registra a operação de saque
        operacoes[indiceOperacoes] = new Operacao
        {
            TipoOperacao = 's',
            Valor = valor,
            DataOperacao = DateTime.Now
        };
        indiceOperacoes++; // Atualiza o índice para a próxima operação
    }

    // Método para exibir o extrato de operações
    public void ExibirExtrato()
    {
        Console.WriteLine("Extrato de Operações:");
        foreach (Operacao op in operacoes)
        {
            if (op != null)
            {
                string tipo = op.TipoOperacao == 'd' ? "Depósito" : "Saque";
                Console.WriteLine($"{op.DataOperacao}\t{op.TipoOperacao}\t{op.Valor}");
            }
        }
    }
}
