package com.example.lab4;

import com.example.lab4.UserInput.UserInput;
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
        UserInput userInput = new UserInput();
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            printMenu();
            System.out.println("Введите команду! \n");
            switch (userInput.getInt(input)){
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
                + "3. Найти драгоценности определенной компании  \n"
                + "4. Добавить новую ювелирку. Сезон - весенний \n"
                + "5. Изменить данные по ID \n"
                + "6. Выйти из проограммы. Пока - пока";
        System.out.println(menu);
    }

}
