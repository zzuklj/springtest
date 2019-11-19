package com.klj.springtest;

import com.klj.springtest.extend.algorithms.sorts.QuickSort;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class SortTest {

    @Test
    public void sortTest(){
        Integer[] arr = {12, 3, 54, 100, 6, 23, 4, 5, 4, 32, 1};

        QuickSort.sort(arr);

       System.out.print(StringUtils.join(arr));
    }
}
