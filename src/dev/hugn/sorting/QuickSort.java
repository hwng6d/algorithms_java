package dev.hugn.sorting;

import java.util.*;

public class QuickSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) return;

        int pivotIdx = highIdx;
        int pivot = array[pivotIdx];

        int leftPointer = partition(array, lowIdx, highIdx, pivot);
        sort(array, lowIdx, leftPointer - 1);
        sort(array, leftPointer + 1, highIdx);
    }

    private static int partition(int[] array, int lowIdx, int highIdx, int pivot) {
        int leftPointer = lowIdx;
        int rightPointer = highIdx - 1; // because highIdx is almost pivotIdx

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) leftPointer += 1;
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) rightPointer -= 1;
            swap(array, leftPointer, rightPointer);
        }

        if (array[leftPointer] > array[highIdx])
            swap(array, leftPointer, highIdx);
        else
            leftPointer = highIdx;

        return leftPointer;
    }

    private static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
