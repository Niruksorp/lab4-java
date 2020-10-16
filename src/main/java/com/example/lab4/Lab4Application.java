package com.example.lab4;

import com.example.lab4.Entity.Collection;
import com.example.lab4.Entity.Jewel;
import com.example.lab4.Repository.JewelsRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Lab4Application {

    static public JewelsRepo jewelsRepo;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Lab4Application.class, args);
        jewelsRepo = ctx.getBean(JewelsRepo.class);

        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            printMenu();
            System.out.println("Введите команду! \n");
            switch (getInt(input)){
                case 1: {
                    jewelsRepo.findAll().forEach(str -> System.out.println(str.toString()));
                    break;
                }
                case 2: {
                    jewelsRepo.deleteById((long) (getInt(input)));
                    break;
                }
                case 3: {
                    jewelsRepo.findJewelsByBrandName("aaa").forEach(str -> System.out.println(str.toString()));
                    break;
                }
                case 4: {
                    Jewel jew = Jewel.builder()
                            .brandName(input.next())
                            .cost(getInt(input))
                            .collection(Collection.SPRING)
                            .warranty(getInt(input)).build();
                    jewelsRepo.save(jew);
                    break;
                }
                case 5: {
                    Optional<Jewel> optionalUser = jewelsRepo.findById((long) getInt(input));
                    Jewel jewel = optionalUser.get();
                    jewel.setBrandName("some");
                    jewelsRepo.save(jewel);
                    System.out.println(jewel.toString());
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
