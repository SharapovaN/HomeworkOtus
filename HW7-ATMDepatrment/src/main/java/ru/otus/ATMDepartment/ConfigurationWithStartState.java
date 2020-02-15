package ru.otus.ATMDepartment;

public class ConfigurationWithStartState implements Configuration {
    @Override
    public Department params() {
        return new DepartmentWithStartState();
    }
}
