package exceptions;

public class Ex5 {
    public static void main(String[] args) {
        int i = 0;
        while(true){

            try {
                if(i < 100){
                    throw new Exception();
                }
                break;
            }catch (Exception e){
                System.out.println(i++);
            }
        }
    }
}
