package c08;

import java.util.*;

public class ListIteration2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = new ArrayList<Integer>();
        ListIterator<Integer> it= list.listIterator(list.size());
        while(it.hasPrevious())
            list2.add(it.previous());
        System.out.println(list2);

    }
}
