package c07;

//: PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.
abstract class Glyph {
    abstract void draw();
    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
class RoundGlyph extends Glyph {
    int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        System.out.println(
                "RoundGlyph.RoundGlyph(), radius = "
                        + radius);
    }
    void draw() {
        System.out.println(
                "RoundGlyph.draw(), radius = " + radius);
    }
}

/**
 * (1) 在采取其他任何操作之前，为对象分配的存储空间初始化成二进制零。
 (2) 就象前面叙述的那样，调用基础类构建器。此时，被覆盖的 draw()方法会得到调用（的确是在
 RoundGlyph 构建器调用之前），此时会发现 radi us 的值为 0，这是由于步骤(1)造成的。
 (3) 按照原先声明的顺序调用成员初始化代码。
 (4) 调用衍生类构建器的主体。
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
} ///:
