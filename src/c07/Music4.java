/**********************************************************************
 * <p>文件名：Music4.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/18 9:59
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c07;

//: Music4.java
// Abstract classes and methods
import java.util.*;
abstract class Instrument4 {
    int i; // storage allocated for each
    public abstract void play();
    public String what() {
        return "Instrument4";
    }
    public abstract void adjust();
}
class Wind4 extends Instrument4 {
    public void play() {
        System.out.println("Wind4.play()");
    }
    public String what() { return "Wind4"; }
    public void adjust() {}
}
class Percussion4 extends Instrument4 {
    public void play() {
        System.out.println("Percussion4.play()");
    }
    public String what() { return "Percussion4"; }
    public void adjust() {}
}
class Stringed4 extends Instrument4 {
    public void play() {
        System.out.println("Stringed4.play()");
    }
    public String what() { return "Stringed4"; }
    public void adjust() {}
}
class Brass4 extends Wind4 {
    public void play() {
        System.out.println("Brass4.play()");
    }
    public void adjust() {
        System.out.println("Brass4.adjust()");
    }
}
class Woodwind4 extends Wind4 {
    public void play() {
        System.out.println("Woodwind4.play()");
    }
    public String what() { return "Woodwind4"; }
}
public class Music4 {
    // Doesn't care about type, so new types
// added to the system still work right:
    static void tune(Instrument4 i) {
// ...
        i.play();
    }
    static void tuneAll(Instrument4[] e) {
        for(int i = 0; i < e.length; i++)
            tune(e[i]);
    }
    public static void main(String[] args) {
        Instrument4[] orchestra = new Instrument4[5];
        int i = 0;
// Upcasting during addition to the array:
        orchestra[i++] = new Wind4();
        orchestra[i++] = new Percussion4();
        orchestra[i++] = new Stringed4();
        orchestra[i++] = new Brass4();
        orchestra[i++] = new Woodwind4();
        tuneAll(orchestra);
    }
} ///: