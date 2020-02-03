package ru.otus.ATMDepartment;

import org.junit.Assert;
import org.junit.Test;
import ru.otus.atm.BankNoteImpl;
import ru.otus.atm.FaceValue;

import static org.junit.Assert.*;

public class AskSummCommandTest {
    @Test
    public void AskSummCommandTest() {
        DepartmentWithStartState department = new DepartmentWithStartState();
        BankNoteImpl[] banknotesForAdding = new BankNoteImpl[]{new BankNoteImpl(FaceValue.HUNDRED)};
        AskSumm sumCommand = new AskSumm(department);
        Assert.assertTrue(sumCommand.execute().equals(department.getSumm()));

        int newSumm = department.getSumm() + 100;
        department.get(0).addBanknotes(banknotesForAdding);
        AskSumm sumCommand2 = new AskSumm(department);
        Assert.assertTrue(sumCommand2.execute().equals(newSumm));

    }
}