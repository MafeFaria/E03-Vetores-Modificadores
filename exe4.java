using System;

public class Operacao
{
    private static int totalOperacoes = 0;

    private char tipo;
    private double valor;
    private DateTime dataOperacao;

    public Operacao()
    {
        totalOperacoes++;
    }

    public char Tipo
    {
        get => tipo;
        set
        {
            if (value == 'd' || value == 's')
                tipo = value;
            else
                Console.WriteLine("Tipo de operação inválido.");
        }
    }

    public double Valor
    {
        get => valor;
        set => valor = value;
    }

    public DateTime DataOperacao
    {
        get => dataOperacao;
    }

    public static int TotalOperacoes
    {
        get => totalOperacoes;
    }
}

public class Conta
{
    private static int totalContas = 0;

    private string dono;
    private int numero;
    private double saldo;
    private double limite;

    public Conta()
    {
        totalContas++;
    }

    public string Dono
    {
        get => dono;
        set => dono = value;
    }

    public int Numero
    {
        get => numero;
        set => numero = value;
    }

    public double Saldo
    {
        get => saldo;
    }

    public double Limite
    {
        get => limite;
        set
        {
            if (value >= 0)
                limite = value;
            else
            {
                Console.WriteLine("Limite não pode ser negativo. Definindo limite como zero.");
                limite = 0;
            }
        }
    }

    public static int TotalContas
    {
        get => totalContas;
    }
}

class Program
{
    static void Main(string[] args)
    {
        Conta c1 = new Conta();
        Conta c2 = new Conta();

        Operacao op1 = new Operacao();
        Operacao op2 = new Operacao();
        Operacao op3 = new Operacao();

        double mediaOperacoesPorConta = (double)Operacao.TotalOperacoes / Conta.TotalContas;

        Console.WriteLine($"Total de contas criadas: {Conta.TotalContas}");
        Console.WriteLine($"Total de operações realizadas: {Operacao.TotalOperacoes}");
        Console.WriteLine($"Média de operações por conta: {mediaOperacoesPorConta}");
    }
}
