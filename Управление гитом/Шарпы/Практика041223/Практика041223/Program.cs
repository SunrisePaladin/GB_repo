// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");
char[] st = new char[4];
Random rchar = new Random();
for (int i = 0; i < st.GetLength(0); i++)
{
    char tmp = (char)rchar.Next(97, 122);
    st[i] = tmp;
}
for (int i = 0; i < st.GetLength(0); i++)
{
    Console.Write($"{st[i]}");
}
Console.WriteLine();

bool pal = true;
int k = 0;
while (pal && k < st.GetLength(0)/2)
{
    if (st[k] != st[st.GetLength(0) - 1-k])
    {
        pal = false;
        Console.Write(st);
        Console.Write(" - не палиндром");
        break;
    }
    k++;
}
if (pal) {
    Console.Write(st);
    Console.Write(" - палиндром");
} 