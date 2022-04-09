package com.graduation.backend.controller;

import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.service.FutureTravelsService;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class FutureTravelsController {
    private final FutureTravelsService service;

    public FutureTravelsController(FutureTravelsService service) {

        this.service = service;
    }

    @GetMapping("/future-travels")
    public ResponseEntity<Object> getTrips() {
        List<FutureTravelsDto> ld = service.getFutureTravels();
        return new ResponseEntity<>(ld, HttpStatus.OK);
    }

    @PostMapping("/future-travels")
    public ResponseEntity<Object> createFutureTravels(@Valid @RequestBody FutureTravelsDto ftdto, BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.createFutureTravels(ftdto);
            return new ResponseEntity<>("Future Travel created!", HttpStatus.CREATED);
        }
    }
}