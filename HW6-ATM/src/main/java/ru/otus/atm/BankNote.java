package ru.otus.atm;

public class BankNote implements BanknoteInterface {
    private final FaceValue faceValue;

    public BankNote(FaceValue faceValue){
        this.faceValue=faceValue;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }
}
