import java.util.Arrays;
import java.util.*;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Введите свое решение ниже

    }

    public static void heapSort(int[] sortArray, int sortLength) {
        // Введите свое решение ниже
        for (int i = 0; i < sortLength - 1; i++){
            for (int j = 0; j < sortLength - i - 1; j++){ 
                if (sortArray[j] > sortArray[j + 1]){
                    int tmp=sortArray[j];
                    sortArray[j]=sortArray[j+1];
                    sortArray[j+1]=tmp;
                }
            }
        }
}

    // Не удаляйте и не меняйте метод Main!
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[] { 17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1 };
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}