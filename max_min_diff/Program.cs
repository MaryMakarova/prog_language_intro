// Задайте массив из вещественных чисел с ненулевой дробной частью.
// Найдите разницу между максимальным и минимальным элементов массива.

Console.Clear();
Console.Write("Введите длину массива: ");
int x = Convert.ToInt32(Console.ReadLine());
double[] array = new double[x];

for (int i = 0; i < array.Length; i++) {
    while ( (array[i] = new Random().NextDouble())==0 )  {}
    } 
Console.WriteLine(string.Join(", ", array));

double min = array[0];
double max = array[0];

for (int i = 0; i < array.Length; i++) {
    if (array[i] <= min )
    min = array[i];
    else max = array[i];
}

Console.WriteLine($"Максимальное число: {max}");
Console.WriteLine($"Минимальное число: {min}");
Console.WriteLine($"Разница между максимальным и минимальным числом массива: {(max - min)}");
