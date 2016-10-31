/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.jvm.gc;

/**
 * Created by YangFan on 2016/10/18 下午4:06.
 * <p/>
 * 引用计数法
 * 这个算法的实现是，给对象中添加一个引用计数器，每当一个地方引用这个对象时，计数器值+1；当引用失效时，计数器值-1。
 * 任何时刻计数值为0的对象就是不可能再被使用的。这种算法使用场景很多，但是，Java中却没有使用这种算法，因为这种算法很难解决对象之间相互引用的情况。
 * OC就是用的这种方法。
 * <p>
 * 虚拟机参数：-verbose:gc
 */
public class ReferenceCountingGC {

    private Object instance = null;
    private static final int _1MB = 1024 * 1024;

    // 这个成员属性唯一的作用就是占用一点内存
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }

    // [GC (System.gc())  7440K->632K(125952K), 0.0025277 secs]
    // [Full GC (System.gc())  632K->519K(125952K), 0.0053464 secs]
    // 看到，两个对象相互引用着，但是虚拟机还是把这两个对象回收掉了，这也说明虚拟机并不是通过引用计数法来判定对象是否存活的。
}
