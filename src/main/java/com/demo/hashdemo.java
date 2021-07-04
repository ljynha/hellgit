package com.demo;

import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class hashdemo {
    public static void main(String[] args) {
          HashMap
        HashMap<String,String> hashMap=new HashMap();
        hashMap.put("asd","zzz");
        hashMap.put("asd1","zxx");
        for (String key:hashMap.keySet()){
            hashMap.remove(key);
        }

    }
    public void Concurrenthashmap(){
        ConcurrentHashMap <Integer,String> concurrentHashMap=new ConcurrentHashMap<>();
    }
}
