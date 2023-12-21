package dev.hugn.sorting;

public class SelectionSort {
    public static void sort(int[] array)  {
        for (int i = 0; i < array.length; i++) {
            int currentSmallest = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] <= array[currentSmallest]) {
                    currentSmallest = j;
                }
            }
            swap(array, i, currentSmallest);
        }
    }

    private static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
