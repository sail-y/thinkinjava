package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LogException1 extends Exception{
    Logger logger = Logger.getLogger("LogException1");
    LogException1() {
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
    }
}
class LogException2 extends Exception{
    Logger logger = Logger.getLogger("LogException2");
    LogException2() {
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
    }
}

public class Ex6 {
    public static void main(String[] args) {
        try{
            throw new LogException1();
        }catch (LogException1 e){

        }

        try{
            throw new LogException2();
        }catch (LogException2 e){

        }
    }
}
