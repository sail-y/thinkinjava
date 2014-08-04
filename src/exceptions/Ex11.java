package exceptions;

public class Ex11 {
    public void f() {
        try {
            g();
        } catch (Exception101 exception101) {
            throw new RuntimeException(exception101);
        }
    }

    private void g() throws Exception101 {
        throw new Exception101();
    }

    public static void main(String[] args) {
        Ex11 e11 = new Ex11();
        try {
            e11.f();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
