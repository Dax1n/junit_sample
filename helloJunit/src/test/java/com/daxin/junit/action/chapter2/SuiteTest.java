package com.daxin.junit.action.chapter2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by liuguangxin on 2018/6/9.
 * <p>
 * 将AddTest与ParamTest测试用例放到一个测试集中，然后直接run SuiteTest即可完成测试
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {ParamTest.class, AddTest.class})
public class SuiteTest {


}
