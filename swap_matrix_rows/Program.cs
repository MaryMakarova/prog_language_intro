// Задайте двумерный массив.
// Напишите программу, которая поменяет местами первую и последнюю строку массива.

internal class Program
{
    private static void Main(string[] args)
    {
        void InputMatrix(int[,] matrix)
        {
            for (int i = 0; i < matrix.GetLength(0); i++)
                for (int j = 0; j < matrix.GetLength(1); j++)
                    matrix[i, j] = new Random().Next(1, 10);
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
            int[] buff_string = new int[matrix.GetLength(1)];
            for (int i = 0; i < buff_string.Length; i++)
            {
                buff_string[i] = matrix[0, i];
                matrix[0, i] = matrix[(matrix.GetLength(0) - 1), i];
                matrix[(matrix.GetLength(0) - 1), i] = buff_string[i];
            }
            Console.WriteLine("Новая матрица: ");
            PrintMatrix(matrix);
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