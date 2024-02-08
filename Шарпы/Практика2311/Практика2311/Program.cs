using System.Collections.Generic;

internal class Program
{
    private static void Main(string[] args)
    {
        Random rnd = new Random();
        List<int> arr = new List<int>();

        int num = rnd.Next(1, 100000);
        Console.WriteLine(num);
        while (num >= 10)
        { 
            int tmp = num % 10;
            arr.Add(tmp);
            num /= 10;
        }
        arr.Add(num);
        arr.Reverse();
        for (int i = 0; i < arr.Count(); i++)
        {
            Console.Write(arr[i]);
        }
    }
}