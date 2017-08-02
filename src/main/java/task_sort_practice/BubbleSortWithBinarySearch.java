package task_sort_practice;

import java.util.Random;

public class BubbleSortWithBinarySearch {
    public static void main(String[] args) {
        BubbleSortWithBinarySearch bubbleSortWithBinarySearch = new BubbleSortWithBinarySearch();
        int[] massifToSort = new int[10];
        bubbleSortWithBinarySearch.fillMassif(massifToSort);
        bubbleSortWithBinarySearch.printMassif(massifToSort);
        bubbleSortWithBinarySearch.doBubbleSort(massifToSort);
        bubbleSortWithBinarySearch.printMassif(massifToSort);
        System.out.println(bubbleSortWithBinarySearch.doBinarySearch(massifToSort, massifToSort[2]));
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
     * Bubble sort function of massif which consists 10 random numbers
     *
     * @param massif unsorted massif of numbers
     */
    private void doBubbleSort(int[] massif) {
        int swapCounter = 0;
        for (int i = 0; i < massif.length - 1; i++) {
            for (int j = 0; j < massif.length - 2; j++) {
                if (massif[j] > massif[j + 1]) {
                    massif[j] = massif[j] + massif[j + 1];
                    massif[j + 1] = massif[j] - massif[j + 1];
                    massif[j] = massif[j] - massif[j + 1];
                    swapCounter += 1;
                }
            }
            if (swapCounter == 0) {
                i = massif.length;
            } else {
                swapCounter = 0;
            }
        }
    }

    /**
     * Binary search function. which checks existence of number in sorted massif
     *
     * @param massif sorted massif of random numbers
     * @param findingNumber number which existence checks in this function
     * @return message about the result of seeking number
     */
    private String doBinarySearch(int[] massif, int findingNumber) {
        int lowerElement = 0;
        int higherElement = massif.length;
        int middleElement;
        while (lowerElement <= higherElement) {
            middleElement = lowerElement + (higherElement - lowerElement) / 2;
            if (massif[middleElement] == findingNumber) {
                return "Искомый элемент находится под индексом: " + middleElement;
            } else {
                if (massif[middleElement] > findingNumber) {
                    higherElement = middleElement - 1;
                } else {
                    lowerElement = middleElement + 1;
                }
            }
        }
        return "Элемент не был найден";
    }
}