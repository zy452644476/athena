package com.athena.guava.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by yaser.zhang on 2019/8/13.
 */
public class BiMapDemo {
    // 反向map
    public static void main(String[] args) {
//        HashBiMap: key 集合与 value 集合都有 HashMap 实现
//        EnumBiMap: key 与 value 都必须是 enum 类型
//        ImmutableBiMap: 不可修改的 BiMap

        BiMap<String,String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一","Monday");
        weekNameMap.put("星期二","Tuesday");
        weekNameMap.put("星期三","Wednesday");
        weekNameMap.put("星期四","Thursday");
        weekNameMap.put("星期五","Friday");
        weekNameMap.put("星期六","Saturday");
        weekNameMap.put("星期日","Sunday");

        System.out.println("星期日的英文名是" + weekNameMap.get("星期日"));
        System.out.println("Sunday的中文是" + weekNameMap.inverse().get("Sunday"));
    }
}
