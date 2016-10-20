/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.jvmtest.gc;

/**
 * Created by YangFan on 2016/10/19 上午9:58.
 * <p/>
 * 虚拟机参数为“-verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * 即10M新生代，10M老年代，10M新生代中8M的Eden区，两个Survivor区各1M。
 */
public class EdenAllocationTest2 {
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
        byte[] allocation4 = new byte[3 * _1MB];
    }
}
/*
[GC (Allocation Failure) [PSYoungGen: 7659K->656K(9216K)] 7659K->6808K(19456K), 0.0063099 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
[Full GC (Ergonomics) [PSYoungGen: 656K->0K(9216K)] [ParOldGen: 6152K->6673K(10240K)] 6808K->6673K(19456K), [Metaspace: 3070K->3070K(1056768K)], 0.0074793 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
Heap
 PSYoungGen      total 9216K, used 3208K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 8192K, 39% used [0x00000007bf600000,0x00000007bf9223b8,0x00000007bfe00000)
  from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
  to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 ParOldGen       total 10240K, used 6673K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  object space 10240K, 65% used [0x00000007bec00000,0x00000007bf284708,0x00000007bf600000)
 Metaspace       used 3099K, capacity 4494K, committed 4864K, reserved 1056768K
  class space    used 338K, capacity 386K, committed 512K, reserved 1048576K
 */