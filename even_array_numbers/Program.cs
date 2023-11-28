// Задайте массив на 10 целых чисел. 
// Напишите программу, которая определяет количество чётных чисел в массиве.

Console.Clear();
int[] array = new int[10];
int count = 0;

for (int i = 0; i < array.Length; i++)
array[i] = new Random().Next();  
Console.WriteLine(string.Join(", ", array));
for (int i = 0; i < array.Length; i++) {
    if (array[i] % 2 ==0 )
    count++;
}
Console.WriteLine($"Количество четных чисел в массиве: {count}");