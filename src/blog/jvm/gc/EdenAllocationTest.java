/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.jvm.gc;

/**
 * Created by YangFan on 2016/10/19 上午9:58.
 * <p/>
 * 虚拟机参数为“-verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * 即10M新生代，10M老年代，10M新生代中8M的Eden区，两个Survivor区各1M。
 */
public class EdenAllocationTest {
    private static final int _1MB = 1024 * 1024;

    /**
     * Server模式下，前面都一样，但是在GC的时候有一点区别。在GC前还会进行一次判断，如果要分配的内存>=Eden区大小的一半，那么会直接把要分配的内存放入老年代中。
     * 要分配4M，Eden区8M，刚好一半，而且老年代10M，够分配，所以4M就直接进入老年代去了。为了验证一下结论，我们把3个2M之后分配的4M改为3M看一下
     *
     * 3M小于Eden的一半，通过分配担保机制转入老年代中，将3M放入新生代
     * @param args
     */
    public static void main(String[] args)
    {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB];
    }
}
/*
Heap
 PSYoungGen      total 9216K, used 7823K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 8192K, 95% used [0x00000007bf600000,0x00000007bfda3f28,0x00000007bfe00000)
  from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
  to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 ParOldGen       total 10240K, used 4096K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  object space 10240K, 40% used [0x00000007bec00000,0x00000007bf000010,0x00000007bf600000)
 Metaspace       used 3027K, capacity 4494K, committed 4864K, reserved 1056768K
  class space    used 331K, capacity 386K, committed 512K, reserved 1048576K
 */