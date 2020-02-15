package ru.otus.ATMDepartment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationWithStartStateTest {
    @Test
    public void ConfigurationWithStartStateCreationTest() {
        ConfigurationWithStartState configuration = new ConfigurationWithStartState();
        Assert.assertTrue(configuration.params().getClass().toString().contains("DepartmentWithStartState"));
    }

}