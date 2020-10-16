package com.example.lab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Lab4Application {

    static public ProgramLogic programLogic;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Lab4Application.class, args);
        programLogic = ctx.getBean(ProgramLogic.class);

        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            printMenu();
            System.out.println("Введите команду! \n");
            switch (getInt(input)){
                case 1: {
                    programLogic.printAllJewels();
                    break;
                }
                case 2: {
                    programLogic.delete();
                    break;
                }
                case 3: {
                    programLogic.findByName();
                    break;
                }
                case 4: {
                    programLogic.addNewJewel();
                    break;
                }
                case 5: {
                    programLogic.updateJewel();
                    break;
                }
                case 6: {
                    loop  = false;
                    return;
                }
                default: System.out.println("Неправильно введено значение\n");
            }
        }
    }
    public static void printMenu () {
        String menu =
                "1. Вывод всей информации, что лежит в базе. \n"
                + "2. Удалим по ID?. \n"
                + "3. Вывод драгоценностей, по конкретной стоимости  \n"
                + "4. Редактирование по ID \n"
                + "5. Выход из программы";
        System.out.println(menu);
    }

    public static int getInt(final Scanner scanner) {
        System.out.println("Введити число");
        boolean flag = false;
        while (!flag) {
            if (scanner.hasNextInt()) return scanner.nextInt();
            scanner.next();
            System.out.println("Введите значение");
        }
        return -1;
    }

}
