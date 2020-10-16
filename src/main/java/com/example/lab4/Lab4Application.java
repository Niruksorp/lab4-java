package com.example.lab4;

import com.example.lab4.MenuView.Menu;
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
        Menu menuView = new Menu();
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            menuView.printMenu();
            System.out.println("Введите команду! \n");
            switch (userInput.getInt(input)){
                case 1: {
                    programLogic.printAllJewels();
                    break;
                }
                case 2: {
                    programLogic.delete((long) userInput.getInt(input));
                    break;
                }
                case 3: {
                    programLogic.findByName(input.next());
                    break;
                }
                case 4: {
                    programLogic.addNewJewel();
                    break;
                }
                case 5: {
                    programLogic.updateJewel((long) userInput.getInt(input));
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


}
