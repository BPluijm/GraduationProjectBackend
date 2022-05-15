package com.graduation.backend.controller;

import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.service.TravelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.*;
import java.util.List;

@RestController
public class TravelsController {

    @Autowired
    TravelsService service;


    @GetMapping("/travels")
    ResponseEntity<Object> getTravels() {
        List<TravelsDto> td = service.getTravels();
        return new ResponseEntity<>(td, HttpStatus.OK);
    }

    @GetMapping("/travels/{id}")
    ResponseEntity<Object> getTravelsById (@PathVariable Long id) {
        return new ResponseEntity<>(service.getTravelsById(id), HttpStatus.OK);
    }

    @PostMapping("/travels")
    public ResponseEntity<Object> createTravels(@Valid @RequestBody TravelsDto trdto, BindingResult br)  {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.createTravels(trdto);
            return new ResponseEntity<>("Trip created!", HttpStatus.CREATED);
        }
    }

//    @PostMapping("/travels/{id}/favorites")
//    ResponseEntity<Object> createTravels(@PathVariable Long id) {
//        return new ResponseEntity<>(service.addFavorites(id), HttpStatus.CREATED);
//    }


    @PutMapping("travels/{id}")
    ResponseEntity<Object> updateTravels (@PathVariable Long id, @Valid @RequestBody TravelsDto tdto , BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error);
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.updateTravels(tdto, id), HttpStatus.OK);
        }
    }

    @DeleteMapping("travels/{id}")
    ResponseEntity<Object> deleteTravels (@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteTravels(id), HttpStatus.OK);
    }
}
