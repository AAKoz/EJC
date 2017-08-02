package task_sort_practice;

import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] massifToSort = new int[10];
        selectionSort.fillMassif(massifToSort);
        selectionSort.printMassif(massifToSort);
        selectionSort.doSelectionSort(massifToSort);
        selectionSort.printMassif(massifToSort);
    }

    /**
     * Fills unsorted massif with 10 random elements
     *
     * @param massif unsorted massif of numbers
     */
    private void fillMassif(int[] massif) {
        Random random = new Random();
        for (int i = 0; i < massif.length - 1; i++) {
            massif[i] = random.nextInt(100);
        }
    }

    /**
     * Prints content of the massif
     *
     * @param massif massif with 10 numbers
     */
    private void printMassif(int[] massif) {
        for (int i = 0; i < massif.length - 1; i++) {
            System.out.print(massif[i] + " ");
        }
        System.out.println();
    }

    /**
     * Selection sort function of list which consists 10 random numbers
     *
     * @param massif unsorted massif of numbers
     */
    private void doSelectionSort(int[] massif) {
        for (int i = 0; i < massif.length - 1; i++) {
            for (int j = i + 1; j < massif.length - 1; j++) {
                if (massif[i] > massif[j]) {
                    massif[i] += massif[j];
                    massif[j] = massif[i] - massif[j];
                    massif[i] -= massif[j];
                }
            }
        }
    }
}
