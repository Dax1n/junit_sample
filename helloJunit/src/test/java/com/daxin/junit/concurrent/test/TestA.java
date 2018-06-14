package com.daxin.junit.concurrent.test;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by liuguangxin on 2018/6/9.
 */
public class TestA {

    @Test
    public void testA() {
        ConcurrentTest.printThreadName();
        assertThat(3, is(1));
    }

    @Test
    public void testB() {
        ConcurrentTest.printThreadName();
        assertThat(3, not(1));
    }

}
