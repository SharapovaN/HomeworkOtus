package ru.otus.atm;

import java.util.Scanner;

public  class Console extends ATMStatus{

private static Integer operation=0;

    public static void  run(){

        System.out.println("1 - внести деньги на счет; 2 - получить деньги со счета; 3 - узнать остаток на счете; 4 - прекратить работу АТМ");

        while (operation != 4) {

            System.out.print("Выберите действие: ");
            Scanner in = new Scanner(System.in);
            operation = in.nextInt();

            if (operation == 1) {
                AddCash.AddCash();
            }

            if (operation == 2) {
                WhithdrawCash.WhithdrawCash();
            }

            if (operation == 3) {
                System.out.println(getSumm());
            }

            if (operation!=4&&operation != 3 && operation != 2 && operation != 1) {
                System.out.println("Операция недоступна");
            }
        }
        System.out.println("АТМ завершил работу");
    }
}
