package dev.hugn;

import dev.hugn.sorting.MergeSort;
import dev.hugn.sorting.QuickSort;
import dev.hugn.sorting.SortAlgorithms;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = createRandomInts(10000000, 100000);

        System.out.println("------- Before");
        // printArray(numbers);

        doSort("quick", numbers, false);    // takes ~ 18s for 100mil items

        doSort("merge", numbers, false);    // takes ~ 23s for 100mil items

    }

    private static void doSort(String algoName, int[] numbers, boolean resultPrinted) {
        System.out.printf("------- After sorting (%s sort):\n", algoName);
        int[] numbersClone = Arrays.copyOf(numbers, numbers.length);
        var algo = SortAlgorithms.valueOf(algoName.toUpperCase());
        long startTime = System.nanoTime();
        switch (algo) {
            case QUICK -> QuickSort.sort(numbersClone);
            case MERGE -> MergeSort.sort(numbersClone);
            default -> {
                System.out.println("Invalid sorting algorithm name!");
                return;
            }
        }
        long endTime = System.nanoTime();
        if (resultPrinted) {
            printArray(numbersClone);
        }
        printExecutedTime(endTime - startTime);
    }

    private static int[] createRandomInts(int length, int numberBound) {
        Random random = new Random();
        int[] numbers = new int[length];

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = random.nextInt(numberBound);

        return numbers;
    }

    private static void printArray(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    private static void printExecutedTime(long executedTime) {
        double executedTimeInMilli = executedTime * Math.pow(10, -6);
        if (executedTimeInMilli < 1000) {
            System.out.printf("(takes %s ns = %.3f ms)\n", executedTime, executedTimeInMilli);
        } else {
            System.out.printf("(takes %s ns = %.3f s)\n", executedTime, executedTimeInMilli / 1000);
        }
    }
}
