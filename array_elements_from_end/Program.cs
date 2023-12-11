// Задайте произвольный массив.
// Выведете его элементы, начиная с конца. Использовать рекурсию, не использовать циклы.

internal class Program
{
    private static void Main(string[] args)
    {
        string FlipArray(int[] array, int i)
        {
            if (i == 0)
                return $"{array[i]}";
            return $"{array[i]}, " + FlipArray(array, i - 1);
        }

        Console.Clear();
        Console.Write("Введите длину массива: ");
        int x = Convert.ToInt32(Console.ReadLine());

        int[] array = new int[x];

        for (int i = 0; i < array.Length; i++)
        {
            while ((array[i] = new Random().Next(1, 100)) == 0) { }
        }
        Console.WriteLine(string.Join(", ", array));

        Console.WriteLine(FlipArray(array, array.Length - 1));
    }
}