package com.lambda;


import org.junit.Test;

import java.util.Comparator;

/**
 * @author ym.y
 * @description
 * @package com.lambda
 * @updateUser
 * @date 18:40 2021/3/11
 */
public class TestMode {
    public static void main(String[] args) {
        System.out.println(test());
    }

    @Test
    public  static int test(){
        Comparator<Integer> com  = (x,y)-> Integer.compare(x,y);
        return  com.compare(6,6);
    }
}
