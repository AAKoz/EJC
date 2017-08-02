package task_sort_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            list.add(random.nextInt(500));
        }
        System.out.println(list);
        System.out.println(new InsertionSort().insertionSort(list));
    }

    /**
     * Insertion sort function of list which consists 25 random numbers
     *
     * @param list unsorted list of numbers
     * @return sorted list of numbers
     */
    public List<Integer> insertionSort(List<Integer> list) {
        int index;
        for (int i = 1; i < list.size(); i++) {
            int currValue = list.get(i);
            index = i;
            while (index > 0 && list.get(index - 1) > currValue) {
                list.set(index, list.get(index - 1));
                index--;
            }
            list.set(index, currValue);
        }
        return list;
    }
}
