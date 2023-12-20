package dev.hugn;

import dev.hugn.sorting.QuickSort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = createRandomInts(100000000, 100000000);
        long startTime, endTime;

        System.out.println("------- Before");
        printArray(numbers);
        int[] numbersClone;

        System.out.println("------- After sorting (Quick sort): "); // takes ~18s for 100mil items
        numbersClone = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        QuickSort.sort(numbersClone);
        endTime = System.nanoTime();
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
