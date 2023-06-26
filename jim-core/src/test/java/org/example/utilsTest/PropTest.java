package org.example.utilsTest;

import org.junit.Test;

public class PropTest {

    //获得当前类的类加载器
    public ClassLoader getClassLoader(){
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader!=null? contextClassLoader:this.getClass().getClassLoader();
    }

    @Test
    public void test(){
        ClassLoader classLoader = getClassLoader();
        System.out.println(classLoader);

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getName());
    }

}
