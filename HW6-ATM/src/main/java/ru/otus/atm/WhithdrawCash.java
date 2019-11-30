package ru.otus.atm;

import java.util.ArrayList;
import java.util.Scanner;

public class WhithdrawCash extends ATMStatus {

    public static void WhithdrawCash() {
        Integer gFTC=getFiveThousandCounter();
        Integer gTC=getThousandCounter();
        Integer gFHC=getFiveHandredCounter();
        Integer gHC=getHandredCounter();

        var cash=new ArrayList<Integer>();

        Integer summ = getSumm();
        System.out.println("Сколько денег Вы хотите  снять? ");
        Scanner in = new Scanner(System.in);
        Integer wantedCash = in.nextInt();

        if (wantedCash > summ) {
            System.out.println("В АТМ недостаточно средств для снятия этой суммы");
        }



        while (wantedCash > 0) {

            if (wantedCash >= 5000 && gFTC>0) {
                summ-=5000;
                wantedCash -= 5000;
                setFiveThousandCounter(gFTC--);
                cash.add(5000);
            }else{
                if(wantedCash>=1000&&gTC>0){
                    summ-=1000;
                    wantedCash-=1000;
                    setThousandCounter(gTC--);
                    cash.add(1000);
                }else{
                    if(wantedCash>=500&&gFHC>0){
                        summ-=500;
                        wantedCash-=500;
                        setFiveHandredCounter(gFHC--);
                        cash.add(500);
                    }else{
                        if(wantedCash>=100&&gHC>0){
                            summ-=100;
                            wantedCash-=100;
                            setHandredCounter(gHC--);
                            cash.add(100);
                        }else{
                            System.out.println("Невозможно выдать выбранную сумму, отсутствуют купюры нужного номинала");
                            break;
                        }
                    }
                }
            }
        }
        if(wantedCash==0){
            System.out.println("Заберите деньги: "+cash);
            setSumm(summ);
        }
    }
}