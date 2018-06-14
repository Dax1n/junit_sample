package com.daxin.junit.hellioworld;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by liuguangxin on 2018/6/13.
 */
public class AtomSQL {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("/Users/liuguangxin/Desktop/原子SQL.sql"));
        String line = br.readLine();

        while (line != null) {
            String[] strs = line.split(";");
            if (!line.startsWith("#") && strs.length > 4) {
                String sqlName = strs[0];
                String sqlValue = strs[4];
                int selectIndex = sqlValue.indexOf("select");

                System.out.println(sqlName + "  =>  " + sqlValue.substring(selectIndex));
            }
            line = br.readLine();
        }


    }


}
