package ru.otus.gc;

import java.util.ArrayList;

class Benchmark implements BenchmarkMBean {

    private int size = 0;
    private Integer e = 0;

    void run() throws InterruptedException {

        int n = 10000;
        var list = new ArrayList<Integer>();
        while (list.size() < size) {

            for (int i = list.size(); i < n; i++) {
                list.add(e);
                e++;
            }
            System.out.println("Создан лист размера: "+list.size()+" элементов");

            Thread.sleep(5000);

            list.subList(0, (int) (list.size() * 0.7)).clear();
            System.out.println("Лист уменьшен до размера: "+list.size()+" элементов");
            n = list.size() * 4;

        }


    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        System.out.println("new size:" + size);
        this.size = size;
    }

}
