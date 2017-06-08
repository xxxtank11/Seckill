package com.ws.dao;

/**
 * Created by Administrator on 2017/6/1.
 */
public class Stringtest {
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        //intern()方法，在JavaDoc文档中，这样描述了intern()方法：返回字符串对象的规范化表示形式。
        // 怎么理解这句话？实际上过程是这样进行的：该方法现在String池中查找是否存在一个对象，存在了就返回String池中对象的引用。
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
        System.out.println(s1.equals(s2));
        // hashCode()方法是返回字符串内容的哈希码，既然内容相同，哈希码必然相同，那他们就相等了
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println("------------");
        String s="abc";
        String ss=s;
        System.out.println(ss=="abc");
        s=s+"hello";
        System.out.println(ss=="abc");
        System.out.println(s=="abc");

    }
}
