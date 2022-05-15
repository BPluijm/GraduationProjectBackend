package com.graduation.backend.controller;

import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.service.FutureTravelsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class FutureTravelsController {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    FutureTravelsService service;

    @GetMapping("/future-travels")
    public ResponseEntity<Object> getFutureTravels() {
        List<FutureTravelsDto> fd = service.getFutureTravels();
        return new ResponseEntity<>(fd, HttpStatus.OK);
    }

    @GetMapping("/future-travels/{id}")
    ResponseEntity<Object> getFutureTravelsById (@PathVariable Long id) {
        FutureTravelsDto ftd = service.getFutureTravelsById(id);
        return new ResponseEntity<>(ftd, HttpStatus.OK);
    }

//    @GetMapping("/future-travels/{id}/tips")
//    ResponseEntity<Object> getFutureTravelsTips(@PathVariable Long tipId, TravelTipsDto ttdt, MultipartFile tips) {
//        return new ResponseEntity<>(service.addTips(tipId,ttdt, tips), HttpStatus.CREATED);
//    }


    @PostMapping("/future-travels")
    public ResponseEntity<Object> createFutureTravels(@Valid @RequestBody FutureTravelsDto fut, BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.createFutureTravels(fut);
            return new ResponseEntity<>("Future Travel created!", HttpStatus.CREATED);
        }
    }


    @PutMapping("future-travels/{id}")
    ResponseEntity<Object> updateFutureTravels (@PathVariable Long id, @Valid @RequestBody FutureTravelsDto ftdto , BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error);
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.updateFutureTravels(ftdto, id), HttpStatus.OK);
        }
    }

    @DeleteMapping("future-travels/{id}")
    ResponseEntity<Object> deleteFutureTravels (@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteFutureTravels(id), HttpStatus.OK);
    }
}