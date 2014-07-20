/**********************************************************************
 * <p>文件名：Overloading.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 20:10
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
 * @ClassName: [Overloading]
 * @Description: [一句话描述该类的功能]
 * @Author: [yangfan]
 * @CreateDate: [2014/7/14 20:10]
 * @UpdateUser: [yangfan(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014/7/14 20:10，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
class Tree {
    int height;

    Tree() {
        prt("Planting a seedling");
        height = 0;
    }

    Tree(int i) {
        prt("Creating new Tree that is "
                + i + " feet tall");
        height = i;
    }

    void info() {
        prt("Tree is " + height
                + " feet tall");
    }

    void info(String s) {
        prt(s + ": Tree is "
                + height + " feet tall");
    }

    static void prt(String s) {
        System.out.println(s);
    }
}

public class Overloading {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }
// Overloadedconstructor:
        new Tree();
    }
} ///:

