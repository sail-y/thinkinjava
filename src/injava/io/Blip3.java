/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.io;

import java.io.*;

/**
 * Created by YangFan on 2016/9/30 下午5:03.
 * <p/>
 */
public class Blip3 implements Externalizable {
    private int i;
    private String s;

    public Blip3() {
        System.out.println("Blip3 Constructor");
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blip3 b3 = new Blip3("A String", 47);
        System.out.println(b3);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));

        System.out.println("saving");
        out.writeObject(b3);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }
}
