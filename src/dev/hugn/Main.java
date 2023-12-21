package dev.hugn;

import dev.hugn.searching.BinarySearch;
import dev.hugn.searching.SearchAlgorithms;
import dev.hugn.sorting.InsertionSort;
import dev.hugn.sorting.MergeSort;
import dev.hugn.sorting.QuickSort;
import dev.hugn.sorting.SortAlgorithms;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] randomNumbers = createRandomInts(100000000, 100000000);
        int[] contiguousNumber = createContiguousNumbers(1000);

        doSort("quick", randomNumbers, true, false);        // takes ~ 18s for 100mil items

        doSort("merge", randomNumbers, false, false);        // takes ~ 23s for 100mil items

        doSort("insertion", randomNumbers, false, false);     // takes ~ 1.5 day for 100mil items

        doSearch("binary", contiguousNumber, true, false);

    }

    private static void doSearch(String algoName, int[] numbers, boolean originalPrinted, boolean isDestinyPresent) {
        int[] numbersClone = Arrays.copyOf(numbers, numbers.length);
        var algo = SearchAlgorithms.valueOf(algoName.toUpperCase());

        int randomIdx = new Random().nextInt(0, numbersClone.length);
        int destiny = numbersClone[randomIdx];
        if (!isDestinyPresent) {
            numbersClone[randomIdx] += 1;
        }

        if (originalPrinted) {
            System.out.println("***** Before");
            printArray(numbersClone);
        }

        System.out.printf("------- After searching (%s search): ", algoName);
        System.out.printf("with destiny = %s: ", destiny);

        long startTime = System.nanoTime();
        switch (algo) {
            case BINARY -> System.out.printf("at index %s\n", BinarySearch.search(numbersClone, destiny));
            default -> {
                System.out.println("Invalid searching algorithm name!");
                return;
            }
        }
        long endTime = System.nanoTime();
        printExecutedTime(endTime - startTime);
    }

    private static void doSort(String algoName, int[] numbers, boolean originalPrinted, boolean resultPrinted) {
        if (originalPrinted) {
            System.out.println("***** Before");
            printArray(numbers);
        }
        System.out.printf("------- After sorting (%s sort):\n", algoName);
        int[] numbersClone = Arrays.copyOf(numbers, numbers.length);
        var algo = SortAlgorithms.valueOf(algoName.toUpperCase());
        long startTime = System.nanoTime();
        switch (algo) {
            case QUICK -> QuickSort.sort(numbersClone);
            case MERGE -> MergeSort.sort(numbersClone);
            case INSERTION -> InsertionSort.sort(numbersClone);
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

    private static int[] createContiguousNumbers(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = (i + 1) * 2;
        return array;
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
