package org.example;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 왜 컬렉션에는 박싱된 타입이 들어가야 하는가? 왜 기본 타입이 들어가면 오류가 나는가?
        List<Integer> a = new ArrayList<>();

        a.add(1);
        a.add(6);
        a.add(3);

        a.isEmpty();


        System.out.println(a.contains(2));
        System.out.println(a.contains(1));
    }
}
