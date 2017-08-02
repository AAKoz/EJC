package task_sort_practice.radix_sort;

import java.util.Random;

public class LSDRadixSort {
    public static void main(String[] args) {
        LSDRadixSort radixSort = new LSDRadixSort();
        int[] massifToSort = new int[10];
        radixSort.fillMassif(massifToSort);
        radixSort.printMassif(massifToSort);
        int countDigits = radixSort.findCountDigits(massifToSort);
        radixSort.doRadixSort(massifToSort, countDigits);
        radixSort.printMassif(massifToSort);
    }

    /**
     * Fills unsorted massif with 10 random elements
     *
     * @param massif unsorted massif of numbers
     */
    private void fillMassif(int[] massif) {
        Random random = new Random();
        for (int i = 0; i < massif.length; i++) {
            massif[i] = random.nextInt(1000);
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
     * Finds how many digits has the biggest number
     *
     * @param massif massif with 10 numbers
     * @return count of digits in the biggest number
     */
    private int findCountDigits(int[] massif) {
        int max = massif[0];
        int countOfDigits = 1;
        for (int i = 1; i < massif.length; i++) {
            if (max < massif[i]) {
                max = massif[i];
            }
        }
        while (max > 9) {
            max = max / 10;
            countOfDigits++;
        }
        return countOfDigits;
    }

    /**
     * LSD radix sort function of massif which consists 10 random numbers
     *
     * @param massif      unsorted massif of numbers
     * @param countDigits count of digits in the biggest number
     */
    private void doRadixSort(int[] massif, int countDigits) {
        int[] assistantMas = new int[10];
        System.arraycopy(massif, 0, assistantMas, 0, 10);
        for (int i = 0; i < countDigits; i++) {
            for (int j = 0; j < massif.length; j++) {
                for (int k = 0; k < i; k++) {
                    assistantMas[j] = assistantMas[j] / 10;
                }
                assistantMas[j] = assistantMas[j] % 10;
            }
            for (int j = 0; j < massif.length; j++) {
                for (int k = 0; k < assistantMas.length; k++) {
                    if (assistantMas[j] < assistantMas[k]) {
                        assistantMas[j] += assistantMas[k];
                        assistantMas[k] = assistantMas[j] - assistantMas[k];
                        assistantMas[j] -= assistantMas[k];

                        massif[j] += massif[k];
                        massif[k] = massif[j] - massif[k];
                        massif[j] -= massif[k];
                    }
                }
            }
            System.arraycopy(massif, 0, assistantMas, 0, 10);
        }
    }
}