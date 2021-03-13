package shop.user.com.config;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ym.y
 * @description
 * @package shop.user.com.config
 * @updateUser
 * @date 21:49 2021/2/22
 */
public class Test {
    public static void main(String[] args) {
        //文字替换（全部）
        Pattern pattern = Pattern.compile("正则表达式");
        String str ="";
        StringBuffer st = new StringBuffer("qq");
        st.append("d");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
//替换所有符合正则的数据
        System.out.println(matcher.replaceAll("Java"));
        String str2 = "Hollis";

        String str3 = new String("Hollis");
        System.out.println("==="+(str2==str3));
    }
}
