package ru.otus.atm;

public interface ATMInterface {

    void addCell(FaceValue faceValue, Cell cell);

    void addBanknotes(BankNote[] bankNotes);

    int summ();

    String withdrowBankNotes(int wanted);
}

