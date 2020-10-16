package com.example.lab4;

import com.example.lab4.Entity.Collection;
import com.example.lab4.Entity.Jewel;
import com.example.lab4.Service.CRUDJewelInt;
import com.example.lab4.UserInput.UserInput;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class ProgramLogic {

    private final CRUDJewelInt crudRepository;

    Scanner input = new Scanner(System.in);
    UserInput userInput = new UserInput();

    public ProgramLogic(CRUDJewelInt crudRepository) {
        this.crudRepository = crudRepository;
    }

    public void printAllJewels() {
        crudRepository.findAll().forEach(str -> System.out.println(str.toString()));
    }

    public void addNewJewel() {
        Jewel jew = Jewel.builder()
                .brandName(input.next())
                .cost(userInput.getInt(input))
                .collection(Collection.SPRING)
                .warranty(userInput.getInt(input)).build();
        crudRepository.add(jew);
    }

    public void updateJewel() {
        Optional<Jewel> optionalUser = crudRepository.findById((long) userInput.getInt(input));
        Jewel jewel = optionalUser.get();
        jewel.setBrandName("some");
        crudRepository.add(jewel);
        System.out.println(jewel.toString());
    }
    public void findByName() {
        crudRepository.findJewelsByBrandName("aaa").forEach(str -> System.out.println(str.toString()));
    }

    public void delete() {
        crudRepository.deleteById((long) (userInput.getInt(input)));
    }
}
