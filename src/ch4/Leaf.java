/**********************************************************************
 * <p>文件名：Leaf.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 20:42
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package ch4;

/**
 * ***************************************************************************
 *
 * @Package: [ch4]
 * @ClassName: [Leaf]
 * @Description: [一句话描述该类的功能]
 * @Author: [yangfan]
 * @CreateDate: [2014/7/14 20:42]
 * @UpdateUser: [yangfan(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014/7/14 20:42，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public class Leaf {
    private int i = 0 ;
    Leaf increment(){
        i++;
        return this;
    }

    void print(){
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
}
