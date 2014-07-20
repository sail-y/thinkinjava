/**********************************************************************
 * <p>文件名：ArrayInit.java </p>
 * <p>文件描述：TODO(描述该文件做什么)
 * @project_name：thinkinjava
 * @author yangfan
 * @date 2014/7/14 22:25
 * @history
 * @department：政务事业部
 * Copyright ChengDu Funi Cloud Code Technology Development CO.,LTD 2014
 *                    All Rights Reserved.
 */
package c04;

//: ArrayInit.java
// Array initialization
public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = {
                new Integer(1),
                new Integer( 2),
                new Integer(3),
        };
// Java 1.1 only:
        Integer[] b = new Integer[] {
                new Integer(1),
                new Integer(2),
                new Integer(3),
        };
    }
} ///: