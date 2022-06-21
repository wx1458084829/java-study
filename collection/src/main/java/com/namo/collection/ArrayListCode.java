package com.namo.collection;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author namo
 * @data 2021/12/15-11:17 PM
 * @description ArrayList源码解析
 */
public class ArrayListCode {
    /**
     * 扩容机制
     */
    @Test
    public void baseUseArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        for (int i = 11; i < 15; i++) {
            arrayList.add(i);
        }
        arrayList.add(100);
        arrayList.add(null);

        //初始化大小
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(8);

        arrayList2.ensureCapacity(10);

        for (int i = 0; i < 8; i++) {
            arrayList2.add(i);
        }
        for (int i = 9; i < 15; i++) {
            arrayList2.add(i);
        }
        arrayList2.add(100);
        arrayList2.add(200);
        arrayList2.add(null);
    }
}
