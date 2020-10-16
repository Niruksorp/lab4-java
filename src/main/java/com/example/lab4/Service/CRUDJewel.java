package com.example.lab4.Service;

import com.example.lab4.Entity.Jewel;
import com.example.lab4.Repository.JewelsRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CRUDJewel implements CRUDJewelInt {

    private final JewelsRepo jewelsRepo;

    CRUDJewel(JewelsRepo jewelsRepo) {
        this.jewelsRepo = jewelsRepo;
    }

    public void create(Jewel jewel) {
        jewelsRepo.save(jewel);
    }
    public ArrayList<Jewel> read() {
        return new ArrayList<>(jewelsRepo.findAll());
    }
    public void update(Jewel jewel) {
        jewelsRepo.save(jewel);
    }
    public void delete(Long id) {
        jewelsRepo.deleteById(id);
    }
}
