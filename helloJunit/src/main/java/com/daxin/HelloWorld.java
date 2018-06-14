package com.daxin;

/**
 * Created by liuguangxin on 2018/6/14.
 */
public class HelloWorld {

    public static void main(String[] args) {

        Integer time = Integer.valueOf(args[0]);

        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
