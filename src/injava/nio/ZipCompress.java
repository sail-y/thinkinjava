/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by YangFan on 2016/9/30 下午3:44.
 * <p/>
 */
public class ZipCompress {
    public static void main(String[] args) throws Exception {
        FileOutputStream f = new FileOutputStream("test.zip");
        // 校验
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out  = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");

        for (String arg : args) {
            System.out.println("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();

        // 检查校验码
        System.out.println("Checksum: " + csum.getChecksum().getValue());
        System.out.println("Reading file");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            System.out.println("Reading file: " + ze);
            int x;
            while ((x = bis.read()) != -1) {
                System.out.write(x);
            }
        }

        if (args.length == 1) {
            System.out.println("Checksum: " + csumi.getChecksum().getValue());
        }
        bis.close();

        ZipFile zf = new ZipFile("test.zip");
        Enumeration<? extends ZipEntry> e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = e.nextElement();
            System.out.println("File: " + ze2);
        }



    }
}
