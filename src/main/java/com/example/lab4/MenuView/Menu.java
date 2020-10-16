package com.example.lab4.MenuView;

public class Menu {
    public void printMenu () {
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
