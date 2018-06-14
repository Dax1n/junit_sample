package com.daxin.junit.action.chapter2;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liuguangxin on 2018/6/9.
 */
public class AddTest {

    @Test
    public void testAdd() {
        Assert.assertThat(new Add().add(1, 2), Is.is(3));
    }
}
