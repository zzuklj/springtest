package com.klj.springtest.extend.algorithms.sorts;

public class QuickSort<T extends Comparable<T>> {
    
    public static <T extends Comparable<T>> T[] sort(T[] unsorted){

        quickSort(unsorted, 0, unsorted.length-1);

        return unsorted;
    }

    private static <T extends Comparable<T>> void quickSort(T[] unsorted, int left, int right){
        if(left > right){
            return;
        }

        int i = left;
        int j = right;
        T temp = unsorted[left];

        while(i < j){
            if(unsorted[i].compareTo(temp) < 0){
                i ++;
            }

            if(unsorted[j].compareTo(temp) > 0){
                j --;
            }

            if(i < j){
                T t = unsorted[i];
                unsorted[j] = unsorted[i];
                unsorted[i] = t;
            }
        }

        unsorted[left] = unsorted[i];
        unsorted[i] = temp;

        quickSort(unsorted, left, j-1);
        quickSort(unsorted, i+1, right);

    }


}
