package com.example.lab4.Service;

import com.example.lab4.Entity.Jewel;
import com.sun.istack.NotNull;

import java.util.ArrayList;

public interface CRUDJewelInt {
    void create(@NotNull Jewel jewel);
    ArrayList<Jewel> read();
    void update(@NotNull Jewel jewel);
    void delete(@NotNull Long id);
}
