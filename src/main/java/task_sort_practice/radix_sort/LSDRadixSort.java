package task_sort_practice.radix_sort;

import java.util.Random;

public class LSDRadixSort {
    public static void main(String[] args) {
        LSDRadixSort radixSort = new LSDRadixSort();
        int[] arrayToSort = new int[10];
        radixSort.fillArray(arrayToSort);
        radixSort.printArray(arrayToSort);
        int countDigits = radixSort.findCountDigits(arrayToSort);
        radixSort.doRadixSort(arrayToSort, countDigits);
        radixSort.printArray(arrayToSort);
    }

    /**
     * Fills unsorted array with 10 random elements
     *
     * @param array unsorted array of numbers
     */
    private void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
    }

    /**
     * Prints content of the array
     *
     * @param array array with 10 numbers
     */
    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Finds how many digits has the biggest number
     *
     * @param array array with 10 numbers
     * @return count of digits in the biggest number
     */
    private int findCountDigits(int[] array) {
        int max = array[0];
        int countOfDigits = 1;
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        while (max > 9) {
            max = max / 10;
            countOfDigits++;
        }
        return countOfDigits;
    }

    /**
     * LSD radix sort function of array which consists 10 random numbers
     *
     * @param array       unsorted array of numbers
     * @param countDigits count of digits in the biggest number
     */
    private void doRadixSort(int[] array, int countDigits) {
        int[] assistantArray = new int[10];
        System.arraycopy(array, 0, assistantArray, 0, 10);
        for (int i = 0; i < countDigits; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < i; k++) {
                    assistantArray[j] = assistantArray[j] / 10;
                }
                assistantArray[j] = assistantArray[j] % 10;
            }
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < assistantArray.length; k++) {
                    if (assistantArray[j] < assistantArray[k]) {
                        assistantArray[j] += assistantArray[k];
                        assistantArray[k] = assistantArray[j] - assistantArray[k];
                        assistantArray[j] -= assistantArray[k];

                        array[j] += array[k];
                        array[k] = array[j] - array[k];
                        array[j] -= array[k];
                    }
                }
            }
            System.arraycopy(array, 0, assistantArray, 0, 10);
        }
    }
}