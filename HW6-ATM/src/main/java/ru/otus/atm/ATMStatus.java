package ru.otus.atm;


public class ATMStatus {
    private static Integer handredCounter = 0;
    private static Integer fiveHandredCounter = 0;
    private static Integer thousandCounter = 0;
    private static Integer fiveThousandCounter = 0;
    private static Integer summ = 0;



    public static Integer getHandredCounter() {
        return handredCounter;
    }

    public static Integer getFiveHandredCounter() {
        return fiveHandredCounter;
    }

    public static Integer getThousandCounter() {
        return thousandCounter;
    }

    public static Integer getFiveThousandCounter() {
        return fiveThousandCounter;
    }

    public static Integer getSumm() {
        return summ;
    }

    public static void setHandredCounter(Integer handredCounter) {
        ATMStatus.handredCounter = handredCounter;
    }

    public static void setFiveHandredCounter(Integer fiveHandredCounter) {
        ATMStatus.fiveHandredCounter = fiveHandredCounter;
    }

    public static void setThousandCounter(Integer thousandCounter) {
        ATMStatus.thousandCounter = thousandCounter;
    }

    public static void setFiveThousandCounter(Integer fiveThousandCounter) {
        ATMStatus.fiveThousandCounter = fiveThousandCounter;
    }

    public static void setSumm(Integer summ) {
        ATMStatus.summ = summ;
    }

}
