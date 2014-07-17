/**********************************************************************
 * <p>文件名：InitialValues.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 21:32
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package ch4;
//: InitialValues.java
// Shows default initial values
class Measurement {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    void print() {
        System.out.println(
                "Data type Inital value\n" +
                        "boolean " + t + " \n" +
                        "char " + c + " \n" +
                        "byte " + b + " \n" +
                        "short " + s + "\n" +
                        "int " + i + " \n" +
                        "long " + l + " \n" +
                        "float " + f + " \n" +
                        "double " + d);
    }
}
public class InitialValues {
    public static void main(String[] args) {
        Measurement d = new Measurement();
        d.print();
/* In this case you could also say:
new Measurement().print();
*/
    }
} ///