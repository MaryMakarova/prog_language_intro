// Задайте значения M и N.
// Напишите программу, которая выведет все натуральные числа в промежутке от M до N.
// Использовать рекурсию, не использовать циклы.

internal class Program
{
    private static void Main(string[] args)
    {
        string InBetween(int m, int n)
        {
            if (n == m)
                return $"{n}";
            return $"{m}, " + InBetween(m + 1, n);
        }

        Console.Clear();
        Console.Write("Введите число M: ");
        int m = Convert.ToInt32(Console.ReadLine());
        Console.Write("Введите число N: ");
        int n = Convert.ToInt32(Console.ReadLine());
        if (m > n)
        {
            Console.WriteLine("M должно быть меньше или равно N");
        }
        else 
        {
            Console.WriteLine(InBetween(m, n));
        }
    }
}