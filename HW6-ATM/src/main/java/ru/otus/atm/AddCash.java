package ru.otus.atm;

import java.util.Scanner;

public class AddCash extends ATMStatus{

    public static void AddCash() {
        System.out.println("Сколько купюр Вы планируете внести? ");
        Scanner c=new Scanner(System.in);
        Integer count=c.nextInt();

        while (count>0) {
            System.out.println("Внесите купюры по одной: ");
            Scanner in = new Scanner(System.in);
            Integer bill = in.nextInt();

            if(bill==100||bill==500||bill==1000||bill==5000) {

                if (bill == 100) {
                    Integer n = getHandredCounter();
                    n++;
                    setHandredCounter(n);
                    Integer s = getSumm();
                    s += 100;
                    setSumm(s);
                    count--;
                }
                if (bill == 500) {
                    Integer n = getFiveHandredCounter();
                    n++;
                    setFiveHandredCounter(n);
                    Integer s = getSumm();
                    s += 500;
                    setSumm(s);
                    count--;
                }
                if (bill == 1000) {
                    Integer n = getThousandCounter();
                    n++;
                    setThousandCounter(n);
                    Integer s = getSumm();
                    s += 1000;
                    setSumm(s);
                    count--;
                }
                if (bill == 5000) {
                    Integer n = getFiveThousandCounter();
                    n++;
                    setFiveThousandCounter(n);
                    Integer s = getSumm();
                    s += 5000;
                    setSumm(s);
                    count--;
                }
            }else{
                System.out.println("Номинал не распознан,замените купюру");
            }

        }
    }
}
