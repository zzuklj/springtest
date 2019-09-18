package com.klj.springtest.extend.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author klj
 * @Title: MapDemo
 * @Description: TODO
 * @date 2018/8/1411:18
 */
public class MapDemo {

    public static void main(String[] args) {
        ArrayList<HashMap> list = new ArrayList<>();
        Random rand = new Random();
        for(int i =0; i < 5; i++){
            HashMap<Object, Object> map = new HashMap<>();
            map.put("key", rand.nextInt(10));
            map.put("date",new Date());
            list.add(map);
        }

        list.stream().forEach( e -> {
            System.out.println(e.get("key"));
            }
        );

        System.out.println("=============================");

        ArrayList<HashMap> newList = (ArrayList<HashMap>) list.stream().sorted(
                new Comparator<HashMap>() {
                    @Override
                    public int compare(HashMap o1, HashMap o2) {
                        //Integer v2 = (Integer) o2.get("key");
                       // Integer v1 = (Integer) o1.get("key");

                        Date v2 = (Date) o2.get("date");
                        Date v1 = (Date) o1.get("date");
                        return v2.compareTo(v1);
                    }
                }
        ).collect(Collectors.toList());

        newList.stream().forEach( e -> {
                    System.out.println(e.get("key"));
                }
        );
    }
}
