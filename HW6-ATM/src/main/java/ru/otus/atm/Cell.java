package ru.otus.atm;

import java.util.ArrayList;

public class Cell {
    private final FaceValue faceValue;
    private ArrayList<BankNote> bankNotes = new ArrayList<BankNote>();
    private int count = 0;

    public Cell(FaceValue faceValue) {
        this.faceValue = faceValue;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    void add(BankNote bankNote) {
        if (faceValue.equals(bankNote.getFaceValue()))
            bankNotes.add(bankNote);
            count = bankNotes.size();
    }

    BankNote withdraw() {
        BankNote returnBankNote = null;
            if (count > 0) {
                returnBankNote = bankNotes.remove(bankNotes.size() - 1);
                count -= 1;

        }
        return returnBankNote;
    }

    public int getCount() {
        return count;
    }
}
