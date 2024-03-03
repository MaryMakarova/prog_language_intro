// Напишите программу, которая на вход принимает позиции элемента в двумерном массиве,
// и возвращает значение этого элемента или же указание, что такого элемента нет.


internal class Program
{
    private static void Main(string[] args)
    {
        void InputMatrix(int[,] matrix)
        {
            for (int i = 0; i < matrix.GetLength(0); i++)
                for (int j = 0; j < matrix.GetLength(1); j++)
                    matrix[i, j] = new Random().Next();
        }

        void PrintMatrix(int[,] matrix)
        {
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                    Console.Write(matrix[i, j] + "\t");
                Console.WriteLine();
            }
        }

        void ReleaseMatrix(int[,] matrix)
        {
            while (true)
            {
                Console.Write("Введите индекс элемента: ");
                int[] index = Console.ReadLine().Split(" ").Select(y => int.Parse(y)).ToArray();
                if (index[0] > matrix.GetLength(0) || index[1] > matrix.GetLength(0))
                {
                    Console.Write("Такого элемента нет.");
                    Console.WriteLine();
                }
                else
                {
                    Console.Write(matrix[index[0], index[1]]);
                    break;
                }
            }
        }


        Console.Clear();
        Console.Write("Введите размеры матрицы: ");
        int[] size = Console.ReadLine().Split(" ").Select(x => int.Parse(x)).ToArray();
        int[,] matrix = new int[size[0], size[1]];
        InputMatrix(matrix);
        PrintMatrix(matrix);
        ReleaseMatrix(matrix);
    }
}