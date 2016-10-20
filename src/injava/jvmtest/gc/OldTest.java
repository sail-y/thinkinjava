/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.jvmtest.gc;

/**
 * Created by YangFan on 2016/10/19 上午10:10.
 * <p/>
 * 虚拟机参数为“-XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728”
 * 最后那个参数表示大于这个设置值的对象直接在老年代中分配，这样做的目的是为了避免在Eden区和两个Survivor区之间发生大量的内存复制。
 * PretenureSizeThreshold参数只对Serial和ParNew两款收集器有效
 * 在JVM服务器模式（Server）下默认垃圾收集器是并行垃圾收集器，所以再加个参数指定收集器-XX:+UseParNewGC
 */
public class OldTest {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}

/*
Heap
 par new generation   total 9216K, used 1679K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K,  20% used [0x00000007bec00000, 0x00000007beda3e58, 0x00000007bf400000)
  from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
  to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
   the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00010, 0x00000007bfa00200, 0x00000007c0000000)
 Metaspace       used 2999K, capacity 4494K, committed 4864K, reserved 1056768K
  class space    used 326K, capacity 386K, committed 512K, reserved 1048576K
 */
