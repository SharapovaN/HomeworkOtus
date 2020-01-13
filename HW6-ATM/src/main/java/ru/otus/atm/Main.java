package ru.otus.atm;

public class Main {
    public static void main(String[] args) {
    ATMImpl atmImpl =new ATMImpl();
    CellImpl hundredCell=new CellImpl(FaceValue.HUNDRED);
    CellImpl fiveThousandCell=new CellImpl(FaceValue.FIVETHOUSAND);
    CellImpl thousandCell=new CellImpl(FaceValue.THOUSAND);
    CellImpl fiveHundredCell=new CellImpl(FaceValue.FIVEHUNDRED);

    atmImpl.addCell(hundredCell.getFaceValue(),hundredCell);
    atmImpl.addCell(fiveHundredCell.getFaceValue(),fiveHundredCell);
    atmImpl.addCell(thousandCell.getFaceValue(), thousandCell);
    atmImpl.addCell(fiveThousandCell.getFaceValue(),fiveThousandCell);

    BankNoteImpl[] bankNotes=new BankNoteImpl[]{new BankNoteImpl(FaceValue.HUNDRED),new BankNoteImpl(FaceValue.FIVEHUNDRED),new BankNoteImpl(FaceValue.THOUSAND),new BankNoteImpl(FaceValue.FIVETHOUSAND)};

    atmImpl.addBanknotes(bankNotes);

        System.out.println("Количество банкнот номинала '100' - "+ hundredCell.getCount());
        System.out.println("Количество банкнот номинала '500' - "+fiveHundredCell.getCount());
        System.out.println("Количество банкнот номинала '1000' - "+thousandCell.getCount());
        System.out.println("Количество банкнот номинала '5000' - "+fiveThousandCell.getCount());

        System.out.println("Сумма денег в банкомате на данный момент - "+ atmImpl.summ());

        System.out.println("Результат операции 'снятие денег' -"+ atmImpl.withdrowBankNotes(1600));

        System.out.println("Количество банкнот номинала '100' - "+ hundredCell.getCount());
        System.out.println("Количество банкнот номинала '500' - "+fiveHundredCell.getCount());
        System.out.println("Количество банкнот номинала '1000' - "+thousandCell.getCount());
        System.out.println("Количество банкнот номинала '5000' - "+fiveThousandCell.getCount());

    }
}

