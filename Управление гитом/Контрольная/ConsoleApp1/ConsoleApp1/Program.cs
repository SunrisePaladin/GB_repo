using System;
using System.Collections.Generic;
string[] originalArray = { "pea", "apple", "banana", "pear", "grape", "kiwi", "fig", "yam" };
List<string> newArray = new();
for (int i = 0; i < originalArray.Length; i++){
    string currentString = originalArray[i];
    if (currentString.Length <= 3){
        newArray.Add(currentString);
    }
}
Console.WriteLine(string.Join(", ", newArray));