/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/9/30 上午11:52.
 * <p/>
 */
public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MICROSECONDS.sleep(100);
            fl.release();
            System.out.println("Released Lock");
        }

        fos.close();
    }
}
