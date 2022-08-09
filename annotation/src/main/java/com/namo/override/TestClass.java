package com.namo.override;

import org.junit.Test;

/**
 * @author namo
 * @date 2022/8/9-19:30
 */
public class TestClass {
    @Test
    public void test1(){
        Child child = new Child();
        child.pFn();
    }
}
