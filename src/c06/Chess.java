/**********************************************************************
 * <p>文件名：Chess.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/16 16:16
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c06;

//: Chess.java
// Inheritance, constructors and arguments
class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}
class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}
public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
    public static void main(String[] args) {
        Chess x = new Chess();
    }
} ///: