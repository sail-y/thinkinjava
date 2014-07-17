/**********************************************************************
 * <p>文件名：VarArgs.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 22:27
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package ch4;
//: VarArgs.java
// Using the Java 1.1 array syntax to create
// variable argume nt lists
class A { int i; }

public class VarArgs {
    static void f(Object[] x) {
        for(int i = 0; i < x.length; i++)
            System.out.println(x[i]);
    }
    public static void main(String[] args) {
        f(new Object[] {
                new Integer(47), new VarArgs(),
                new Float(3.14), new Double(11.11) });
        f(new Object[] {"one", "two", "three" });
        f(new Object[] {new A(), new A(), new A()});
    }
} ///: