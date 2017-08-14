package task_sort_practice;

import java.util.Random;

public class BubbleSortWithBinarySearch {
    public static void main(String[] args) {
        BubbleSortWithBinarySearch bubbleSortWithBinarySearch = new BubbleSortWithBinarySearch();
        int[] arrayToSort = new int[10];
        bubbleSortWithBinarySearch.fillArray(arrayToSort);
        bubbleSortWithBinarySearch.printArray(arrayToSort);
        bubbleSortWithBinarySearch.doBubbleSort(arrayToSort);
        bubbleSortWithBinarySearch.printArray(arrayToSort);
        System.out.println(bubbleSortWithBinarySearch.doBinarySearch(arrayToSort, arrayToSort[7]));
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
     * Bubble sort function of array which consists 10 random numbers
     *
     * @param array unsorted array of numbers
     */
    private void doBubbleSort(int[] array) {
        int swapCounter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 2; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                    swapCounter += 1;
                }
            }
            if (swapCounter == 0) {
                i = array.length;
            } else {
                swapCounter = 0;
            }
        }
    }

    /**
     * Binary search function. which checks existence of number in sorted array
     *
     * @param array         sorted array of random numbers
     * @param findingNumber number which existence checks in this function
     * @return message about the result of seeking number
     */
    private String doBinarySearch(int[] array, int findingNumber) {
        int lowerElement = 0;
        int higherElement = array.length;
        int middleElement;
        while (lowerElement <= higherElement) {
            middleElement = lowerElement + (higherElement - lowerElement) / 2;
            if (array[middleElement] == findingNumber) {
                return "Искомый элемент находится под индексом: " + middleElement;
            } else {
                if (array[middleElement] > findingNumber) {
                    higherElement = middleElement - 1;
                } else {
                    lowerElement = middleElement + 1;
                }
            }
        }
        return "Элемент не был найден";
    }
}