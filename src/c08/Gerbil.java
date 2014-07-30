/**********************************************************************
 * <p>文件名：Gerbil.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/20 22:27
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c08;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************************************
 *
 * @Package: [c08]
 * @ClassName: [Gerbil]
 * @Description: [一句话描述该类的功能]
 * @Author: [yangfan]
 * @CreateDate: [2014/7/20 22:27]
 * @UpdateUser: [yangfan(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014/7/20 22:27，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public class Gerbil {
    int gerbiNumber;
    Gerbil(int gerbiNumber){
        this.gerbiNumber = gerbiNumber;
    }

    public void hop(){
        System.out.println("Gerbil: #"+gerbiNumber);
    }

    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<Gerbil>();
        gerbils.add(new Gerbil(1));
        gerbils.add(new Gerbil(2));
        gerbils.add(new Gerbil(3));
        gerbils.add(new Gerbil(4));

        for (Gerbil gerbil : gerbils) {
            gerbil.hop();
        }
    }

}
