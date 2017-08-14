package task_sort_practice;

import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arrayToSort = new int[10];
        selectionSort.fillArray(arrayToSort);
        selectionSort.printArray(arrayToSort);
        selectionSort.doSelectionSort(arrayToSort);
        selectionSort.printArray(arrayToSort);
    }

    /**
     * Fills unsorted array with 10 random elements
     *
     * @param array unsorted array of numbers
     */
    private void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = random.nextInt(100);
        }
    }

    /**
     * Prints content of the array
     *
     * @param array array with 10 numbers
     */
    private void printArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Selection sort function of list which consists 10 random numbers
     *
     * @param array unsorted array of numbers
     */
    private void doSelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] > array[j]) {
                    array[i] += array[j];
                    array[j] = array[i] - array[j];
                    array[i] -= array[j];
                }
            }
        }
    }
}
