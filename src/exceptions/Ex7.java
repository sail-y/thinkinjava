package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;


public class Ex7 {

    public static void main(String[] args) {
        try{
            int[] arr = {1,2};
            int a = arr[2];
        }catch ( ArrayIndexOutOfBoundsException e){
            e.printStackTrace();

        }
    }
}
