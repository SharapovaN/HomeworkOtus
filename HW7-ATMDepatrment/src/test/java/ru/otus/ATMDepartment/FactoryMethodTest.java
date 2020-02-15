package ru.otus.ATMDepartment;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryMethodTest {
    @Test
    public void CreateConfigurationFactoryTest() {
        Configuration config;
        config = ConfigurationFactory.getConfiguration("WithStartState");
        if (config.params().summa() == 0) {
            throw new RuntimeException("Something wrong with CreateConfigurationFactoryTest WithStartState case");
        }

        config = ConfigurationFactory.getConfiguration("ZeroStartState");
        if (config.params().summa() != 0) {
            throw new RuntimeException("Something wrong with CreateConfigurationFactoryTest ZeroStartState case");
        }

    }
}