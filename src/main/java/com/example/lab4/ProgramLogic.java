package com.example.lab4;

import com.example.lab4.Entity.Collection;
import com.example.lab4.Entity.Jewel;
import com.example.lab4.Service.CRUDJewelInt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

import static com.example.lab4.Lab4Application.getInt;

@Service
public class ProgramLogic {

    private final CRUDJewelInt crudRepository;

    Scanner input = new Scanner(System.in);


    public ProgramLogic(CRUDJewelInt crudRepository) {
        this.crudRepository = crudRepository;
    }

    public void printAllJewels() {
        crudRepository.findAll().forEach(str -> System.out.println(str.toString()));
    }

    public void addNewJewel() {
        Jewel jew = Jewel.builder()
                .brandName(input.next())
                .cost(getInt(input))
                .collection(Collection.SPRING)
                .warranty(getInt(input)).build();
        crudRepository.add(jew);
    }

    public void updateJewel() {
        Optional<Jewel> optionalUser = crudRepository.findById((long) getInt(input));
        Jewel jewel = optionalUser.get();
        jewel.setBrandName("some");
        crudRepository.add(jewel);
        System.out.println(jewel.toString());
    }
    public void findByName() {
        crudRepository.findJewelsByBrandName("aaa").forEach(str -> System.out.println(str.toString()));
    }

    public void delete() {
        crudRepository.deleteById((long) (getInt(input)));
    }
}
