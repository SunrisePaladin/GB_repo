// See https://aka.ms/new-console-template for more information

//static void numNext(int N, int M)
//{
//    if (N<=M)
//    {
//        Console.Write($"{N} ");
//        numNext(N + 1, M);
//    }
//    else Console.WriteLine("");
//}

//Random rnd = new Random();
//int M = rnd.Next(1, 100);
//int N = rnd.Next(1, 100);
//if (M <= N) Console.WriteLine($"Нет подходящих значений, M={M} < N={N}");
//else
//{
//    Console.WriteLine($"Числа на входе: {N}, {M}");
//    numNext(N, M);
//}

//static int Ack(int m, int n)
//{
//    if (m < 0 || n < 0)
//    {
//        Console.WriteLine("Значения на входе меньше 0");
//        return 0;
//    }
//    if (m == 0) return n+1;
//    else if (m > 0 && n == 0) return Ack(m-1, 1);
//    else return Ack(m-1, Ack(m, n-1));
//}

//Console.WriteLine("Введите m");
//int.TryParse(Console.ReadLine(), out int m);
//Console.WriteLine("Введите n");
//int.TryParse(Console.ReadLine(), out int n);
//Console.WriteLine(Ack(m,n));


// List.reverse() сделает всё за нас, но задание есть задание
int[] arr = new int[20];
Random rnd = new Random();

void reversMass(int i)
{
    if (i >= 0)
    {
        Console.Write($"{arr[i]} ");
        reversMass(i-1);
    }
}

for  (int i = 0; i < 20; i++)
{
    int tmp = rnd.Next(1, 100);
    arr[i] = tmp;
    Console.Write($"{arr[i]} ");
}
Console.WriteLine();
reversMass(arr.GetLength(0)-1);