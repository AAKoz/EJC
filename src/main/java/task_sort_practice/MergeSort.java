package task_sort_practice;

import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] massifToSort = new int[10];
        mergeSort.fillMassif(massifToSort);
        mergeSort.printMassif(massifToSort);
        mergeSort.doMergeSort(massifToSort, 0, massifToSort.length - 1);
        mergeSort.printMassif(massifToSort);
    }

    /**
     * Fills unsorted massif with 10 random elements
     *
     * @param massif unsorted massif of numbers
     */
    private void fillMassif(int[] massif) {
        Random random = new Random();
        for (int i = 0; i < massif.length; i++) {
            massif[i] = random.nextInt(100);
        }
    }

    /**
     * Prints content of the massif
     *
     * @param massif massif with 10 numbers
     */
    private void printMassif(int[] massif) {
        for (int i = 0; i < massif.length; i++) {
            System.out.print(massif[i] + " ");
        }
        System.out.println();
    }

    /**
     * Splits massif on sections till sections' size will be equal 1
     *
     * @param massif      unsorted massif of numbers
     * @param lowElement  the lowest edge of section
     * @param highElement the highest edge of section
     */
    private void doMergeSort(int[] massif, int lowElement, int highElement) {
        int middleElement = (highElement + lowElement) / 2;
        if (lowElement < highElement) {
            doMergeSort(massif, lowElement, middleElement);
            doMergeSort(massif, middleElement + 1, highElement);
        }
        if (lowElement != highElement) {
            doMerge(massif, lowElement, middleElement, highElement);
        }
    }

    /**
     * Merges sections to bigger and sorted ones
     *
     * @param massif        unsorted massif of numbers
     * @param lowElement    the lowest edge of section
     * @param middleElement middle index of section
     * @param highElement   the highest edge of section
     */
    private void doMerge(int[] massif, int lowElement, int middleElement, int highElement) {
        int counterElement = 1;
        int counterSupportMassif = 0;
        int[] supportMassif = new int[highElement - lowElement + 1];
        int unchangedLowElement = lowElement;
        while (lowElement <= middleElement && middleElement + counterElement <= highElement) {
            if (massif[lowElement] < massif[middleElement + counterElement]) {
                supportMassif[counterSupportMassif] = massif[lowElement];
                lowElement++;
                counterSupportMassif++;
            } else {
                supportMassif[counterSupportMassif] = massif[middleElement + counterElement];
                counterElement++;
                counterSupportMassif++;
            }
        }
        while (lowElement <= middleElement) {
            supportMassif[counterSupportMassif] = massif[lowElement];
            lowElement++;
            counterSupportMassif++;
        }
        while (middleElement + counterElement <= highElement) {
            supportMassif[counterSupportMassif] = massif[middleElement + counterElement];
            counterElement++;
            counterSupportMassif++;
        }
        System.arraycopy(supportMassif, 0, massif, unchangedLowElement, supportMassif.length);
    }
}
