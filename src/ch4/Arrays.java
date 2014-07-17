/**********************************************************************
 * <p>文件名：Arrays.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 22:19
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package ch4;
//: Arrays.java
// Arrays of primitives.
public class Arrays {
    public static void main(String[] args) {
        int[] a1 = { 1, 2, 3, 4, 5 };
        int[ ] a2;
        a2 = a1;
        for(int i = 0; i < a2.length; i++)
            a2[i]++;
        for(int i = 0; i < a1.length; i++)
            prt("a1[" + i + "] = " + a1[i]);
    }
    static void prt(String s) {
        System.out.println(s);
    }
} ///: