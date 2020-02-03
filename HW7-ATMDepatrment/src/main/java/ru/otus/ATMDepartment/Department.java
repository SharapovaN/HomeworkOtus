package ru.otus.ATMDepartment;

import ru.otus.atm.ATMImpl;

public interface Department {
    int summa();

    ATMImpl get(int i);

    int size();
}
