package com.namo.myannotation;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试自定义注解
 * @author namo
 * @date 2022/8/10-1:20
 */
public class AnnotationTest {


    @Override
    @MyAnnotation(title = "toStringMethod", age = 10)
    public String toString() {
        return "Override toString method";
    }

    @Deprecated
    @MyAnnotation(title = "old static method", age = 20)
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyAnnotation(title = "test method", age = 30)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

    @Test
    public void test1(){

        try {
            // 获取所有methods
            Method[] methods = AnnotationTest.class.getClassLoader()
                    .loadClass(("com.namo.myannotation.AnnotationTest"))
                    .getMethods();

            // 遍历
            for (Method method : methods) {
                // 方法上是否有MyMethodAnnotation注解
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    try {
                        // 获取并遍历方法上的所有注解
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '"
                                    + method + "' : " + anno);
                        }

                        // 获取MyMethodAnnotation对象信息
                        MyAnnotation methodAnno = method
                                .getAnnotation(MyAnnotation.class);

                        System.out.println(methodAnno.title()+"   "+methodAnno.age());

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
