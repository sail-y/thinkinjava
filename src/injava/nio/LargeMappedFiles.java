/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by YangFan on 2016/9/30 上午10:33.
 * <p/>
 */
public class LargeMappedFiles {
    private static int length = 0x8FFFFFF; //128M

    public static void main(String[] args) throws IOException {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }

        System.out.println("Finished writing");

        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.println((char) out.get(i));
        }

    }

}
