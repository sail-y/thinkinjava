/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangFan on 2016/10/18 下午3:25.
 * <p/>
 * 测试堆溢出
 * 虚拟机参数：-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * 将-Xmx和-Xms设置为一样可以避免堆自动扩展
 *
 * 这种异常很常见，也很好发现，因为都提示了“Java heap space”了，定位问题的话，根据异常堆栈分析就好了，行号都有指示。
 * 解决方案的话，可以调大堆的大小或者从代码上检视是否存在某些对象生命周期过长、持有状态时间过长的情况，长时间少程序运行期间的内存消耗。
 */
public class HeapOverflowTest {

    public static void main(String[] args) {
        List<HeapOverflowTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOverflowTest());
        }
    }
}
