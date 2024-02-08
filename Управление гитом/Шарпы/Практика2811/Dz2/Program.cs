internal class Program
{
    public static Random random = new Random();
    private static void Main(string[] args)
    {
        Console.WriteLine("Введите длину");
        int.TryParse(Console.ReadLine(), out int w);
        int[,] arr = new int[w,w];
        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < w; j++)
            {
                int tmp = random.Next(1, 100);
                arr[i,j] = tmp;
                Console.Write($"{tmp}, ");
            }
            Console.WriteLine("");
        }
        int [] minsumm = new int[w];
        for (int i = 0; i < arr.GetLength(0); i++)
        {
            for (int j = 0; j < arr.GetLength(1); j++)
            {
                minsumm[i] += arr[i, j];
            }
        }
        foreach (int i in minsumm)
        {
            Console.WriteLine(i);
        }
        Console.WriteLine("____________________");
        Console.WriteLine($"Минимальная сумма строки {minsumm.Min()} находится в строке {Array.IndexOf(minsumm, minsumm.Min()) + 1}");
    }
}