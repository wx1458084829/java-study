package com.namo.override;

import org.junit.Test;

/**
 * @author namo
 * @date 2022/8/9-19:29
 */
public class Child extends Parent{

    @Override
    public void pFn(){
        System.out.println("这是子方法");
    }


}
