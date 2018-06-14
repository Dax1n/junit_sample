package com.daxin.junit.concurrent.test;


import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class ConcurrentTest {

    /**
     * 该方法在真是测试环境下没有实际用途，只是为了验证是否是并发测试
     */
    public static void printThreadName() {
        System.out.println("线程名字 = " + Thread.currentThread().getName());
    }


    public static void main(String[] args) {

        Class[] cls = {TestA.class, TestB.class};
        //JUnitCore是一个执行测试用例的门面（facade设计模式）
        //ParallelComputer：两个参数分别表示类和方法都并行执行
        Result rt = JUnitCore.runClasses(new ParallelComputer(true, true), cls);
        //打印执行结果
        System.out.println(rt.getRunCount() + "  " + rt.getRunTime());
        System.out.println("================华丽的分割线==================");
        rt.getFailures().forEach(System.out::println);
    }
}
