/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by YangFan on 2016/9/30 下午3:28.
 * <p/>
 */
public class GZIPPcompress {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(".gitignore"));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }

        in.close();
        out.close();

        System.out.println("Reading file");

        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
    }
}
