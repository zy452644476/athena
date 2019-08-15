package com.athena.java.reflection;

import lombok.Data;

/**
 * Created by yaser.zhang on 2019/8/13.
 */
@Data
public class XYZ {
    public static String name = "luoxn28";
    private String str;

    static {
        System.out.println("xyz静态块");
    }

    public XYZ(String str) {
        str = str;
        System.out.println("xyz构造了");
    }
}
