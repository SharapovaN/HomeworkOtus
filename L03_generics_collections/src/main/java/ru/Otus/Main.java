package ru.Otus;

public class Main {
    public static void main(String[] args) {

        DIYArrayList<Integer> MyList=new DIYArrayList<>();
        DIYArrayList<Integer> ForCopy=new DIYArrayList<>();

        for (int i=25;i>0;i--){
            MyList.add(i);
        }
        MyList.printArray("Исходная коллекция: ");

        MyList.addAll(MyList, 45,47,48,49);
        MyList.printArray("Коллекция после применения метода addAll: ");

        MyList.copy(MyList, ForCopy);
        MyList.printArray("Исходная коллекция 'MyList': ");
        ForCopy.printArray("Копия исходной коллекции 'ForCopy': ");

        MyList.sort(Integer::compareTo);
        MyList.printArray("Отсортированная коллекция: ");

    }

}

