package ru.otus.atm;

public interface CellInterface {

    FaceValue getFaceValue();

    void add(BankNote bankNote);

    BankNote withdraw();

    int getCount();
}
