package com.namo.map;

import org.junit.Test;

import java.util.*;

/**
 * @author namo
 * @date 2022/6/21-23:48
 */
public class MapUseExample {


    /**
     * 遍历Map
     */
    @Test
    public void traverseMap() {
        Map<Character, Integer> map = new TreeMap<>();
        map.put('a', 2);
        map.put('b', 4);
        map.put('c', 3);
        map.put('d', 3);

        //第一种：普遍使用，二次取值，通过Map.keySet遍历key和value
        System.out.println("通过Map.keySet遍历key和value：");
        for (Character key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

        //第二种，通过Map.entrySet使用iterator遍历key和value
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时，通过Map.entrySet遍历key和value
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种,通过Map.values()遍历所有的value，但不能遍历key
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (Integer v : map.values()) {
            System.out.println("value= " + v);
        }


    }


    /**
     * Map按照Key排序
     */
    @Test
    public void sortByKey() {
        Map<Character, Integer> map = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                //升序
                //return o1.compareTo(o2);

                //降序
                return o2.compareTo(o1);
            }
        });
        map.put('a', 2);
        map.put('b', 4);
        map.put('c', 3);
        map.put('d', 3);

        for (Character key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

    }


    /**
     * Map按照Value排序
     */
    @Test
    public void sortByValue() {
        Map<Character, Integer> map = new TreeMap<>();
        map.put('a', 2);
        map.put('b', 4);
        map.put('c', 3);
        map.put('d', 3);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            // 默认的是从小到大排序，
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // 从大到小排序
                return (o2.getValue() - o1.getValue());
                // 从小到大排序
                // return (o1.getValue() - o2.getValue());
            }
        });
        for (Map.Entry<Character, Integer> t : list) {
            System.out.println(t.getKey() + ":" + t.getValue());
        }
    }


}
