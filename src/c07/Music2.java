/**********************************************************************
 * <p>文件名：Music2.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/17 20:52
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c07;

//: Music2.java
// Overloading instead of upcasting
class Note2 {
    private int value;
    private Note2(int val) { value = val; }
    public static final Note2
            middleC = new Note2(0),
            cSharp = new Note2(1),
    cFlat = new Note2(2);
} // Etc.
class Instrument2 {
    public void play(Note2 n) {
        System.out.println("Instrument2.play()");
    }
}
class Wind2 extends Instrument2 {
    public void play(Note2 n) {
        System.out.println("Wind2.play()");
    }
}
class Stringed2 extends Instrument2 {
    public void play(Note2 n) {
        System.out.println("Stringed2.play()");
    }
}
class Brass2 extends Instrument2 {
    public void play(Note2 n) {
        System.out.println("Brass2.play()");
    }
}
public class Music2  {
    public static void tune(Wind2 i) {
        i.play(Note2.middleC);
    }
    public static void tune(Stringed2 i) {
        i.play(Note2.middleC);
    }
    public static void tune(Brass2 i) {
        i.play(Note2.middleC);
    }
    public static void main(String[] args) {
        Wind2 flute = new Wind2();
        Stringed2 violin = new Stringed2();
        Brass2 frenchHorn = new Brass2();
        tune(flute); // No upcasting
        tune(violin);
        tune(frenchHorn);
    }
} ///: