package ru.otus.atm;

public interface Cell {

    FaceValue getFaceValue();

    void add(BankNoteImpl bankNote);

    BankNoteImpl withdraw();

    int getCount();
}
