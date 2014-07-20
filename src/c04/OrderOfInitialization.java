/**********************************************************************
 * <p>文件名：OrderOfInitialization.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 21:37
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c04;
//: OrderOfInitialization.java
// Demonstrates initialization order.
// When the constructor is called, to create a
// Tag object, you'll see a message:
class Tag {
    Tag(int marker) {
        System.out.println("Tag(" + marker + ")");
    }
}
class Card {
    Tag t1 = new Tag(1); // Before constructor
    Card() {
// Indicate we're in the constructor:
        System.out.println("Card()");
        t3 = new Tag(33); // Re -initialize t3
    }
    Tag t2 = new Tag(2); // After constructor
    void f() {
        System.out.println("f()");
    }
    Tag t3 = new Tag(3); // At end
}
public class OrderOfInitialization {
    public static void main(String[] args) {
        Card t = new Card();
        t.f(); // Shows that construction is done
    }
} ///:~
