package com.daxin.junit.concurrent.test;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;


public class TestB {
    @Test
    public void testC() {
        ConcurrentTest.printThreadName();
        assertThat(3, greaterThan(1));
    }
    @Test
    public void testD() {
        ConcurrentTest.printThreadName();
        assertThat(3, lessThan(1));
    }
}
