package ru.Otus;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        DIYArrayList<Integer> MyList = new DIYArrayList<>();
        DIYArrayList<Integer> ForCopy = new DIYArrayList<>();

        for (int i = 25; i > 0; i--) {
            MyList.add(i);
        }

        for (int i = 100; i < 129; i++) {
            ForCopy.add(i);
        }

        MyList.printArray("Исходная коллекция: ");

        MyList.addAll(MyList, 45, 47, 48, 49);
        MyList.printArray("Коллекция после применения метода addAll: ");

        MyList.sort(Integer::compareTo);
        MyList.printArray("Отсортированная коллекция: ");

        Collections.copy(ForCopy, MyList);
        MyList.printArray("Исходная коллекция 'MyList': ");
        ForCopy.printArray("Копия исходной коллекции 'ForCopy': ");
    }

}

