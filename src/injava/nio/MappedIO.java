/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by YangFan on 2016/9/30 上午11:00.
 * <p/>
 */
public class MappedIO {
    private static int numOfInts = 400000;
    private static int numOfUbuffInts = 200000;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + ": ");
            try {

                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        protected abstract void test() throws IOException;
    }

    private static Tester[] tests = {
            new Tester("Stream Write") {
                @Override
                protected void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp.tmp"))));
                    for (int i = 0; i < numOfInts; i++) {
                        dos.writeInt(i);
                    }

                    dos.close();
                }
            },

            new Tester("Mapped Write") {
                @Override
                protected void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    for (int n = 0; n < numOfInts; n++) {
                        ib.put(n);
                    }
                    fc.close();
                }
            },
            new Tester("Stream Read") {
                @Override
                protected void test() throws IOException {
                    DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("temp.tmp"))));
                    for (int i = 0; i < numOfInts; i++) {
                        dis.readInt();
                    }

                    dis.close();
                }
            },
            new Tester("Mapped Read") {
                @Override
                protected void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    for (int i = 0; i < numOfInts; i++) {
                        ib.get();
                    }
                    fc.close();
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                protected void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(new File("temp.tmp"), "rw");
                    raf.writeInt(1);
                    for (int i = 0; i < numOfUbuffInts; i++) {
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Mapped Read/Write") {
                @Override
                protected void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    ib.put(0);
                    for (int i = 1; i < numOfUbuffInts; i++) {
                        ib.put(ib.get(i -1));
                    }

                    fc.close();
                }
            }




    };


    public static void main(String[] args) {
        for (Tester test : tests) {
            test.runTest();
        }
    }
}
