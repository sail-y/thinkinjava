package exceptions;

class StrExcpetion extends Exception{
    String message;
    public StrExcpetion(String message) {
        super(message);
        this.message = message;
    }

    public void p(){
        System.out.println(message);
    }
}

public class Ex4 {
    public static void main(String[] args) {
        try{
            throw new  StrExcpetion("hi");
        }catch (StrExcpetion e ){
            e.p();
        }

    }
}
