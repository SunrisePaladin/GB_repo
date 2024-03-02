import java.util.*;

class MergeSort {
    public int[] mergeSort(int[] arrayA) {
        if (arrayA == null) {
            return null;
        }
        if (arrayA.length < 2) {
            return arrayA;
        }
        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        for (int i = 0; i < arrayB.length ; i++) {
            System.out.print(arrayB[i] + " ");
        }
        for (int i = 0; i < arrayC.length ; i++) {
            System.out.print(arrayC[i] + " ");
        }
        arrayB = mergeSort(arrayB);
        arrayC = mergeSort(arrayC);
        return arrayB;
        //return mergeArray(arrayB, arrayC);
    }
    public int[] mergeArray(int[] arrayA, int[] arrayB) {
        
        int [] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;
        int sizeA = arrayA.length;
        int sizeB = arrayB.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayC.length; i++) {
            System.out.println(positionA);
            System.out.println(positionB);
            if (positionA == sizeA){
                arrayC[i] = arrayB[i - positionB];    
                sb.append(i).append(" pos1 ").append(positionA).append(" ").append(positionB).append("\n");
                positionB++;
            } 
            else if (positionB == sizeB) {
                arrayC[i] = arrayA[i - positionA];
                sb.append(i).append(" pos2 ").append(positionA).append(" ").append(positionB).append("\n");
                positionA++;
            } 
            else if (arrayA[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayA[i - positionA];
                sb.append(i).append(" pos3 ").append(positionA).append(" ").append(positionB).append("\n");
                positionB++;
            } 
            else {
                arrayC[i] = arrayB[i - positionB];
                sb.append(i).append(" pos4 ").append(positionA).append(" ").append(positionB).append("\n");
                positionA++;
            }
            //System.out.println(sb.toString());
            
        }
        
        for (int i = 0; i < arrayC.length ; i++) {
            System.out.print(arrayC[i] + " ");
        }
        return arrayC;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
        int[] a;

        if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int [] b = new int[]{8, 9, 0, -1, 10, 7};
        MergeSort answer = new MergeSort();
        int [] c = answer.mergeArray(a, b);
        
        // for (int i = 0; i < c.length ; i++) {
        //     System.out.print(c[i] + " ");
        // }

        //String itresume_res = Arrays.toString(answer.mergeSort(a));
        //System.out.println(itresume_res);
    }
}
