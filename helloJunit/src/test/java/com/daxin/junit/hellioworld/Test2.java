package com.daxin.junit.hellioworld;

import org.junit.*;

/**
 * Created by liuguangxin on 2018/6/9.
 * <br/>
 * <p>
 * Junit Test的注解使用
 */
public class Test2 {




    @Test(expected = java.lang.ArithmeticException.class)
    public void testTestAnnotation1() throws Exception {
        printThreadName();
        //测试期望得到一个ArithmeticException，其中Test注解中的expected字段用作指定期望得到的异常
        int a = 1 / 0;

    }


    // 希望在20秒之间完成测试
    @Test(timeout = 20)
    public void testTestAnnotation2() throws Exception {
        printThreadName();
        //线程睡眠10毫秒
        Thread.sleep(10);
    }

    // 希望在20秒之间完成测试，但是实际睡眠100毫秒，因此执行失败
    @Test(timeout = 20)
    public void testTestAnnotation3() throws Exception {
        printThreadName();
        //线程睡眠100毫秒
        Thread.sleep(100);
    }


    // 希望在20秒之间完成测试，
    @Test(expected = ArithmeticException.class, timeout = 20)
    public void testTestAnnotation4() throws Exception {
        printThreadName();
        int a = 1 / 0;
        //线程睡眠100毫秒
        Thread.sleep(100);//代码没有得到执行的机会，因为异常打断了代码的继续执行，因此可以通过测试
    }


    @Test
    // @Ignore
    public void testTestAnnotation5() throws Exception {

        System.out.println("这个是一个没有添加Ignore注解的测试方法.");

    }

    @Test
    @Ignore //当测试过程中由于一部分模块还没有开发好或者某一些条件暂时无法测试的话，那么就可以使用ignore注解进行暂时忽略该测试的方法
    public void testTestAnnotation6() throws Exception {

        System.out.println("这个是一个添加Ignore注解的测试方法.");

    }

    @Before
    public void beforeMethod() {
        System.out.println("this is a before method.");
    }

    @After
    public void afterMethod() {
        System.out.println("this is a after method.");
    }


    //在@before之前执行，必须是一个static方法，因为字节码的加载就是一个静态加载过程
    @BeforeClass
    public static  void beforeClassMethod() {
        System.out.println("this is a before class method.");
    }


    //在@after之后执行，必须是一个static方法，因为字节码的加载就是一个静态加载过程
    @AfterClass
    public static void afterClassMethod() {
        System.out.println("this is a after class method.");
    }




    public void printThreadName() {
        System.out.println("current thread name  = " + Thread.currentThread());
    }
}
