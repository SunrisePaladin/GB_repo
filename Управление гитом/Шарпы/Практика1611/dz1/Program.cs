using System;
using System.Numerics;
using System.Collections.Generic;

public class Answer
{

    static void FindMaxNum(uint n)
    {
        List<uint> digits = new List<uint>();
        while (n > 10)
        {
            uint digit = n % 10;
            digits.Add(digit);
            n /= 10;
            Console.WriteLine(digit);
            Console.WriteLine(n);
        }
        digits.Add(n);
        digits.Reverse();
        foreach (int digit in digits)
        {
            Console.Write($"{digit}, ");
        }
    }

    // Не удаляйте и не меняйте метод Main! 
    static public void Main()
    {
        uint.TryParse(Console.ReadLine(), out uint num);
        FindMaxNum(num);
    }
}