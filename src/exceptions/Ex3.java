package exceptions;

public class Ex3 {
    public static void main(String[] args) {
        try{
            int[] arr = {1,2};
            int a = arr[2];
        }catch ( ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
