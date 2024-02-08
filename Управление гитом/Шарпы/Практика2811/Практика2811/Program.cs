// See https://aka.ms/new-console-template for more information
//Console.WriteLine("Hello, World!");

using System.Numerics;
using System.Runtime.InteropServices;
using System;
using Extreme.Mathematics.LinearAlgebra;

Vector <int> a = new Vector<int>(10);

Random random = new();
Console.WriteLine("Введите размер массива");
int.TryParse(Console.ReadLine(), out int r);
List<int> arr = new List<int>();
for  (int i = 0; i < r; i++)
{
    int h = random.Next(1, 100);
    arr.Add(h);
    Console.Write($"{arr[i]}, ");
}
Console.WriteLine();
arr.Reverse();
foreach (int i in arr)
{
    Console.Write($"{i}, ");
}
Console.WriteLine();