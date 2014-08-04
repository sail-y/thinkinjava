package exceptions;


public class Ex2 {
    public static void main(String[] args) {
        try {
            String str = null;
            str.contains("1");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
