package task_sort_practice;

import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arrayToSort = new int[10];
        mergeSort.fillArray(arrayToSort);
        mergeSort.printArray(arrayToSort);
        mergeSort.doMergeSort(arrayToSort, 0, arrayToSort.length - 1);
        mergeSort.printArray(arrayToSort);
    }

    /**
     * Fills unsorted array with 10 random elements
     *
     * @param array unsorted array of numbers
     */
    private void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
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
     * Splits array on sections till sections' size will be equal 1
     *
     * @param array       unsorted array of numbers
     * @param lowElement  the lowest edge of section
     * @param highElement the highest edge of section
     */
    private void doMergeSort(int[] array, int lowElement, int highElement) {
        int middleElement = (highElement + lowElement) / 2;
        if (lowElement < highElement) {
            doMergeSort(array, lowElement, middleElement);
            doMergeSort(array, middleElement + 1, highElement);
        }
        if (lowElement != highElement) {
            doMerge(array, lowElement, middleElement, highElement);
        }
    }

    /**
     * Merges sections to bigger and sorted ones
     *
     * @param array         unsorted array of numbers
     * @param lowElement    the lowest edge of section
     * @param middleElement middle index of section
     * @param highElement   the highest edge of section
     */
    private void doMerge(int[] array, int lowElement, int middleElement, int highElement) {
        int counterElement = 1;
        int counterSupportArray = 0;
        int[] supportArray = new int[highElement - lowElement + 1];
        int unchangedLowElement = lowElement;
        while (lowElement <= middleElement && middleElement + counterElement <= highElement) {
            if (array[lowElement] < array[middleElement + counterElement]) {
                supportArray[counterSupportArray] = array[lowElement];
                lowElement++;
                counterSupportArray++;
            } else {
                supportArray[counterSupportArray] = array[middleElement + counterElement];
                counterElement++;
                counterSupportArray++;
            }
        }
        while (lowElement <= middleElement) {
            supportArray[counterSupportArray] = array[lowElement];
            lowElement++;
            counterSupportArray++;
        }
        while (middleElement + counterElement <= highElement) {
            supportArray[counterSupportArray] = array[middleElement + counterElement];
            counterElement++;
            counterSupportArray++;
        }
        System.arraycopy(supportArray, 0, array, unchangedLowElement, supportArray.length);
    }
}
