import org.apache.commons.lang3.StringUtils;

import java.lang.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortStringByNumberOfCharacters {
    public static void main(String[] args) {

        String input = "abbbbssmaa";


        //Convert to list
        List<Character> list = input.chars().mapToObj(a -> (char) a).sorted().toList();
        System.out.println(list);

        //Convert to map
        Map<Character, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        System.out.println("---------------------------part2-----------------------------");

        List<String> result = map.entrySet().stream()
                .sorted((char1, char2) -> char2.getValue().equals(char1.getValue()) ?
                        char2.getKey().compareTo(char1.getKey()) :
                        char2.getValue().compareTo(char1.getValue()))
                .map(characterLongEntry ->
                        StringUtils.repeat(characterLongEntry.getKey().toString()
                                , characterLongEntry.getValue().intValue())).toList();
        System.out.println(result);
    }

}