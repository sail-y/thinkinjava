/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.io;

import java.io.*;

/**
 * Created by YangFan on 2016/10/28 上午9:21.
 * <p/>
 */
public class StreamTest {
    public static void main(String[] args) throws IOException {
        // FileOutputStream的创建不依赖于文件是否存在，写将会覆盖而不是追加
        File file = new File("test.txt");
        OutputStream out = new FileOutputStream(file);
        out.write("测试".getBytes());

        InputStream in = new FileInputStream(file);
        byte[] buff = new byte[(int) file.length()];
        int read = in.read(buff);
        System.out.println(read);
        System.out.println(new String(buff));
    }
}
