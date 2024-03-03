// Напишите программу вычисления функции Аккермана с помощью рекурсии.
// Даны два неотрицательных числа m и n.

int Akkerman(int m, int n){
    if(m==0){
        return n+1;
    }
    if(n==0){
        return Akkerman(m - 1, 1);
    }
    return Akkerman(m - 1, Akkerman (m, n - 1));
}

Console.Clear();
Console.Write("Введите число M: ");
int m = Convert.ToInt32(Console.ReadLine());
Console.Write("Введите число N: ");
int n = Convert.ToInt32(Console.ReadLine());
if (n<0 || m<0) {
    Console.Write("M и N должны быть неотрицительными");
}

    Console.WriteLine(Akkerman(m, n));
