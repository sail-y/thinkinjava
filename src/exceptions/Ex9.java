package exceptions;

class SuperException extends Exception{}
class Super2Exception extends SuperException{}
class Super3Exception extends Super2Exception{}

public class Ex9 {
    public static void main(String[] args) {
        try {
            throw new Super3Exception();
        }catch (SuperException e){
            e.printStackTrace();
        }

        try {
            throw new Super2Exception();
        }catch (SuperException e){
            e.printStackTrace();
        }

        try {
            throw new SuperException();
        }catch (SuperException e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}
