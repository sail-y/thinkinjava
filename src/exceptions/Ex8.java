package exceptions;

class MyClass {
    public void f() throws Exception{

    }
}

public class Ex8 {

    public static void main(String[] args) {
        MyClass m = new MyClass();
        try {
            m.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
