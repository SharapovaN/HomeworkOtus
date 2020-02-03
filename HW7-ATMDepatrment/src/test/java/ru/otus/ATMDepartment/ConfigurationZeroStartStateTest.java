package ru.otus.ATMDepartment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationZeroStartStateTest {
    @Test
    public void ConfigurationZeroStartStateCreationTest() {
        ConfigurationZeroStartState configuration = new ConfigurationZeroStartState();
        Assert.assertTrue(configuration.params().getClass().toString().contains("DepartmentZeroStartState"));
    }

}