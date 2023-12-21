package dev.hugn.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = { 1, 5, 7, 9, 11, 12 };
        int result = search(array, 8);
        System.out.println("result = " + result);
    }

    public static int search(int[] array, int destiny) {
        int leftIdx = 0;
        int rightIdx = array.length - 1;

        return search(array, destiny, leftIdx, rightIdx);
    }

    public static int search(int[] array, int destiny, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) return -1;

        int midIdx = (leftIdx + rightIdx) / 2;

        if (array[midIdx] == destiny) return midIdx;
        else if (array[midIdx] < destiny) {
            return search(array, destiny, midIdx + 1, rightIdx);
        } else {
            return search(array, destiny, leftIdx, midIdx - 1);
        }
    }
}
