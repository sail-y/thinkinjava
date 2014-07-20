package c07;
//: Sandwich.java
// Order of constructor calls
class Meal {
    Meal() { System.out.println("Meal()"); }
}
class Bread {
    Bread() { System.out.println("Bread()"); }
}
class Cheese {
    Cheese() { System.out.println("Cheese()"); }
}
class Lettuce {
    Lettuce() { System.out.println("Lettuce()"); }
}
class Lunch extends Meal {
    Lunch() { System.out.println("Lunch()");}
}
class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}
//先初始化父类构造方法，然后初始化成员变量，然后初始化本身构造方法

/**
 * (1) 调用基础类构建器。这个步骤会不断重复下去，首先得到构建的是分级结构的根部，然后是下一个衍生
 类，等等。直到抵达最深一层的衍生类。
 (2) 按声明顺序调用成员初始化模块。
 (3) 调用衍生构建器的主体。
 */
class Sandwich extends PortableLunch {
    Bread  b = new Bread();
    Cheese c = new Cheese();
    Lettuce l = new Lettuce();
    Sandwich() {
        System.out.println("Sandwich()");
    }
    public static void main(String[] args) {
        new Sandwich();
    }
} ///: