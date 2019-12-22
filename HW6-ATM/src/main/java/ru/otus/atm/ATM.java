package ru.otus.atm;

//Доступные номиналы 100,500,1000,5000

import java.util.*;

public class ATM implements ATMInterface {
    private Map<FaceValue, Cell> atm = new TreeMap<FaceValue, Cell>();
    private int summ = 0;

    public void addCell(FaceValue faceValue, Cell cell) {
        atm.put(faceValue, cell);
    }
    public Map<FaceValue, Cell> getAtm() {
        return atm;
    }

    public void addBanknotes(BankNote[] bankNotes) {
        for (BankNote bankNote : bankNotes) {
            if (atm.containsKey(bankNote.getFaceValue())) {
                atm.get(bankNote.getFaceValue()).add(bankNote);
            }
        }
    }

    public int summ() {
        if (atm.isEmpty() != true) {
            for (Map.Entry<FaceValue, Cell> entry : atm.entrySet()) {
                FaceValue faceValue = entry.getKey();
                Cell cell = entry.getValue();
                summ += faceValue.getValue() * cell.getCount();
            }
        }
        return summ;
    }

    public String withdrowBankNotes(int wanted) {
        var bankNotes = new ArrayList<Integer>();//создаем массив для хранения номиналов выдаваемых банкнот
        var faceValues = new ArrayList<FaceValue>();//создаем массив для хранения ключей
        var removedBanknotes = new ArrayList<BankNote>();
        faceValues.addAll(atm.keySet());//добавляем все ключи в массив
        if (wanted <= summ) {//если запрошенная сумма меньше суммы денег содержащихся в банкомате
            while (wanted != 0)//пока запрошенная сумма не равна нулю

                if (wanted >= faceValues.get(faceValues.size() - 1).getValue() && atm.get(faceValues.get(faceValues.size() - 1)).getCount() > 0) {//нужная сумма больше номинала и в ячейке что то есть
                    bankNotes.add(faceValues.get(faceValues.size() - 1).getValue());//в массив банкнот добавляем номинал банкноты
                    removedBanknotes.add(atm.get(faceValues.get(faceValues.size() - 1)).withdraw());//удаляем одну банкноту из ячейки
                    wanted -= faceValues.get(faceValues.size() - 1).getValue();//нужная сумма стала меньше на номинал выданной банкноты

                } else {

                    if (faceValues.size() > 0) {
                        faceValues.remove(faceValues.size() - 1);
                    }

                    if (wanted != 0 && faceValues.size() == 0) {//если нужная сумма не 0 а все возможне ячейки проверили

                        for (int i = 0; i < removedBanknotes.size(); i++) {//для каждого значения номинала банкноты
                            BankNote bankNote = removedBanknotes.get(i);
                            atm.get(bankNote.getFaceValue()).add(bankNote);
                        }
                        wanted = 0;
                        return "Невозможно выдать выбранную сумму из за отсутствия нужных номиналов банкнот";
                    }
                }
            if (bankNotes.size() > 0)
                return Arrays.toString(bankNotes.toArray(new Integer[bankNotes.size()]));
        }
        return "В банкомате недостаточно средств";
    }
}

