package com.klj.springtest.extend.algorithms.sorts;


/**
 * comparing each pair of adjacent items and swapping them if they are in the wrong order
 *
 * stable: true
 *
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T[] sort(T[] unsorted){

        int length = unsorted.length;
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i = 1; i < length; i++){
                if(unsorted[i].compareTo(unsorted[i-1]) < 0){
                    T t = unsorted[i];
                    unsorted[i] = unsorted[i-1];
                    unsorted[i-1] = t;
                    swap = true;
                }
            }
            length --;
        }

        return unsorted;
    }
}
