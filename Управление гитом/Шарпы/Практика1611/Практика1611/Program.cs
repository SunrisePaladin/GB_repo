//if (int.TryParse(Console.ReadLine(), out int res)) Console.WriteLine($"Квадрат числа – {Math.Pow(res, 2)}");
//string[] tokens = Console.ReadLine().Split();
//double a = int.Parse(tokens[0]);
//double b = int.Parse(tokens[1]);
//if (Math.Abs(Math.Round(b * b) - Math.Round(a)) < 0.0001) Console.WriteLine("Да");
//else Console.WriteLine("Нет");

//int.TryParse(Console.ReadLine(), out int d);
//Console.WriteLine("Введите день недели:");
//int day = int.Parse(Console.ReadLine());

//switch (day)
//{
//    case 1: 
//        Console.WriteLine("Пн");
//        break;
//    case 2:
//        Console.WriteLine("Вт");
//        break;
//    case 3:
//        Console.WriteLine("Ср");
//        break;
//    case 4:
//        Console.WriteLine("Чт");
//        break;
//    case 5:
//        Console.WriteLine("Пт");
//        break;
//    case 6:
//        Console.WriteLine("Сб");
//        break;
//    case 7:
//        Console.WriteLine("Вс");
//        break;
//    default: 
//        Console.WriteLine("Такого дня нет"); 
//        break;
//}

//int N = int.Parse(Console.ReadLine());
//for (int i = Math.Abs(N)*-1; i <= Math.Abs(N); i++)
//{
//    Console.Write(i.ToString() + " ");
//}

//int n = int.Parse(Console.ReadLine());
//Console.WriteLine(n % 10);


//using System;

//public class Answer
//{
//    static void CompareNumbers(int firstNumber, int secondNumber)
//    {
//        // Введите свое решение ниже
//        if (firstNumber > secondNumber)
//        {
//            Console.WriteLine($"Первое число `{firstNumber}` больше чем второе число `{secondNumber}`");
//        }
//        else if (firstNumber < secondNumber)
//        {
//            Console.WriteLine($"Первое число `{firstNumber}` меньше чем второе число `{secondNumber}`");
//        }
//        else
//        {
//            Console.WriteLine($"Введенные числа равны `{firstNumber}`");
//        }


//    }



//    // Не удаляйте и не меняйте метод Main! 
//    static public void Main(string[] args)
//    {
//        int firstNumber, secondNumber;

//        if (args.Length >= 2)
//        {
//            firstNumber = int.Parse(args[0]);
//            secondNumber = int.Parse(args[1]);
//        }
//        else
//        {
//            // Здесь вы можете поменять значения для отправки кода на Выполнение
//            firstNumber = 5;
//            secondNumber = 5;
//        }
//        // Не удаляйте строки ниже
//        CompareNumbers(firstNumber, secondNumber);
//    }
//}

using System;

public class Answer
{
    static void PrintEvenNumbers(int number)
    {
        // Введите свое решение ниже
        for (int i = 1; i <= number; i++) if (i % 2 == 0) if (i!=number) Console.Write($"{i}\t"); else Console.Write(i);
    }


    // Не удаляйте и не меняйте метод Main! 
    static public void Main(string[] args)
    {
        int number;

        if (args.Length >= 1)
        {
            number = int.Parse(args[0]);
        }
        else
        {
            // Здесь вы можете поменять значения для отправки кода на Выполнение
            number = 5;
        }

        // Не удаляйте строки ниже
        PrintEvenNumbers(number);
    }
}