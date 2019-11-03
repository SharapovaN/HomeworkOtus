package ru.otus.collections;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        var MyList = new DIYArrayList<Integer>();
        var ForCopy = new DIYArrayList<Integer>();

        for (int i = 25; i > 0; i--) {
            MyList.add(i);
        }

        for (int i = 100; i < 129; i++) {
            ForCopy.add(i);
        }

        MyList.printArray("Исходная коллекция: ");

        Collections.addAll(MyList, 45, 47, 48, 49);
        MyList.printArray("Коллекция после применения метода addAll: ");

        Collections.sort(MyList);
        MyList.printArray("Отсортированная коллекция: ");

        Collections.copy(ForCopy, MyList);
        MyList.printArray("Исходная коллекция 'MyList': ");
        ForCopy.printArray("Копия исходной коллекции 'ForCopy': ");
    }

}
