// Задайте двумерный массив из целых чисел.
// Напишите программу, которая удалит строку и столбец, на пересечении которых расположен наименьший элемент массива.
// Под удалением понимается создание нового двумерного массива без строки и столбца

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

        void ReleaseMatrix(int[,] matrix)
        {
            int min = matrix[0,0];
            int min_row = 0;
            int min_col = 0;

            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++) {
                    if (matrix[i, j] < min){
                        min = matrix[i, j];
                        min_row = i;
                        min_col = j;
                    }
                }
            }
            
            Console.WriteLine($"Минимальное число в массиве: {min}. Индекс: {min_row}, {min_col}");

            int[,] output = new int[(matrix.GetLength(0)-1), (matrix.GetLength(1)-1)];
            int index_row = 0;
            int index_col = 0;

            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                if (i != min_row)
                {
                   for (int j = 0; j < matrix.GetLength(1); j++)
                   {
                        if (j != min_col) {
                            output[index_row, index_col] = matrix[i,j];
                            index_col++;
                        }
                   }
                    index_row++;
                    index_col = 0;
                }
            }
            Console.WriteLine("Новый массив: ");
            PrintMatrix(output);
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