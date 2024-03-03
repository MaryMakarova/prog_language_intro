// Задайте прямоугольный двумерный массив.
// Напишите программу, которая будет находить строку с наименьшей суммой элементов.

internal class Program
{
    private static void Main(string[] args)
    {
        void InputMatrix(int[,] matrix)
        {
            for (int i = 0; i < matrix.GetLength(0); i++)
                for (int j = 0; j < matrix.GetLength(1); j++)
                    matrix[i, j] = new Random().Next(1, 100);
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

        int LineSum(int[,] array, int i)
        {
            int sum = array[i,0];
            for (int j = 1; j < array.GetLength(1); j++)
            {
                sum += array[i,j];
             }
            return sum;
        }

        void ReleaseMatrix(int[,] matrix)
        {
            int line_counter = 0;
            int min_sum = LineSum(matrix, 0);
            Console.WriteLine($"Сумма чисел в 0 строке: {LineSum(matrix, 0)}");

            for (int i = 1; i < matrix.GetLength(0); i++)
            {  
                int line_sum = LineSum(matrix, i);
                Console.WriteLine($"Сумма чисел в {i} строке: {LineSum(matrix, i)}");
                if (line_sum < min_sum) {
                    min_sum = line_sum;
                    line_counter = i;
                }
            }
            Console.WriteLine($"Строка с минимальной суммой элементов: {line_counter}"); 
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
