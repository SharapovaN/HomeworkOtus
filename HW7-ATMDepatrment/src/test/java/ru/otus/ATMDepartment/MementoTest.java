package ru.otus.ATMDepartment;

import org.junit.Test;
import ru.otus.atm.BankNoteImpl;
import ru.otus.atm.FaceValue;

import static org.junit.Assert.*;

public class MementoTest {

    @Test
    public void MementoTest() {
        DepartmentWithStartState department = new DepartmentWithStartState();
        int startSumm = department.getSumm();
        State abc = new State(department);
        Originator originator = new Originator();

        originator.saveState(abc);

        abc.getArray().get(0).addBanknotes(new BankNoteImpl[]{new BankNoteImpl(FaceValue.HUNDRED)});

        abc.getArray().get(0).addBanknotes(new BankNoteImpl[]{new BankNoteImpl(FaceValue.HUNDRED)});

        abc.getArray().get(0).addBanknotes(new BankNoteImpl[]{new BankNoteImpl(FaceValue.HUNDRED)});

        abc = originator.restoreState();
        if (abc.getArray().summa() != startSumm) {
            throw new RuntimeException("Something wrong with MementoTest");
        }
    }

}