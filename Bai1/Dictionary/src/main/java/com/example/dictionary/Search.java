package com.example.dictionary;

import java.util.TreeMap;

public class Search {
    public static TreeMap<String,String> treeMap=new TreeMap<>();

    static {
        treeMap.put("hello","xin chào");
        treeMap.put("apple","quả táo");
    }

    public String search(String search){
        String result=treeMap.get(search);
        return  result;
    }
}
