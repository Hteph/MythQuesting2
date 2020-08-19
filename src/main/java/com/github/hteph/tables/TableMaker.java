package com.github.hteph.tables;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TableMaker {

    private static Random random;

    static {
        random = new Random();
    }

    public static <E> E makeRoll(int roll, int[] numbers, E[] entries) {

        E result = null;
        if (numbers != null && numbers.length > 0 && entries != null && entries.length >= numbers.length) {
            TreeMap<Integer, E> map = new TreeMap<>(putIntoMap(numbers, entries));
            try {
                if (roll < map.firstKey()) roll = map.firstKey();
                result = map.get(map.floorKey(roll));
            } catch (Exception e) {
                result = entries[0];
            }
        }
        return result;
    }

    public static <E> E makeRoll(int roll, int[] numbers, List<E> entries) {

        E result = null;
        if (numbers != null && numbers.length > 0 && entries != null && (entries.size() >= numbers.length)) {
            TreeMap<Integer, E> map = new TreeMap<>(putIntoMap(numbers, entries));
            try {
                if (roll < map.firstKey()) roll = map.firstKey();
                result = map.get(map.floorKey(roll));
            } catch (Exception e) {
                result = entries.get(0);
            }
        }
        return result;
    }

    public static <E> E makeRoll(int roll, List<E> entries) {

        E result = null;
        if (entries != null) {
            if (roll > entries.size()) result = entries.get(entries.size() - 1);
            else if (roll > 0 && !entries.isEmpty()) result = entries.get(roll - 1);
        }
        return result;
    }

    public static <E> Optional<E> pickOne(List<E> entries) {

        E result = null;

        if (!entries.isEmpty()) {
            int roll = random.nextInt(entries.size()-1);
            result = entries.get(roll);
        }
        return Optional.ofNullable(result);

    }    public static <E> Optional<E> pickOne(E[] array) {

        E result = null;

        if (array != null && array.length>1) {
            int roll = random.nextInt( array.length-1);
            result = array[roll];
        } else if(array != null &&array.length==1) result=array[0];

        return Optional.ofNullable(result);
    }

    private static <E> Map<Integer, E> putIntoMap(int[] numbers, E[] array) {

        return IntStream.range(0, numbers.length)
                        .boxed()
                        .collect(Collectors.toMap(i -> numbers[i], i -> array[i]));
    }

    private static <E> Map<Integer, E> putIntoMap(int[] numbers, List<E> list) {

        return IntStream.range(0, numbers.length)
                        .boxed()
                        .collect(Collectors.toMap(i -> numbers[i], list::get));
    }
}

