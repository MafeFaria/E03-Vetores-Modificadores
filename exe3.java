using System;

public class Operacao
{
    private char tipo;
    private double valor;
    private DateTime dataOperacao;

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
}

public class Conta
{
    private string dono;
    private int numero;
    private double saldo;
    private double limite;

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
}
