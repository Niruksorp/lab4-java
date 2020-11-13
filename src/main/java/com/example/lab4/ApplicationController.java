package com.example.lab4;

import com.example.lab4.Entity.Jewel;
import com.example.lab4.Service.CRUDJewel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Controller
@RequestMapping("")
public class ApplicationController {

    private final CRUDJewel crudJewel;

    public ApplicationController(CRUDJewel crudJewel) {
        this.crudJewel = crudJewel;
    }

    @GetMapping("/getAllValue")
    public String getAll(Model model) {
        model.addAttribute("allJewels", crudJewel.findAll());
         return "jewel/index";
    }

    @DeleteMapping("/deleteValue/")
    public void delete(@RequestBody Long id) {
        crudJewel.deleteById(id);
    }

    @PostMapping("/addNewValue")
    public void add(@RequestBody Jewel jewel) {
        crudJewel.add(jewel);
    }

    @PutMapping("/updateValue")
    public void update(@RequestBody Jewel jewel) {
        crudJewel.update(jewel);
    }

    @GetMapping("/getByBrandName")
    public ResponseEntity<ArrayList<Jewel>> findByBrandName(@RequestBody String name) {
        return ResponseEntity
                .ok(crudJewel.findJewelsByBrandName(name));
    }
}
