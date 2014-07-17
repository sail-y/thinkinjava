/**********************************************************************
 * <p>文件名：ExplicitStatic.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 22:15
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package ch4;

//: ExplicitStatic.java
// Explicit static initialization
// with the "static" clause.
class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }
    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}
class Cups {
    static Cup c1;
    static Cup c2;
    static {
        c1 = new Cup(1);
        c2 = new Cup(2);
    }
    Cups() {
        System.out.println("Cups()");
    }
}
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.c1.f(99); // (1)
    }
    static Cups x = new Cups(); // (2)
    static Cups y = new Cups(); // (2)
} ///: