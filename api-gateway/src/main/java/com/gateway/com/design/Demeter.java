package com.gateway.com.design;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ym.y
 * @description 迪米特法则：一类对自己依赖的类知道的越少越好
 * @package com.gateway.com.design
 * @updateUser
 * @date 18:10 2021/3/9
 */
public class Demeter {
    public static void main(String[] args) {
      Integer a =128;
      Integer b =128;
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("","");
    }
}
