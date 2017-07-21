package task_sort_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List list = new ArrayList<Integer>();
        quickSort.fillList(list);
        quickSort.showList(list);
        quickSort.sort(list);
        quickSort.showList(list);
    }

    /**
     * Fills list with 25 numbers added from keyboard
     *
     * @param list list which will be sorted later
     */
    private void fillList(List<Integer> list) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 25; i++) {
                list.add(Integer.valueOf(reader.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints content of the list
     *
     * @param list list with 25 numbers
     */
    private void showList(List<Integer> list) {
        System.out.println(list);
    }

    public void sort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    /**
     * Quick sort function of list which consists 25 random numbers
     *
     * @param list      unsorted list
     * @param fromIndex left border of sorting
     * @param toIndex   right border of sorting
     */
    private void quickSort(List<Integer> list, int fromIndex, int toIndex) {
        if (toIndex > fromIndex) {
            int currIndex = partition(list, fromIndex, toIndex);
            quickSort(list, fromIndex, currIndex - 1);
            quickSort(list, currIndex + 1, toIndex);
        }
    }

    /**
     * Parts list on parts witch are less then pivot element and witch are more then pivot element
     *
     * @param list      unsorted list
     * @param fromIndex left border of sorting
     * @param toIndex   right border of sorting
     * @return index of pivot element
     */
    private int partition(List<Integer> list, int fromIndex, int toIndex) {
        int currIndex = fromIndex + new Random().nextInt(toIndex - fromIndex + 1);
        Object pivot = list.get(currIndex);
        swap(list, currIndex, toIndex);
        for (int i = currIndex = fromIndex; i < toIndex; ++i) {
            if (list.get(i) < (int) pivot) {
                swap(list, currIndex++, i);
            }
        }
        swap(list, currIndex, toIndex);
        return currIndex;
    }

    /**
     * Swaps list's elements
     *
     * @param list        unsorted list
     * @param firstIndex  index of first element
     * @param secondIndex index of second element
     */
    private void swap(List<Integer> list, int firstIndex, int secondIndex) {
        int tmpValue = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tmpValue);
    }
}
