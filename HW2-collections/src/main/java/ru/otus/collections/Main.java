package ru.otus.collections;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        var myList = new DIYArrayList<Integer>();
        var forCopy = new DIYArrayList<Integer>();

        for (int i = 25; i > 0; i--) {
            myList.add(i);
        }

        for (int i = 100; i < 129; i++) {
            forCopy.add(i);
        }
        System.out.println("Исходная коллекция: "+myList);
        System.out.println();

        Collections.addAll(myList, 45, 47, 48, 49);
        System.out.println("Коллекция после применения метода addAll: "+myList);
        System.out.println();

        Collections.sort(myList);
        System.out.println("Отсортированная коллекция: "+myList);
        System.out.println();

        Collections.copy(forCopy, myList);
        System.out.println("Копия исходной коллекции 'ForCopy': "+forCopy);

    }

}
