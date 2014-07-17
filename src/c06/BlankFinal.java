/**********************************************************************
 * <p>文件名：BlankFinal.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/17 16:13
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c06;
//: BlankFinal.java
// "Blank" final data members
class Poppet { }
class BlankFinal {
    final int i = 0; // Initialized final
    final int j; // Blank final
    final  Poppet p; // Blank final handle
    // Blank finals MUST be initialized
// in the constructor:
    BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet();
    }
    BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet();
    }
    public static void main(String[] args) {
        BlankFinal bf = new BlankFinal();
    }
} ///: