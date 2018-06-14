package com.daxin.junit.hellioworld;


import org.hamcrest.Matchers;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsSame;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;



/**
 * Created by liuguangxin on 2018/6/9.
 * <p>
 * 继承待测试的类
 */
class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return com.google.common.base.Objects.equal(name, user.name);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(name);
    }
}

/**
 * Error是程序错误，例如空指针等。
 * failure是成测试失败，比如期望结果是1，而实际结果是2
 *
 *
 */
public class TTest extends T {


    @Test
    public void testEquals() {
        //第一个参数是错误信息，第二个罗尔条件值
        assertTrue("not daxin", "ll" == "111");
    }

    /**
     *
     */
    @Test
    public void testAssertThat1() {

        User u = new User();
        u.setName("daxin");
        User dest = new User();
        dest.setName("daxin");
        //Matcher：意如其名，Matcher就是一个匹配器，用作匹配测试结果与预期结果
        // 第一个参数是计算的值，第二个是匹配的表达式
        assertThat(u, Is.is(dest));

        //上面的写法等效如下写法
        assert u.equals(dest);
    }


    @Test
    public void testAssertThat2() {
        User u1 = new User();
        u1.setName("daxin");

        User u2 = new User();
        u2.setName("daxin");

        //判断是都是一个实力（意如其名）,翻阅源码 sameInstanceh与theInstance接口是相同的功能
        Assert.assertThat(u1, IsSame.sameInstance(u1));
        //结果是false，原始是u1与u2不是一个实例
        Assert.assertThat(u1, IsSame.theInstance(u2));


    }



    @Test
    public void testAssertThat3(){
        // Matchers是一个工具类，可以使用该工具类快速生成Mathcer
        // Allof是一个逻辑与遇见，要满足Allof中的所有条件
        assertThat(6, AllOf.allOf(Matchers.greaterThan(1),Matchers.lessThan(10)));
    }


    @Test
    public void testAssertThat4(){
        // Matchers是一个工具类，可以使用该工具类快速生成Mathcer
        // Allof是一个逻辑与遇见，要满足Allof中的所有条件
        assertThat(12, AnyOf.anyOf(Matchers.greaterThan(1),Matchers.lessThan(10)));
        assertThat(-1, AnyOf.anyOf(Matchers.greaterThan(1),Matchers.lessThan(10)));
    }


    @Test
    public void testAdd() throws Exception {

        if (add(2, 3) != 5)
            //fail方法来至于Assert方法
            fail("this is a method for junit to alert a error msg.");

        assertEquals(4, 4);

        //底层根据对象的equlas方法进行比较
        assertEquals(new Object(), new Object());


    }


    /**
     * 进行一些必要的资源初始化工作。<br/>
     * eg:jdbc connection
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        System.out.println("开始进行测试,初始化测试资源.");
    }

    /**
     * 释放测试使用的资源
     * eg:close jdbc connection
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试,释放资源.");

    }


}