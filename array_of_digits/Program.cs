// Дано натуральное число в диапазоне от 1 до 100 000. 
// Создайте массив, состоящий из цифр этого числа.
// Старший разряд числа должен располагаться на 0-м индексе массива, младший – на последнем.
// Размер массива должен быть равен количеству цифр.

Console.Clear();

int number =  new Random().Next(1, 100000);  
Console.WriteLine(number);
int i=0;
int count = number;
while (count > 0) {    i++;
    count/=10;}

int[] array = new int[i];
for (int j = 0; j < array.Length; j++){
    array[i-j-1] = number % 10;
    number /= 10;
}

Console.WriteLine(string.Join(", ", array));



