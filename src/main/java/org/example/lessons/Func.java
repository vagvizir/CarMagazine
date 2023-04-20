package org.example.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Func {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        // 1 2 3 4 5 -> filter -> 4 5 -> for
//        integers.stream().filter(i -> i > 3).forEach(Func::pr);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> c = f.compose(g);
        Function<Integer, Integer> d = f.andThen(g);

//        function(f, integers);
//        function(g, integers);
//        function(d, integers);
        function(i -> i + 1, integers);
    }

    static void pr(int i) {
        System.out.println(i + 1);
    }
    static void function(Function<Integer, Integer> function, List<Integer> integers) {
        for (Integer integer : integers) {
            System.out.println(function.apply(integer));
        }
    }
}
