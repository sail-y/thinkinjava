/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by YangFan on 2016/9/30 下午3:04.
 * <p/>
 */
public class LockingMappedFiles {
    private static final int LENGTH = 0x8FFFFFF;
    private static FileChannel fc;

    public static void main(String[] args) throws Exception {
        fc = new RandomAccessFile("test.dat", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte) 'x');
        }
        new LockAndModify(out, 0, LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        public LockAndModify(MappedByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buff = mbb.slice();
            start();
        }

        @Override
        public void run() {
            try {
                FileLock fl = fc.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                while (buff.position() < buff.limit() - 1) {
                    buff.put((byte) (buff.get() + 1));
                }
                fl.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
