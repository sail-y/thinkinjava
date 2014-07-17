/**********************************************************************
 * <p>文件名：Fo.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/16 15:45
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c05.foreign.sub;

import c05.foreign.Foo;

/**
 * ***************************************************************************
 *
 * @Package: [c05.foreign.sub]
 * @ClassName: [Fo]
 * @Description: [一句话描述该类的功能]
 * @Author: [yangfan]
 * @CreateDate: [2014/7/16 15:45]
 * @UpdateUser: [yangfan(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014/7/16 15:45，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
class Fo extends Foo {
    Fo(){
        this.str = "1";
    }

    public static void main(String[] args) {
        Fo f = new Fo();
        System.out.println(f.str);
    }
}
