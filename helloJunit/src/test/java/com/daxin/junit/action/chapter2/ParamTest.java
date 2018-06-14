package com.daxin.junit.action.chapter2;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * 运行参数化测试
 */
//步骤1：使用Parameterized注解
@RunWith(Parameterized.class)
public class ParamTest {

    private Integer left;
    private Integer right;
    private Integer sum;

    //步骤2：构造器，确认集合中的数组数据的顺序
    public ParamTest(int left, int right, int sum) {
        this.left = left;
        this.right = right;
        this.sum = sum;
    }

    // 步骤3：初始化参数，该方法必须使用Parameters注解，并且需要时静态的， 原因是在实例化对象之前需要将参数准备好
    @Parameterized.Parameters
    public static Collection<Integer[]> getParams() {
        return Arrays.asList(new Integer[][]{{1, 2, 3}, {4, 5, 91}, {6, 4, 10}});
    }


    // 步骤4：进行测试
    @Test
    public void sum() {
        Add add = new Add();
        Assert.assertThat(sum, Matchers.is(add.add(left, right)));


    }

}


class Main {
    public static void main(String[] args) {
        //JUintCore是一个测试用例的执行窗口
        Result rt = JUnitCore.runClasses(ParamTest.class);
        System.out.println(rt.getFailures());

    }
}
