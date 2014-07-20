/**********************************************************************
 * <p>文件名：Flower.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 20:50
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c04;
//: Flower.java
// Calling constructors with "this"
public class Flower {
    private int petalCount = 0;
    private String s = new String("null");
    Flower(int petals) {
        petalCount = petals;
        System.out.println(
                "Constructor w/ int arg only, petalCoun t= "
                        + petalCount);
    }
    Flower(String ss) {
        System.out.println(
                "Constructor w/ String arg only, s=" + ss);
        s = ss;
    }
    Flower(String s, int petals) {
        this(petals);
//! this(s); // Can't call two!
        this.s = s; // Another use of "this"
        System.out.println("String & int args");
    }
    Flower() {
        this("hi", 47);
        System.out.println(
                "default constructor (no args)");
    }
    void print() {
//! this(11); // Not inside non-constructor!
        System.out.println(
                "petalCount = " + petalCount + " s = "+ s);
    }
    public static void main(String[] args) {
        Flower x = new Flower();
        x.print();
    }
} ///: