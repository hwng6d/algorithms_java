package dev.hugn.sorting;

public class MergeSort {
    public static void sort(int[] array) {
        if (array.length < 2) return;

        int midIdx = array.length / 2;
        int[] leftArray = new int[midIdx];
        int[] rightArray = new int[array.length - midIdx];

        for (int i = 0; i < midIdx; i++) {
            leftArray[i] = array[i];
        }
        for (int i = midIdx; i < array.length; i++) {
            rightArray[i - midIdx] = array[i];
        }

        sort(leftArray);
        sort(rightArray);

        merge(array, leftArray, rightArray);

    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }
}
