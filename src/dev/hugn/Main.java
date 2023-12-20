package dev.hugn;

import dev.hugn.sorting.QuickSort;
import dev.hugn.sorting.SortAlgorithms;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = createRandomInts(10, 100000000);
        long startTime, endTime;

        System.out.println("------- Before");
        printArray(numbers);

        doSort("quick", numbers);   // takes ~ 18s for 100mil items
    }

    private static void doSort(String algoName, int[] numbers) {
        System.out.printf("------- After sorting (%s sort):\n", algoName);
        int[] numbersClone = Arrays.copyOf(numbers, numbers.length);
        var algo = SortAlgorithms.valueOf(algoName.toUpperCase());
        long startTime = System.nanoTime();
        switch (algo) {
            case QUICK -> QuickSort.sort(numbersClone);
            default -> {
                System.out.println("Invalid sorting algorithm name!");
                return;
            }
        }
        long endTime = System.nanoTime();
        printArray(numbersClone, endTime - startTime);
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

    private static void printArray(int[] numbers, long executedTime) {
        printArray(numbers);
        double executedTimeInMilli = executedTime * Math.pow(10, -6);
        if (executedTimeInMilli < 1000) {
            System.out.printf("(takes %s ns = %.3f ms)", executedTime, executedTimeInMilli);
        } else {
            System.out.printf("(takes %s ns = %.3f s)", executedTime, executedTimeInMilli / 1000);
        }
    }
}
