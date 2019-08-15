package com.athena.guava.collection;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by yaser.zhang on 2019/8/13.
 */
public class TableTest {
    // 二维map
    public static void main(String[] args) {
        // 通常情况下，我们只能用这种丑陋的Map<FirstName, Map<LastName, Person>>来实现

//        HashBasedTable：基于HashMap<R, HashMap<C, V>>的实现。
//        TreeBasedTable：基于TreeMap<R, TreeMap<C, V>>的实现。
//        ImmutableTable：基于ImmutableMap<R, ImmutableMap<C, V>>的实现。

        // 行是String，列是数字
        Table<String, Integer, String> aTable = HashBasedTable.create();

        for (char a = 'A'; a <= 'C'; ++a) {
            for (Integer b = 1; b <= 3; ++b) {
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
            }
        }

        // 获取列map
        System.out.println(aTable.column(2));
        // 获取行map
        System.out.println(aTable.row("B"));
        // 获取值
        System.out.println(aTable.get("B", 2));

        System.out.println(aTable.contains("D", 1));
        System.out.println(aTable.containsColumn(3));
        System.out.println(aTable.containsRow("C"));
        System.out.println(aTable.columnMap());
        System.out.println(aTable.rowMap());

        System.out.println(aTable.remove("B", 3));
    }
}
