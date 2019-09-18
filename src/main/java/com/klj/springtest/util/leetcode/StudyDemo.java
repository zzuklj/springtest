package com.klj.springtest.util.leetcode;

import java.util.HashMap;

/**
 * @author klj
 * @Title: StudyDemo
 * @Description: TODO
 * @date 2018/10/2411:41
 */
public class StudyDemo {
    public static void main(String[] args) {
        twoSum();
    }

    private static void twoSum(){
        Integer[] arr = {2,5,7,13,4,67};
        int sum = 9;
        int length = arr.length;
        //暴力法
        /*for(int i=0; i<length;i++){
            for(int j = i; j<length;j++){
                Integer s = arr[i]+arr[j];
                if(s.equals(sum)){
                    System.out.println(i+"====="+j);
                }
            }
        }*/

        //hash
        HashMap<Integer, Integer> map = new HashMap<>(length);
        for(int i=0; i<length;i++){
            int comp = sum - arr[i];
            if(map.containsKey(comp)){
                System.out.println(i+"======="+map.get(comp));
            }
            map.put(arr[i],i);
        }
    }
}
