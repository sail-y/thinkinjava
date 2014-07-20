/**********************************************************************
 * <p>文件名：Demotion.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 20:35
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c04;

/**
 * ***************************************************************************
 *
 * @Package: [c04]
 * @ClassName: [Demotion]
 * @Description: [一句话描述该类的功能]
 * @Author: [yangfan]
 * @CreateDate: [2014/7/14 20:35]
 * @UpdateUser: [yangfan(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014/7/14 20:35，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public class Demotion {
    static void prt(String s) {
        System.out.println(s);
    }
    void f1(char x) { prt("f1(char)"); }
    void f1(byte x) { prt("f1(byte)"); }
    void f1(short x) { prt("f1(short)"); }
    void f1(int x) { prt("f1(int)"); }
    void f1(long x) { prt("f1(long)"); }
    void f1(float x) { prt("f1(float)"); }
    void f1(double x) { prt("f1(double)"); }
    void f2(char x) { prt("f2(char)"); }
    void f2(byte x) { prt("f2(byte)"); }
    void f2(short x) { prt("f2(short)"); }
    void f2(int x) { prt("f2(int)"); }
    void f2(long x) { prt("f2(long)"); }
    void f2(float x) { prt("f2(float)"); }
    void f3(char x) { prt("f3(char)"); }
    void f3(byte x) { prt("f3(byte)"); }
    void f3(short x) { prt("f3(short)"); }
    void f3(int x) { prt("f3( int)"); }
    void f3(long x) { prt("f3(long)"); }
    void f4(char x) { prt("f4(char)"); }
    void f4(byte x) { prt("f4(byte)"); }
    void f4(short x) { prt("f4(short)"); }
    void f4(int x) { prt("f4(int)"); }
    void f5(char x) { prt("f5(char)"); }
    void f5(byte x) { prt("f5(byte)"); }
    void f5(short x) { prt("f5(short)"); }
    void f6(char x) { prt("f6(char)"); }
    void f6(byte x) { prt("f6(byte)"); }
    void f7(char x) { prt("f7(char)"); }
    void testDouble() {
        double x = 0;
        prt("double argument:");
        f1(x);f2((float)x);f3((long)x);f4((int)x);
        f5((short)x);f6((byte)x);f7((char)x);
    }
    public static void main(String[] args) {
        Demotion p = new Demotion();
        p.testDouble();
    }
} ///:
