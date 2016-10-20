/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangFan on 2016/10/18 下午3:52.
 * <p/>
 * 方法区和运行时常量池溢出
 * 运行时常量池也是方法区的一部分，所以这两个区域一起看就可以了。
 * 这个区域的OutOfMemoryError可以利用String.intern()方法来产生。
 * 这是一个Native方法，意思是如果常量池中有一个String对象的字符串就返回池中的这个字符串的String对象；
 * 否则，将此String对象包含的字符串添加到常量池中去，并且返回此String对象的引用。测试代码如下
 *
 * 测试内容：常量池溢出（这个例子也可以说明运行时常量池为方法区的一部分）
 * 虚拟机参数-XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 对于HotSpot而言，方法区=永久代，这里看到OutOfMemoryError的区域是“PermGen space”，即永久代，那其实也就是方法区溢出了
 *
 * PS:这个例子在JDK8中以及无法复现了，JAVA8移除了永久代（Permanent Generation ）
 * 替换成了元空间（Metaspace）内存分配模型
 * 设置虚拟机参数-XX:MaxMetaspaceSize=1m，可出现OutOfMemoryError: Metaspace 溢出
 *
 */
public class ConstantPoolOverflowTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
