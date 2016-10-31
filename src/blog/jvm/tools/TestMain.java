/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.jvm.tools;

/**
 * Created by YangFan on 2016/10/19 下午12:42.
 * <p/>
 * -XX:+TraceClassLoading
 */

class Foo {
    static {
        System.out.println("haha");
    }
}

public class TestMain {
    public static void main(String[] args) {
        System.out.println(Foo.class.getName());

    }
}
