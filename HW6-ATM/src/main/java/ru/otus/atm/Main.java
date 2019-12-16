package ru.otus.atm;

public class Main {
    public static void main(String[] args) {
    ATM atm=new ATM();
    Cell hundredCell=new Cell(FaceValue.HUNDRED);
    Cell fiveThousandCell=new Cell(FaceValue.FIVETHOUSAND);
    Cell thousandCell=new Cell(FaceValue.THOUSAND);
    Cell fiveHundredCell=new Cell(FaceValue.FIVEHUNDRED);

    atm.addCell(hundredCell.getFaceValue(),hundredCell);
    atm.addCell(fiveHundredCell.getFaceValue(),fiveHundredCell);
    atm.addCell(thousandCell.getFaceValue(), thousandCell);
    atm.addCell(fiveThousandCell.getFaceValue(),fiveThousandCell);

    BankNote[] bankNotes=new BankNote[]{new BankNote(FaceValue.HUNDRED),new BankNote(FaceValue.FIVEHUNDRED),new BankNote(FaceValue.THOUSAND),new BankNote(FaceValue.FIVETHOUSAND)};

    atm.addBanknotes(bankNotes);

        System.out.println("Количество банкнот номинала '100' - "+ hundredCell.getCount());
        System.out.println("Количество банкнот номинала '500' - "+fiveHundredCell.getCount());
        System.out.println("Количество банкнот номинала '1000' - "+thousandCell.getCount());
        System.out.println("Количество банкнот номинала '5000' - "+fiveThousandCell.getCount());

        System.out.println("Сумма денег в банкомате на данный момент - "+atm.summ());

        System.out.println("Результат операции 'снятие денег' -"+atm.withdrowBankNotes(1600));

        System.out.println("Количество банкнот номинала '100' - "+ hundredCell.getCount());
        System.out.println("Количество банкнот номинала '500' - "+fiveHundredCell.getCount());
        System.out.println("Количество банкнот номинала '1000' - "+thousandCell.getCount());
        System.out.println("Количество банкнот номинала '5000' - "+fiveThousandCell.getCount());

    }
}
enum FaceValue{
    HUNDRED(100),
    FIVEHUNDRED(500),
    THOUSAND(1000),
    FIVETHOUSAND(5000);

    private final int value;

    FaceValue(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }



}
