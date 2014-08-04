package exceptions;

class Exception101 extends Exception{}
class Exception102 extends Exception{}

public class Ex10 {
    public void f() throws Exception102 {
        try {
            g();
        } catch (Exception101 exception101) {
            throw new Exception102();
        }
    }

    private void g() throws Exception101 {
        throw new Exception101();
    }

    public static void main(String[] args) {
        Ex10 e = new Ex10();
        try {
            e.f();
        } catch (Exception102 exception102) {
            exception102.printStackTrace();
        }
    }
}
