package Baek;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {
        List<String> fruitLists = List.of("apple", "banana", "orange", "kiwi", "grape");

        List<String> filteredAndMappedFruits = fruitLists.stream()
                .filter(fruit -> fruit.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(filteredAndMappedFruits); // [BANANA, ORANGE]

        fruitLists.stream()
                .forEach(System.out::println);

        long fruitCount = fruitLists.stream()
                .count();
        System.out.println("과일 개수 : " + fruitCount);

        // flatMap, map 차이점

        // map : 각 요소를 새로운 값으로 매핑 && 요소 수가 동일하게 유지됨
        List<String> mappedWords = fruitLists.stream()
                .map(word -> word.split(""))
                .map(Arrays::toString)
                .collect(Collectors.toList());
        System.out.println(mappedWords); // [[a, p, p, l, e], [b, a, n, a, n, a], [o, r, a, n, g, e], [k, i, w, i], [g, r, a, p, e]]

        // flatMap : 각 요소를 병합하여 새로운 Stream을 생성함. && 요소 수나 구조가 변경될 수 있음
        List<String> flatMappedWords = fruitLists.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.toList());
        System.out.println(flatMappedWords); // [a, p, p, l, e, b, a, n, a, n, a, o, r, a, n, g, e, k, i, w, i, g, r, a, p, e]
    }
}
