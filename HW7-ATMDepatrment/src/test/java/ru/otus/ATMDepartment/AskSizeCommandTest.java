package ru.otus.ATMDepartment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AskSizeCommandTest {
    @Test
    public void AskSizeCommandTest() {
        DepartmentWithStartState department = new DepartmentWithStartState();
        AskSize sizeCommand = new AskSize(department);
        if(!sizeCommand.execute().equals(department.size())){
            throw new RuntimeException("Something wrong with AskSizeTest");
        }
    }


}