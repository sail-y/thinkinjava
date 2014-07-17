/**********************************************************************
 * <p>文件名：ArrayNew.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 22:21
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package ch4;

//: ArrayNew.java
// Creating arrays with new.
import java.util.*;
public class ArrayNew {
    static Random rand = new Random();
    static int pRand(int mod) {
        return Math.abs(rand.nextInt()) % mod + 1;
    }
    public static void main(String[] args) {
        int[] a;
        a = new int[pRand(20)];
        prt("length of a = " + a.length);
        for(int i = 0; i < a.length; i++)
            prt("a[" + i + "] = " + a[i]);
    }
    static void prt(String s) {
        System.out.println(s);
    }
} ///: