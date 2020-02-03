package ru.otus.ATMDepartment;

public class ConfigurationZeroStartState implements Configuration {
    @Override
    public Department params() {
        return new DepartmentZeroStartState();
    }
}
