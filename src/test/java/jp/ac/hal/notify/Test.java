package jp.ac.hal.notify;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(3,4,2));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(4,6,5));
        LinkedList<String> list = new LinkedList<>();
        String reduce1 = list1.stream().map(Object::toString).reduce("", (a, b) -> a + b);
        String reduce2 = list2.stream().map(Object::toString).reduce("", (a, b) -> a + b);
        list.add(reduce1);
        list.add(reduce2);
        int sum = list.stream().mapToInt(Integer::parseInt).sum();
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(sum));
        String s1 = stringBuffer.reverse().toString();
        String[] strings = s1.split("");
        LinkedList<String> list3 = new LinkedList<>();
        for (String s : strings) {
            list3.add(s);
        }
        list3.forEach(s -> System.out.print(s));

    }

    public static void addTwoList(LinkedList<Integer> a, LinkedList<Integer> b){


        System.out.println();
    }
}
