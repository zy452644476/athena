package com.athena.guava.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yaser.zhang on 2019/8/13.
 */
public class MultimapTest {
    // 一键多值map
    public static void main(String[] args) {
        // 替代这种数据结构，这种数据结构在插入之前需要判空，麻烦至极
        // Map<String, List<String>> StudentScoreMap = new HashMap<String, List<String>>();
        Multimap<String,StudentScore> scoreMultimap =  ArrayListMultimap.create();

        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("peida",studentScore);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
    }

    @Data
    static class StudentScore{
        public int CourseId;
        public int score;
    }
}
